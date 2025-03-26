
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
 * 金融工具
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jinronggongju")
public class JinronggongjuController {
    private static final Logger logger = LoggerFactory.getLogger(JinronggongjuController.class);

    private static final String TABLE_NAME = "jinronggongju";

    @Autowired
    private JinronggongjuService jinronggongjuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
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
        params.put("jinronggongjuDeleteStart",1);params.put("jinronggongjuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jinronggongjuService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuView> list =(List<JinronggongjuView>)page.getList();
        for(JinronggongjuView c:list){
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
        JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(id);
        if(jinronggongju !=null){
            //entity转view
            JinronggongjuView view = new JinronggongjuView();
            BeanUtils.copyProperties( jinronggongju , view );//把实体数据重构到view中
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
    public R save(@RequestBody JinronggongjuEntity jinronggongju, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jinronggongju:{}",this.getClass().getName(),jinronggongju.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JinronggongjuEntity> queryWrapper = new EntityWrapper<JinronggongjuEntity>()
            .eq("jinronggongju_name", jinronggongju.getJinronggongjuName())
            .eq("zan_number", jinronggongju.getZanNumber())
            .eq("cai_number", jinronggongju.getCaiNumber())
            .eq("jinronggongju_types", jinronggongju.getJinronggongjuTypes())
            .eq("huankuan_number", jinronggongju.getHuankuanNumber())
            .eq("shangxia_types", jinronggongju.getShangxiaTypes())
            .eq("jinronggongju_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JinronggongjuEntity jinronggongjuEntity = jinronggongjuService.selectOne(queryWrapper);
        if(jinronggongjuEntity==null){
            jinronggongju.setZanNumber(1);
            jinronggongju.setCaiNumber(1);
            jinronggongju.setJinronggongjuClicknum(1);
            jinronggongju.setShangxiaTypes(1);
            jinronggongju.setJinronggongjuDelete(1);
            jinronggongju.setInsertTime(new Date());
            jinronggongju.setCreateTime(new Date());
            jinronggongjuService.insert(jinronggongju);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JinronggongjuEntity jinronggongju, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jinronggongju:{}",this.getClass().getName(),jinronggongju.toString());
        JinronggongjuEntity oldJinronggongjuEntity = jinronggongjuService.selectById(jinronggongju.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jinronggongju.getJinronggongjuPhoto()) || "null".equals(jinronggongju.getJinronggongjuPhoto())){
                jinronggongju.setJinronggongjuPhoto(null);
        }
        if("".equals(jinronggongju.getJinronggongjuContent()) || "null".equals(jinronggongju.getJinronggongjuContent())){
                jinronggongju.setJinronggongjuContent(null);
        }

            jinronggongjuService.updateById(jinronggongju);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JinronggongjuEntity> oldJinronggongjuList =jinronggongjuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JinronggongjuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JinronggongjuEntity jinronggongjuEntity = new JinronggongjuEntity();
            jinronggongjuEntity.setId(id);
            jinronggongjuEntity.setJinronggongjuDelete(2);
            list.add(jinronggongjuEntity);
        }
        if(list != null && list.size() >0){
            jinronggongjuService.updateBatchById(list);
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
            List<JinronggongjuEntity> jinronggongjuList = new ArrayList<>();//上传的东西
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
                            JinronggongjuEntity jinronggongjuEntity = new JinronggongjuEntity();
//                            jinronggongjuEntity.setJinronggongjuName(data.get(0));                    //产品名称 要改的
//                            jinronggongjuEntity.setJinronggongjuUuidNumber(data.get(0));                    //金融工具编号 要改的
//                            jinronggongjuEntity.setJinronggongjuPhoto("");//详情和图片
//                            jinronggongjuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jinronggongjuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jinronggongjuEntity.setJinronggongjuTypes(Integer.valueOf(data.get(0)));   //产品类型 要改的
//                            jinronggongjuEntity.setHuankuanNumber(Integer.valueOf(data.get(0)));   //还款天数 要改的
//                            jinronggongjuEntity.setJinronggongjuLilv(data.get(0));                    //利率 要改的
//                            jinronggongjuEntity.setJinronggongjuClicknum(Integer.valueOf(data.get(0)));   //金融工具热度 要改的
//                            jinronggongjuEntity.setJinronggongjuContent("");//详情和图片
//                            jinronggongjuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jinronggongjuEntity.setJinronggongjuDelete(1);//逻辑删除字段
//                            jinronggongjuEntity.setInsertTime(date);//时间
//                            jinronggongjuEntity.setCreateTime(date);//时间
                            jinronggongjuList.add(jinronggongjuEntity);


                            //把要查询是否重复的字段放入map中
                                //金融工具编号
                                if(seachFields.containsKey("jinronggongjuUuidNumber")){
                                    List<String> jinronggongjuUuidNumber = seachFields.get("jinronggongjuUuidNumber");
                                    jinronggongjuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jinronggongjuUuidNumber = new ArrayList<>();
                                    jinronggongjuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jinronggongjuUuidNumber",jinronggongjuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //金融工具编号
                        List<JinronggongjuEntity> jinronggongjuEntities_jinronggongjuUuidNumber = jinronggongjuService.selectList(new EntityWrapper<JinronggongjuEntity>().in("jinronggongju_uuid_number", seachFields.get("jinronggongjuUuidNumber")).eq("jinronggongju_delete", 1));
                        if(jinronggongjuEntities_jinronggongjuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JinronggongjuEntity s:jinronggongjuEntities_jinronggongjuUuidNumber){
                                repeatFields.add(s.getJinronggongjuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [金融工具编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jinronggongjuService.insertBatch(jinronggongjuList);
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
        List<JinronggongjuView> returnJinronggongjuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("jinronggongjuYesnoTypes",2);
        PageUtils pageUtils = jinronggongjuOrderService.queryPage(params1);
        List<JinronggongjuOrderView> orderViewsList =(List<JinronggongjuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JinronggongjuOrderView orderView:orderViewsList){
            Integer jinronggongjuTypes = orderView.getJinronggongjuTypes();
            if(typeMap.containsKey(jinronggongjuTypes)){
                typeMap.put(jinronggongjuTypes,typeMap.get(jinronggongjuTypes)+1);
            }else{
                typeMap.put(jinronggongjuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jinronggongjuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("jinronggongjuYesnoTypes",2);
            PageUtils pageUtils1 = jinronggongjuService.queryPage(params2);
            List<JinronggongjuView> jinronggongjuViewList =(List<JinronggongjuView>)pageUtils1.getList();
            returnJinronggongjuViewList.addAll(jinronggongjuViewList);
            if(returnJinronggongjuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("jinronggongjuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jinronggongjuService.queryPage(params);
        if(returnJinronggongjuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJinronggongjuViewList.size();//要添加的数量
            List<JinronggongjuView> jinronggongjuViewList =(List<JinronggongjuView>)page.getList();
            for(JinronggongjuView jinronggongjuView:jinronggongjuViewList){
                Boolean addFlag = true;
                for(JinronggongjuView returnJinronggongjuView:returnJinronggongjuViewList){
                    if(returnJinronggongjuView.getId().intValue() ==jinronggongjuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJinronggongjuViewList.add(jinronggongjuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJinronggongjuViewList = returnJinronggongjuViewList.subList(0, limit);
        }

        for(JinronggongjuView c:returnJinronggongjuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJinronggongjuViewList);
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
        PageUtils page = jinronggongjuService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuView> list =(List<JinronggongjuView>)page.getList();
        for(JinronggongjuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(id);
            if(jinronggongju !=null){

                //点击数量加1
                jinronggongju.setJinronggongjuClicknum(jinronggongju.getJinronggongjuClicknum()+1);
                jinronggongjuService.updateById(jinronggongju);

                //entity转view
                JinronggongjuView view = new JinronggongjuView();
                BeanUtils.copyProperties( jinronggongju , view );//把实体数据重构到view中

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
    public R add(@RequestBody JinronggongjuEntity jinronggongju, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jinronggongju:{}",this.getClass().getName(),jinronggongju.toString());
        Wrapper<JinronggongjuEntity> queryWrapper = new EntityWrapper<JinronggongjuEntity>()
            .eq("jinronggongju_name", jinronggongju.getJinronggongjuName())
            .eq("jinronggongju_uuid_number", jinronggongju.getJinronggongjuUuidNumber())
            .eq("zan_number", jinronggongju.getZanNumber())
            .eq("cai_number", jinronggongju.getCaiNumber())
            .eq("jinronggongju_types", jinronggongju.getJinronggongjuTypes())
            .eq("huankuan_number", jinronggongju.getHuankuanNumber())
            .eq("jinronggongju_clicknum", jinronggongju.getJinronggongjuClicknum())
            .eq("shangxia_types", jinronggongju.getShangxiaTypes())
            .eq("jinronggongju_delete", jinronggongju.getJinronggongjuDelete())
//            .notIn("jinronggongju_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JinronggongjuEntity jinronggongjuEntity = jinronggongjuService.selectOne(queryWrapper);
        if(jinronggongjuEntity==null){
                jinronggongju.setZanNumber(1);
                jinronggongju.setCaiNumber(1);
            jinronggongju.setJinronggongjuClicknum(1);
            jinronggongju.setJinronggongjuDelete(1);
            jinronggongju.setInsertTime(new Date());
            jinronggongju.setCreateTime(new Date());
        jinronggongjuService.insert(jinronggongju);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

