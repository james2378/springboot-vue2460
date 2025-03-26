
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
 * 银行卡记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yinhangkaJilu")
public class YinhangkaJiluController {
    private static final Logger logger = LoggerFactory.getLogger(YinhangkaJiluController.class);

    private static final String TABLE_NAME = "yinhangkaJilu";

    @Autowired
    private YinhangkaJiluService yinhangkaJiluService;


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
    private JinronggongjuCommentbackService jinronggongjuCommentbackService;//金融工具评价
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
        PageUtils page = yinhangkaJiluService.queryPage(params);

        //字典表数据转换
        List<YinhangkaJiluView> list =(List<YinhangkaJiluView>)page.getList();
        for(YinhangkaJiluView c:list){
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
        YinhangkaJiluEntity yinhangkaJilu = yinhangkaJiluService.selectById(id);
        if(yinhangkaJilu !=null){
            //entity转view
            YinhangkaJiluView view = new YinhangkaJiluView();
            BeanUtils.copyProperties( yinhangkaJilu , view );//把实体数据重构到view中
            //级联表 银行卡
            //级联表
            YinhangkaEntity yinhangka = yinhangkaService.selectById(yinhangkaJilu.getYinhangkaId());
            if(yinhangka != null){
            BeanUtils.copyProperties( yinhangka , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYinhangkaId(yinhangka.getId());
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
    public R save(@RequestBody YinhangkaJiluEntity yinhangkaJilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yinhangkaJilu:{}",this.getClass().getName(),yinhangkaJilu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YinhangkaJiluEntity> queryWrapper = new EntityWrapper<YinhangkaJiluEntity>()
            .eq("yinhangka_id", yinhangkaJilu.getYinhangkaId())
            .eq("yinhangka_jilu_types", yinhangkaJilu.getYinhangkaJiluTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinhangkaJiluEntity yinhangkaJiluEntity = yinhangkaJiluService.selectOne(queryWrapper);
        if(yinhangkaJiluEntity==null){
            yinhangkaJilu.setInsertTime(new Date());
            yinhangkaJilu.setCreateTime(new Date());
            yinhangkaJiluService.insert(yinhangkaJilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YinhangkaJiluEntity yinhangkaJilu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yinhangkaJilu:{}",this.getClass().getName(),yinhangkaJilu.toString());
        YinhangkaJiluEntity oldYinhangkaJiluEntity = yinhangkaJiluService.selectById(yinhangkaJilu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yinhangkaJilu.getYinhangkaJiluContent()) || "null".equals(yinhangkaJilu.getYinhangkaJiluContent())){
                yinhangkaJilu.setYinhangkaJiluContent(null);
        }

            yinhangkaJiluService.updateById(yinhangkaJilu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YinhangkaJiluEntity> oldYinhangkaJiluList =yinhangkaJiluService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yinhangkaJiluService.deleteBatchIds(Arrays.asList(ids));

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
            List<YinhangkaJiluEntity> yinhangkaJiluList = new ArrayList<>();//上传的东西
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
                            YinhangkaJiluEntity yinhangkaJiluEntity = new YinhangkaJiluEntity();
//                            yinhangkaJiluEntity.setYinhangkaId(Integer.valueOf(data.get(0)));   //银行卡 要改的
//                            yinhangkaJiluEntity.setYinhangkaJiluUuidNumber(data.get(0));                    //记录卡号 要改的
//                            yinhangkaJiluEntity.setYinhangkaJiluTypes(Integer.valueOf(data.get(0)));   //银行卡记录类型 要改的
//                            yinhangkaJiluEntity.setYinhangkaJiluJine(data.get(0));                    //记录金额 要改的
//                            yinhangkaJiluEntity.setYinhangkaJiluContent("");//详情和图片
//                            yinhangkaJiluEntity.setInsertTime(date);//时间
//                            yinhangkaJiluEntity.setCreateTime(date);//时间
                            yinhangkaJiluList.add(yinhangkaJiluEntity);


                            //把要查询是否重复的字段放入map中
                                //记录卡号
                                if(seachFields.containsKey("yinhangkaJiluUuidNumber")){
                                    List<String> yinhangkaJiluUuidNumber = seachFields.get("yinhangkaJiluUuidNumber");
                                    yinhangkaJiluUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yinhangkaJiluUuidNumber = new ArrayList<>();
                                    yinhangkaJiluUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yinhangkaJiluUuidNumber",yinhangkaJiluUuidNumber);
                                }
                        }

                        //查询是否重复
                         //记录卡号
                        List<YinhangkaJiluEntity> yinhangkaJiluEntities_yinhangkaJiluUuidNumber = yinhangkaJiluService.selectList(new EntityWrapper<YinhangkaJiluEntity>().in("yinhangka_jilu_uuid_number", seachFields.get("yinhangkaJiluUuidNumber")));
                        if(yinhangkaJiluEntities_yinhangkaJiluUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YinhangkaJiluEntity s:yinhangkaJiluEntities_yinhangkaJiluUuidNumber){
                                repeatFields.add(s.getYinhangkaJiluUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [记录卡号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yinhangkaJiluService.insertBatch(yinhangkaJiluList);
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
        PageUtils page = yinhangkaJiluService.queryPage(params);

        //字典表数据转换
        List<YinhangkaJiluView> list =(List<YinhangkaJiluView>)page.getList();
        for(YinhangkaJiluView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YinhangkaJiluEntity yinhangkaJilu = yinhangkaJiluService.selectById(id);
            if(yinhangkaJilu !=null){


                //entity转view
                YinhangkaJiluView view = new YinhangkaJiluView();
                BeanUtils.copyProperties( yinhangkaJilu , view );//把实体数据重构到view中

                //级联表
                    YinhangkaEntity yinhangka = yinhangkaService.selectById(yinhangkaJilu.getYinhangkaId());
                if(yinhangka != null){
                    BeanUtils.copyProperties( yinhangka , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYinhangkaId(yinhangka.getId());
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
    public R add(@RequestBody YinhangkaJiluEntity yinhangkaJilu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yinhangkaJilu:{}",this.getClass().getName(),yinhangkaJilu.toString());
        Wrapper<YinhangkaJiluEntity> queryWrapper = new EntityWrapper<YinhangkaJiluEntity>()
            .eq("yinhangka_id", yinhangkaJilu.getYinhangkaId())
            .eq("yinhangka_jilu_uuid_number", yinhangkaJilu.getYinhangkaJiluUuidNumber())
            .eq("yinhangka_jilu_types", yinhangkaJilu.getYinhangkaJiluTypes())
//            .notIn("yinhangka_jilu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinhangkaJiluEntity yinhangkaJiluEntity = yinhangkaJiluService.selectOne(queryWrapper);
        if(yinhangkaJiluEntity==null){
            yinhangkaJilu.setInsertTime(new Date());
            yinhangkaJilu.setCreateTime(new Date());
        yinhangkaJiluService.insert(yinhangkaJilu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

