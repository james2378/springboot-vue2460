
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
 * 银行卡
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yinhangka")
public class YinhangkaController {
    private static final Logger logger = LoggerFactory.getLogger(YinhangkaController.class);

    private static final String TABLE_NAME = "yinhangka";

    @Autowired
    private YinhangkaService yinhangkaService;


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
        PageUtils page = yinhangkaService.queryPage(params);

        //字典表数据转换
        List<YinhangkaView> list =(List<YinhangkaView>)page.getList();
        for(YinhangkaView c:list){
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
        YinhangkaEntity yinhangka = yinhangkaService.selectById(id);
        if(yinhangka !=null){
            //entity转view
            YinhangkaView view = new YinhangkaView();
            BeanUtils.copyProperties( yinhangka , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yinhangka.getYonghuId());
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
    public R save(@RequestBody YinhangkaEntity yinhangka, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yinhangka:{}",this.getClass().getName(),yinhangka.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yinhangka.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YinhangkaEntity> queryWrapper = new EntityWrapper<YinhangkaEntity>()
            .eq("yonghu_id", yinhangka.getYonghuId())
            .eq("yinhangka_kaikadi", yinhangka.getYinhangkaKaikadi())
            .eq("yinhang_types", yinhangka.getYinhangTypes())
            .eq("yinhangka_types", yinhangka.getYinhangkaTypes())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            .eq("yinhangka_address", yinhangka.getYinhangkaAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinhangkaEntity yinhangkaEntity = yinhangkaService.selectOne(queryWrapper);
        if(yinhangkaEntity==null){
            yinhangka.setInsertTime(new Date());
            yinhangka.setCreateTime(new Date());
            yinhangkaService.insert(yinhangka);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YinhangkaEntity yinhangka, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yinhangka:{}",this.getClass().getName(),yinhangka.toString());
        YinhangkaEntity oldYinhangkaEntity = yinhangkaService.selectById(yinhangka.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yinhangka.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(yinhangka.getYinhangkaPhoto()) || "null".equals(yinhangka.getYinhangkaPhoto())){
                yinhangka.setYinhangkaPhoto(null);
        }
        if("".equals(yinhangka.getYinhangkaContent()) || "null".equals(yinhangka.getYinhangkaContent())){
                yinhangka.setYinhangkaContent(null);
        }

            yinhangkaService.updateById(yinhangka);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YinhangkaEntity> oldYinhangkaList =yinhangkaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yinhangkaService.deleteBatchIds(Arrays.asList(ids));

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
            List<YinhangkaEntity> yinhangkaList = new ArrayList<>();//上传的东西
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
                            YinhangkaEntity yinhangkaEntity = new YinhangkaEntity();
//                            yinhangkaEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yinhangkaEntity.setYinhangkaUuidNumber(data.get(0));                    //银行卡卡号 要改的
//                            yinhangkaEntity.setYinhangkaPhoto("");//详情和图片
//                            yinhangkaEntity.setYinhangkaKaikadi(data.get(0));                    //开卡地 要改的
//                            yinhangkaEntity.setYinhangTypes(Integer.valueOf(data.get(0)));   //银行 要改的
//                            yinhangkaEntity.setYinhangkaTypes(Integer.valueOf(data.get(0)));   //银行卡类型 要改的
//                            yinhangkaEntity.setInsertTime(date);//时间
//                            yinhangkaEntity.setYinhangkaAddress(data.get(0));                    //编码 要改的
//                            yinhangkaEntity.setYinhangkaMoney(data.get(0));                    //余额 要改的
//                            yinhangkaEntity.setYinhangkaContent("");//详情和图片
//                            yinhangkaEntity.setCreateTime(date);//时间
                            yinhangkaList.add(yinhangkaEntity);


                            //把要查询是否重复的字段放入map中
                                //银行卡卡号
                                if(seachFields.containsKey("yinhangkaUuidNumber")){
                                    List<String> yinhangkaUuidNumber = seachFields.get("yinhangkaUuidNumber");
                                    yinhangkaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yinhangkaUuidNumber = new ArrayList<>();
                                    yinhangkaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yinhangkaUuidNumber",yinhangkaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //银行卡卡号
                        List<YinhangkaEntity> yinhangkaEntities_yinhangkaUuidNumber = yinhangkaService.selectList(new EntityWrapper<YinhangkaEntity>().in("yinhangka_uuid_number", seachFields.get("yinhangkaUuidNumber")));
                        if(yinhangkaEntities_yinhangkaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YinhangkaEntity s:yinhangkaEntities_yinhangkaUuidNumber){
                                repeatFields.add(s.getYinhangkaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [银行卡卡号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yinhangkaService.insertBatch(yinhangkaList);
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
        PageUtils page = yinhangkaService.queryPage(params);

        //字典表数据转换
        List<YinhangkaView> list =(List<YinhangkaView>)page.getList();
        for(YinhangkaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YinhangkaEntity yinhangka = yinhangkaService.selectById(id);
            if(yinhangka !=null){


                //entity转view
                YinhangkaView view = new YinhangkaView();
                BeanUtils.copyProperties( yinhangka , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yinhangka.getYonghuId());
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
    public R add(@RequestBody YinhangkaEntity yinhangka, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yinhangka:{}",this.getClass().getName(),yinhangka.toString());
        Wrapper<YinhangkaEntity> queryWrapper = new EntityWrapper<YinhangkaEntity>()
            .eq("yinhangka_uuid_number", yinhangka.getYinhangkaUuidNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinhangkaEntity yinhangkaEntity = yinhangkaService.selectOne(queryWrapper);
        if(yinhangkaEntity==null){
            yinhangka.setYinhangkaMoney(0.0);
            yinhangka.setInsertTime(new Date());
            yinhangka.setCreateTime(new Date());
        yinhangkaService.insert(yinhangka);

            return R.ok();
        }else {
            return R.error(511,"银行卡卡号已被使用");
        }
    }

}

