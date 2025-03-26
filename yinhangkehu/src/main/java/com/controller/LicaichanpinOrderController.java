
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
 * 理财产品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/licaichanpinOrder")
public class LicaichanpinOrderController {
    private static final Logger logger = LoggerFactory.getLogger(LicaichanpinOrderController.class);

    private static final String TABLE_NAME = "licaichanpinOrder";

    @Autowired
    private LicaichanpinOrderService licaichanpinOrderService;


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
        PageUtils page = licaichanpinOrderService.queryPage(params);

        //字典表数据转换
        List<LicaichanpinOrderView> list =(List<LicaichanpinOrderView>)page.getList();
        for(LicaichanpinOrderView c:list){
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
        LicaichanpinOrderEntity licaichanpinOrder = licaichanpinOrderService.selectById(id);
        if(licaichanpinOrder !=null){
            //entity转view
            LicaichanpinOrderView view = new LicaichanpinOrderView();
            BeanUtils.copyProperties( licaichanpinOrder , view );//把实体数据重构到view中
            //级联表 理财产品
            //级联表
            LicaichanpinEntity licaichanpin = licaichanpinService.selectById(licaichanpinOrder.getLicaichanpinId());
            if(licaichanpin != null){
            BeanUtils.copyProperties( licaichanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLicaichanpinId(licaichanpin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(licaichanpinOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 银行卡
            //级联表
            YinhangkaEntity yinhangka = yinhangkaService.selectById(licaichanpinOrder.getYinhangkaId());
            if(yinhangka != null){
            BeanUtils.copyProperties( yinhangka , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody LicaichanpinOrderEntity licaichanpinOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,licaichanpinOrder:{}",this.getClass().getName(),licaichanpinOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            licaichanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        licaichanpinOrder.setCreateTime(new Date());
        licaichanpinOrder.setInsertTime(new Date());
        licaichanpinOrderService.insert(licaichanpinOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LicaichanpinOrderEntity licaichanpinOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,licaichanpinOrder:{}",this.getClass().getName(),licaichanpinOrder.toString());
        LicaichanpinOrderEntity oldLicaichanpinOrderEntity = licaichanpinOrderService.selectById(licaichanpinOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            licaichanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(licaichanpinOrder.getLicaichanpinOrderYesnoText()) || "null".equals(licaichanpinOrder.getLicaichanpinOrderYesnoText())){
                licaichanpinOrder.setLicaichanpinOrderYesnoText(null);
        }

            licaichanpinOrderService.updateById(licaichanpinOrder);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody LicaichanpinOrderEntity licaichanpinOrderEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,licaichanpinOrderEntity:{}",this.getClass().getName(),licaichanpinOrderEntity.toString());

        LicaichanpinOrderEntity oldLicaichanpinOrder = licaichanpinOrderService.selectById(licaichanpinOrderEntity.getId());//查询原先数据

        if(licaichanpinOrderEntity.getLicaichanpinOrderYesnoTypes() == 2){//通过
            licaichanpinOrderEntity.setLicaichanpinOrderTypes(103);
        }else if(licaichanpinOrderEntity.getLicaichanpinOrderYesnoTypes() == 3){//拒绝
            licaichanpinOrderEntity.setLicaichanpinOrderTypes(106);

            YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(oldLicaichanpinOrder.getYinhangkaId());
            if(yinhangkaEntity == null)
                return R.error("查不到银行卡");

            LicaichanpinEntity licaichanpinEntity = licaichanpinService.selectById(oldLicaichanpinOrder.getLicaichanpinId());
            if(licaichanpinEntity == null)
                return R.error(511,"查不到该理财产品");
            double balance =yinhangkaEntity.getYinhangkaMoney() + licaichanpinEntity.getLicaichanpinNewMoney()*oldLicaichanpinOrder.getBuyNumber();//余额
            yinhangkaEntity.setYinhangkaMoney(balance);
            yinhangkaService.updateById(yinhangkaEntity);
        }
        licaichanpinOrderEntity.setLicaichanpinOrderShenheTime(new Date());//审核时间
        licaichanpinOrderService.updateById(licaichanpinOrderEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LicaichanpinOrderEntity> oldLicaichanpinOrderList =licaichanpinOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        licaichanpinOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<LicaichanpinOrderEntity> licaichanpinOrderList = new ArrayList<>();//上传的东西
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
                            LicaichanpinOrderEntity licaichanpinOrderEntity = new LicaichanpinOrderEntity();
//                            licaichanpinOrderEntity.setLicaichanpinOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            licaichanpinOrderEntity.setLicaichanpinId(Integer.valueOf(data.get(0)));   //理财产品 要改的
//                            licaichanpinOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            licaichanpinOrderEntity.setYinhangkaId(Integer.valueOf(data.get(0)));   //银行卡 要改的
//                            licaichanpinOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买份数 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            licaichanpinOrderEntity.setLicaichanpinOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            licaichanpinOrderEntity.setInsertTime(date);//时间
//                            licaichanpinOrderEntity.setCreateTime(date);//时间
                            licaichanpinOrderList.add(licaichanpinOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("licaichanpinOrderUuidNumber")){
                                    List<String> licaichanpinOrderUuidNumber = seachFields.get("licaichanpinOrderUuidNumber");
                                    licaichanpinOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> licaichanpinOrderUuidNumber = new ArrayList<>();
                                    licaichanpinOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("licaichanpinOrderUuidNumber",licaichanpinOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<LicaichanpinOrderEntity> licaichanpinOrderEntities_licaichanpinOrderUuidNumber = licaichanpinOrderService.selectList(new EntityWrapper<LicaichanpinOrderEntity>().in("licaichanpin_order_uuid_number", seachFields.get("licaichanpinOrderUuidNumber")));
                        if(licaichanpinOrderEntities_licaichanpinOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LicaichanpinOrderEntity s:licaichanpinOrderEntities_licaichanpinOrderUuidNumber){
                                repeatFields.add(s.getLicaichanpinOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        licaichanpinOrderService.insertBatch(licaichanpinOrderList);
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
        PageUtils page = licaichanpinOrderService.queryPage(params);

        //字典表数据转换
        List<LicaichanpinOrderView> list =(List<LicaichanpinOrderView>)page.getList();
        for(LicaichanpinOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LicaichanpinOrderEntity licaichanpinOrder = licaichanpinOrderService.selectById(id);
            if(licaichanpinOrder !=null){


                //entity转view
                LicaichanpinOrderView view = new LicaichanpinOrderView();
                BeanUtils.copyProperties( licaichanpinOrder , view );//把实体数据重构到view中

                //级联表
                    LicaichanpinEntity licaichanpin = licaichanpinService.selectById(licaichanpinOrder.getLicaichanpinId());
                if(licaichanpin != null){
                    BeanUtils.copyProperties( licaichanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLicaichanpinId(licaichanpin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(licaichanpinOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YinhangkaEntity yinhangka = yinhangkaService.selectById(licaichanpinOrder.getYinhangkaId());
                if(yinhangka != null){
                    BeanUtils.copyProperties( yinhangka , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
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
    public R add(@RequestBody LicaichanpinOrderEntity licaichanpinOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,licaichanpinOrder:{}",this.getClass().getName(),licaichanpinOrder.toString());
            LicaichanpinEntity licaichanpinEntity = licaichanpinService.selectById(licaichanpinOrder.getLicaichanpinId());
            if(licaichanpinEntity == null){
                return R.error(511,"查不到该理财产品");
            }
            // Double licaichanpinNewMoney = licaichanpinEntity.getLicaichanpinNewMoney();

            if(false){
            }
            else if(licaichanpinEntity.getLicaichanpinNewMoney() == null){
                return R.error(511,"现价/份不能为空");
            }
            else if((licaichanpinEntity.getLicaichanpinKucunNumber() -licaichanpinOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
        YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(licaichanpinOrder.getYinhangkaId());
        if(yinhangkaEntity == null)
            return R.error("查不到银行卡");



            double balance =yinhangkaEntity.getYinhangkaMoney() - licaichanpinEntity.getLicaichanpinNewMoney()*licaichanpinOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            licaichanpinOrder.setLicaichanpinOrderTypes(101); //设置订单状态为已购买
            licaichanpinOrder.setLicaichanpinOrderTruePrice(licaichanpinEntity.getLicaichanpinNewMoney()*licaichanpinOrder.getBuyNumber()); //设置实付价格
            licaichanpinOrder.setYonghuId(userId); //设置订单支付人id
            licaichanpinOrder.setLicaichanpinOrderUuidNumber(String.valueOf(new Date().getTime()));
            licaichanpinOrder.setLicaichanpinOrderPaymentTypes(1);
            licaichanpinOrder.setInsertTime(new Date());
            licaichanpinOrder.setCreateTime(new Date());
                licaichanpinEntity.setLicaichanpinKucunNumber( licaichanpinEntity.getLicaichanpinKucunNumber() -licaichanpinOrder.getBuyNumber());
                licaichanpinService.updateById(licaichanpinEntity);
                licaichanpinOrderService.insert(licaichanpinOrder);//新增订单

        yinhangkaEntity.setYinhangkaMoney(balance);
        yinhangkaService.updateById(yinhangkaEntity);


        YinhangkaJiluEntity yinhangkaJiluEntity = new YinhangkaJiluEntity();
        yinhangkaJiluEntity.setCreateTime(new Date());
        yinhangkaJiluEntity.setInsertTime(new Date());
        yinhangkaJiluEntity.setYinhangkaId(yinhangkaEntity.getId());
        yinhangkaJiluEntity.setYinhangkaJiluJine(licaichanpinEntity.getLicaichanpinNewMoney()*licaichanpinOrder.getBuyNumber());//金额
        yinhangkaJiluEntity.setYinhangkaJiluContent("购买理财产品花费"+yinhangkaJiluEntity.getYinhangkaJiluJine());
        yinhangkaJiluEntity.setYinhangkaJiluTypes(1); //1:购买理财  2:借贷收入 3:还款  4:存款是5:取款6:转账
        yinhangkaJiluEntity.setYinhangkaJiluUuidNumber(String.valueOf(new Date().getTime()));
        yinhangkaJiluService.insert(yinhangkaJiluEntity);


            return R.ok();
    }


    /**
    * 取消购买
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            LicaichanpinOrderEntity licaichanpinOrder = licaichanpinOrderService.selectById(id);//当前表service
            Integer buyNumber = licaichanpinOrder.getBuyNumber();
            Integer licaichanpinOrderPaymentTypes = licaichanpinOrder.getLicaichanpinOrderPaymentTypes();
            Integer licaichanpinId = licaichanpinOrder.getLicaichanpinId();
            if(licaichanpinId == null)
                return R.error(511,"查不到该理财产品");
            LicaichanpinEntity licaichanpinEntity = licaichanpinService.selectById(licaichanpinId);
            if(licaichanpinEntity == null)
                return R.error(511,"查不到该理财产品");
            Double licaichanpinNewMoney = licaichanpinEntity.getLicaichanpinNewMoney();
            if(licaichanpinNewMoney == null)
                return R.error(511,"理财产品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(licaichanpinOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = licaichanpinEntity.getLicaichanpinNewMoney() * buyNumber  * zhekou;

                YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(licaichanpinOrder.getYinhangkaId());
                if(yinhangkaEntity == null)
                    return R.error("查不到银行卡");

                double balance =yinhangkaEntity.getYinhangkaMoney() + licaichanpinEntity.getLicaichanpinNewMoney()*licaichanpinOrder.getBuyNumber();//余额

                yinhangkaEntity.setYinhangkaMoney(balance);
                yinhangkaService.updateById(yinhangkaEntity);


            }

            licaichanpinEntity.setLicaichanpinKucunNumber(licaichanpinEntity.getLicaichanpinKucunNumber() + buyNumber);

            licaichanpinOrder.setLicaichanpinOrderYesnoTypes(null);
            licaichanpinOrder.setLicaichanpinOrderTypes(102);//设置订单状态为已取消购买
            licaichanpinOrderService.updateAllColumnById(licaichanpinOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            licaichanpinService.updateById(licaichanpinEntity);//更新订单中理财产品的信息



        YinhangkaJiluEntity yinhangkaJiluEntity = new YinhangkaJiluEntity();
        yinhangkaJiluEntity.setCreateTime(new Date());
        yinhangkaJiluEntity.setInsertTime(new Date());
        yinhangkaJiluEntity.setYinhangkaId(licaichanpinOrder.getYinhangkaId());
        yinhangkaJiluEntity.setYinhangkaJiluJine(licaichanpinEntity.getLicaichanpinNewMoney()*licaichanpinOrder.getBuyNumber());//金额
        yinhangkaJiluEntity.setYinhangkaJiluContent("购买理财产品取消购买,退回"+yinhangkaJiluEntity.getYinhangkaJiluJine());
        yinhangkaJiluEntity.setYinhangkaJiluTypes(1); //1:购买理财  2:借贷收入 3:还款  4:存款是5:取款6:转账
        yinhangkaJiluEntity.setYinhangkaJiluUuidNumber(String.valueOf(new Date().getTime()));
        yinhangkaJiluService.insert(yinhangkaJiluEntity);


        return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer licaichanpinCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            LicaichanpinOrderEntity licaichanpinOrder = licaichanpinOrderService.selectById(id);
        if(licaichanpinOrder == null)
            return R.error(511,"查不到该订单");
        Integer licaichanpinId = licaichanpinOrder.getLicaichanpinId();
        if(licaichanpinId == null)
            return R.error(511,"查不到该理财产品");

        LicaichanpinCommentbackEntity licaichanpinCommentbackEntity = new LicaichanpinCommentbackEntity();
            licaichanpinCommentbackEntity.setId(id);
            licaichanpinCommentbackEntity.setLicaichanpinId(licaichanpinId);
            licaichanpinCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            licaichanpinCommentbackEntity.setLicaichanpinCommentbackText(commentbackText);
            licaichanpinCommentbackEntity.setInsertTime(new Date());
            licaichanpinCommentbackEntity.setReplyText(null);
            licaichanpinCommentbackEntity.setUpdateTime(null);
            licaichanpinCommentbackEntity.setCreateTime(new Date());
            licaichanpinCommentbackService.insert(licaichanpinCommentbackEntity);

            licaichanpinOrder.setLicaichanpinOrderTypes(105);//设置订单状态为已评价
            licaichanpinOrderService.updateById(licaichanpinOrder);//根据id更新
            return R.ok();
    }

    /**
     * 同意
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        LicaichanpinOrderEntity  licaichanpinOrderEntity = licaichanpinOrderService.selectById(id);
        licaichanpinOrderEntity.setLicaichanpinOrderTypes(103);//设置订单状态为已同意
        licaichanpinOrderService.updateById( licaichanpinOrderEntity);

        return R.ok();
    }


}

