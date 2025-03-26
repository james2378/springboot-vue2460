
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
 * 理财产品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/licaichanpin")
public class LicaichanpinController {
    private static final Logger logger = LoggerFactory.getLogger(LicaichanpinController.class);

    private static final String TABLE_NAME = "licaichanpin";

    @Autowired
    private LicaichanpinService licaichanpinService;


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
        params.put("licaichanpinDeleteStart",1);params.put("licaichanpinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = licaichanpinService.queryPage(params);

        //字典表数据转换
        List<LicaichanpinView> list =(List<LicaichanpinView>)page.getList();
        for(LicaichanpinView c:list){
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
        LicaichanpinEntity licaichanpin = licaichanpinService.selectById(id);
        if(licaichanpin !=null){
            //entity转view
            LicaichanpinView view = new LicaichanpinView();
            BeanUtils.copyProperties( licaichanpin , view );//把实体数据重构到view中
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
    public R save(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,licaichanpin:{}",this.getClass().getName(),licaichanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LicaichanpinEntity> queryWrapper = new EntityWrapper<LicaichanpinEntity>()
            .eq("licaichanpin_name", licaichanpin.getLicaichanpinName())
            .eq("zan_number", licaichanpin.getZanNumber())
            .eq("cai_number", licaichanpin.getCaiNumber())
            .eq("licaichanpin_types", licaichanpin.getLicaichanpinTypes())
            .eq("licaichanpin_nianshouyi", licaichanpin.getLicaichanpinNianshouyi())
            .eq("licaichanpin_fengxian_types", licaichanpin.getLicaichanpinFengxianTypes())
            .eq("licaichanpin_kucun_number", licaichanpin.getLicaichanpinKucunNumber())
            .eq("shangxia_types", licaichanpin.getShangxiaTypes())
            .eq("licaichanpin_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LicaichanpinEntity licaichanpinEntity = licaichanpinService.selectOne(queryWrapper);
        if(licaichanpinEntity==null){
            licaichanpin.setZanNumber(1);
            licaichanpin.setCaiNumber(1);
            licaichanpin.setLicaichanpinClicknum(1);
            licaichanpin.setShangxiaTypes(1);
            licaichanpin.setLicaichanpinDelete(1);
            licaichanpin.setInsertTime(new Date());
            licaichanpin.setCreateTime(new Date());
            licaichanpinService.insert(licaichanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,licaichanpin:{}",this.getClass().getName(),licaichanpin.toString());
        LicaichanpinEntity oldLicaichanpinEntity = licaichanpinService.selectById(licaichanpin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(licaichanpin.getLicaichanpinPhoto()) || "null".equals(licaichanpin.getLicaichanpinPhoto())){
                licaichanpin.setLicaichanpinPhoto(null);
        }
        if("".equals(licaichanpin.getLicaichanpinContent()) || "null".equals(licaichanpin.getLicaichanpinContent())){
                licaichanpin.setLicaichanpinContent(null);
        }

            licaichanpinService.updateById(licaichanpin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LicaichanpinEntity> oldLicaichanpinList =licaichanpinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LicaichanpinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LicaichanpinEntity licaichanpinEntity = new LicaichanpinEntity();
            licaichanpinEntity.setId(id);
            licaichanpinEntity.setLicaichanpinDelete(2);
            list.add(licaichanpinEntity);
        }
        if(list != null && list.size() >0){
            licaichanpinService.updateBatchById(list);
        }

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
            List<LicaichanpinEntity> licaichanpinList = new ArrayList<>();//上传的东西
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
                            LicaichanpinEntity licaichanpinEntity = new LicaichanpinEntity();
//                            licaichanpinEntity.setLicaichanpinName(data.get(0));                    //理财产品名称 要改的
//                            licaichanpinEntity.setLicaichanpinUuidNumber(data.get(0));                    //理财产品编号 要改的
//                            licaichanpinEntity.setLicaichanpinPhoto("");//详情和图片
//                            licaichanpinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            licaichanpinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            licaichanpinEntity.setLicaichanpinTypes(Integer.valueOf(data.get(0)));   //投资类型 要改的
//                            licaichanpinEntity.setFashouTime(sdf.parse(data.get(0)));          //发售时间 要改的
//                            licaichanpinEntity.setLicaichanpinNianshouyi(data.get(0));                    //年收益 要改的
//                            licaichanpinEntity.setLicaichanpinFengxianTypes(Integer.valueOf(data.get(0)));   //风险等级 要改的
//                            licaichanpinEntity.setLicaichanpinKucunNumber(Integer.valueOf(data.get(0)));   //剩余份数 要改的
//                            licaichanpinEntity.setLicaichanpinOldMoney(data.get(0));                    //原价/份 要改的
//                            licaichanpinEntity.setLicaichanpinNewMoney(data.get(0));                    //现价/份 要改的
//                            licaichanpinEntity.setLicaichanpinClicknum(Integer.valueOf(data.get(0)));   //理财产品热度 要改的
//                            licaichanpinEntity.setLicaichanpinContent("");//详情和图片
//                            licaichanpinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            licaichanpinEntity.setLicaichanpinDelete(1);//逻辑删除字段
//                            licaichanpinEntity.setInsertTime(date);//时间
//                            licaichanpinEntity.setCreateTime(date);//时间
                            licaichanpinList.add(licaichanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //理财产品编号
                                if(seachFields.containsKey("licaichanpinUuidNumber")){
                                    List<String> licaichanpinUuidNumber = seachFields.get("licaichanpinUuidNumber");
                                    licaichanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> licaichanpinUuidNumber = new ArrayList<>();
                                    licaichanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("licaichanpinUuidNumber",licaichanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //理财产品编号
                        List<LicaichanpinEntity> licaichanpinEntities_licaichanpinUuidNumber = licaichanpinService.selectList(new EntityWrapper<LicaichanpinEntity>().in("licaichanpin_uuid_number", seachFields.get("licaichanpinUuidNumber")).eq("licaichanpin_delete", 1));
                        if(licaichanpinEntities_licaichanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LicaichanpinEntity s:licaichanpinEntities_licaichanpinUuidNumber){
                                repeatFields.add(s.getLicaichanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [理财产品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        licaichanpinService.insertBatch(licaichanpinList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<LicaichanpinView> returnLicaichanpinViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("licaichanpinYesnoTypes",2);
        PageUtils pageUtils = licaichanpinOrderService.queryPage(params1);
        List<LicaichanpinOrderView> orderViewsList =(List<LicaichanpinOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(LicaichanpinOrderView orderView:orderViewsList){
            Integer licaichanpinTypes = orderView.getLicaichanpinTypes();
            if(typeMap.containsKey(licaichanpinTypes)){
                typeMap.put(licaichanpinTypes,typeMap.get(licaichanpinTypes)+1);
            }else{
                typeMap.put(licaichanpinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("licaichanpinTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("licaichanpinYesnoTypes",2);
            PageUtils pageUtils1 = licaichanpinService.queryPage(params2);
            List<LicaichanpinView> licaichanpinViewList =(List<LicaichanpinView>)pageUtils1.getList();
            returnLicaichanpinViewList.addAll(licaichanpinViewList);
            if(returnLicaichanpinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("licaichanpinYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = licaichanpinService.queryPage(params);
        if(returnLicaichanpinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnLicaichanpinViewList.size();//要添加的数量
            List<LicaichanpinView> licaichanpinViewList =(List<LicaichanpinView>)page.getList();
            for(LicaichanpinView licaichanpinView:licaichanpinViewList){
                Boolean addFlag = true;
                for(LicaichanpinView returnLicaichanpinView:returnLicaichanpinViewList){
                    if(returnLicaichanpinView.getId().intValue() ==licaichanpinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnLicaichanpinViewList.add(licaichanpinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnLicaichanpinViewList = returnLicaichanpinViewList.subList(0, limit);
        }

        for(LicaichanpinView c:returnLicaichanpinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnLicaichanpinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = licaichanpinService.queryPage(params);

        //字典表数据转换
        List<LicaichanpinView> list =(List<LicaichanpinView>)page.getList();
        for(LicaichanpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LicaichanpinEntity licaichanpin = licaichanpinService.selectById(id);
            if(licaichanpin !=null){

                //点击数量加1
                licaichanpin.setLicaichanpinClicknum(licaichanpin.getLicaichanpinClicknum()+1);
                licaichanpinService.updateById(licaichanpin);

                //entity转view
                LicaichanpinView view = new LicaichanpinView();
                BeanUtils.copyProperties( licaichanpin , view );//把实体数据重构到view中

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
    public R add(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,licaichanpin:{}",this.getClass().getName(),licaichanpin.toString());
        Wrapper<LicaichanpinEntity> queryWrapper = new EntityWrapper<LicaichanpinEntity>()
            .eq("licaichanpin_name", licaichanpin.getLicaichanpinName())
            .eq("licaichanpin_uuid_number", licaichanpin.getLicaichanpinUuidNumber())
            .eq("zan_number", licaichanpin.getZanNumber())
            .eq("cai_number", licaichanpin.getCaiNumber())
            .eq("licaichanpin_types", licaichanpin.getLicaichanpinTypes())
            .eq("licaichanpin_nianshouyi", licaichanpin.getLicaichanpinNianshouyi())
            .eq("licaichanpin_fengxian_types", licaichanpin.getLicaichanpinFengxianTypes())
            .eq("licaichanpin_kucun_number", licaichanpin.getLicaichanpinKucunNumber())
            .eq("licaichanpin_clicknum", licaichanpin.getLicaichanpinClicknum())
            .eq("shangxia_types", licaichanpin.getShangxiaTypes())
            .eq("licaichanpin_delete", licaichanpin.getLicaichanpinDelete())
//            .notIn("licaichanpin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LicaichanpinEntity licaichanpinEntity = licaichanpinService.selectOne(queryWrapper);
        if(licaichanpinEntity==null){
                licaichanpin.setZanNumber(1);
                licaichanpin.setCaiNumber(1);
            licaichanpin.setLicaichanpinClicknum(1);
            licaichanpin.setLicaichanpinDelete(1);
            licaichanpin.setInsertTime(new Date());
            licaichanpin.setCreateTime(new Date());
        licaichanpinService.insert(licaichanpin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

