
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 金融工具评价
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jinronggongjuCommentback")
public class JinronggongjuCommentbackController {
    private static final Logger logger = LoggerFactory.getLogger(JinronggongjuCommentbackController.class);

    private static final String TABLE_NAME = "jinronggongjuCommentback";

    @Autowired
    private JinronggongjuCommentbackService jinronggongjuCommentbackService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private JinronggongjuService jinronggongjuService;//金融工具
    @Autowired
    private JinronggongjuCollectionService jinronggongjuCollectionService;//金融工具收藏
    @Autowired
    private JinronggongjuOrderService jinronggongjuOrderService;//借款
    @Autowired
    private LicaichanpinService licaichanpinService;//理财产品
    @Autowired
    private LicaichanpinCollectionService licaichanpinCollectionService;//理财产品收藏
    @Autowired
    private LicaichanpinCommentbackService licaichanpinCommentbackService;//理财产品评价
    @Autowired
    private LicaichanpinOrderService licaichanpinOrderService;//理财产品订单
    @Autowired
    private YinhangkaService yinhangkaService;//银行卡
    @Autowired
    private YinhangkaCunkuanService yinhangkaCunkuanService;//存款
    @Autowired
    private YinhangkaJiluService yinhangkaJiluService;//银行卡记录
    @Autowired
    private YinhangkaQukuanService yinhangkaQukuanService;//取款
    @Autowired
    private YinhangkaZhuanzhangService yinhangkaZhuanzhangService;//转账
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jinronggongjuCommentbackService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuCommentbackView> list =(List<JinronggongjuCommentbackView>)page.getList();
        for(JinronggongjuCommentbackView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinronggongjuCommentbackEntity jinronggongjuCommentback = jinronggongjuCommentbackService.selectById(id);
        if(jinronggongjuCommentback !=null){
            //entity转view
            JinronggongjuCommentbackView view = new JinronggongjuCommentbackView();
            BeanUtils.copyProperties( jinronggongjuCommentback , view );//把实体数据重构到view中
            //级联表 金融工具
            //级联表
            JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(jinronggongjuCommentback.getJinronggongjuId());
            if(jinronggongju != null){
            BeanUtils.copyProperties( jinronggongju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJinronggongjuId(jinronggongju.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jinronggongjuCommentback.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JinronggongjuCommentbackEntity jinronggongjuCommentback, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jinronggongjuCommentback:{}",this.getClass().getName(),jinronggongjuCommentback.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jinronggongjuCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jinronggongjuCommentback.setCreateTime(new Date());
        jinronggongjuCommentback.setInsertTime(new Date());
        jinronggongjuCommentbackService.insert(jinronggongjuCommentback);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JinronggongjuCommentbackEntity jinronggongjuCommentback, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jinronggongjuCommentback:{}",this.getClass().getName(),jinronggongjuCommentback.toString());
        JinronggongjuCommentbackEntity oldJinronggongjuCommentbackEntity = jinronggongjuCommentbackService.selectById(jinronggongjuCommentback.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jinronggongjuCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jinronggongjuCommentback.getJinronggongjuCommentbackText()) || "null".equals(jinronggongjuCommentback.getJinronggongjuCommentbackText())){
                jinronggongjuCommentback.setJinronggongjuCommentbackText(null);
        }
        if("".equals(jinronggongjuCommentback.getReplyText()) || "null".equals(jinronggongjuCommentback.getReplyText())){
                jinronggongjuCommentback.setReplyText(null);
        }
        jinronggongjuCommentback.setUpdateTime(new Date());

            jinronggongjuCommentbackService.updateById(jinronggongjuCommentback);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JinronggongjuCommentbackEntity> oldJinronggongjuCommentbackList =jinronggongjuCommentbackService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jinronggongjuCommentbackService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JinronggongjuCommentbackEntity> jinronggongjuCommentbackList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JinronggongjuCommentbackEntity jinronggongjuCommentbackEntity = new JinronggongjuCommentbackEntity();
//                            jinronggongjuCommentbackEntity.setJinronggongjuId(Integer.valueOf(data.get(0)));   //金融工具 要改的
//                            jinronggongjuCommentbackEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jinronggongjuCommentbackEntity.setJinronggongjuCommentbackText(data.get(0));                    //评价内容 要改的
//                            jinronggongjuCommentbackEntity.setInsertTime(date);//时间
//                            jinronggongjuCommentbackEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            jinronggongjuCommentbackEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            jinronggongjuCommentbackEntity.setCreateTime(date);//时间
                            jinronggongjuCommentbackList.add(jinronggongjuCommentbackEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jinronggongjuCommentbackService.insertBatch(jinronggongjuCommentbackList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jinronggongjuCommentbackService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuCommentbackView> list =(List<JinronggongjuCommentbackView>)page.getList();
        for(JinronggongjuCommentbackView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinronggongjuCommentbackEntity jinronggongjuCommentback = jinronggongjuCommentbackService.selectById(id);
            if(jinronggongjuCommentback !=null){


                //entity转view
                JinronggongjuCommentbackView view = new JinronggongjuCommentbackView();
                BeanUtils.copyProperties( jinronggongjuCommentback , view );//把实体数据重构到view中

                //级联表
                    JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(jinronggongjuCommentback.getJinronggongjuId());
                if(jinronggongju != null){
                    BeanUtils.copyProperties( jinronggongju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJinronggongjuId(jinronggongju.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jinronggongjuCommentback.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JinronggongjuCommentbackEntity jinronggongjuCommentback, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jinronggongjuCommentback:{}",this.getClass().getName(),jinronggongjuCommentback.toString());
        jinronggongjuCommentback.setCreateTime(new Date());
        jinronggongjuCommentback.setInsertTime(new Date());
        jinronggongjuCommentbackService.insert(jinronggongjuCommentback);

            return R.ok();
        }

}

