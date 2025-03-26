
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
 * 借款
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jinronggongjuOrder")
public class JinronggongjuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JinronggongjuOrderController.class);

    private static final String TABLE_NAME = "jinronggongjuOrder";

    @Autowired
    private JinronggongjuOrderService jinronggongjuOrderService;


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
        PageUtils page = jinronggongjuOrderService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuOrderView> list =(List<JinronggongjuOrderView>)page.getList();
        for(JinronggongjuOrderView c:list){
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
        JinronggongjuOrderEntity jinronggongjuOrder = jinronggongjuOrderService.selectById(id);
        if(jinronggongjuOrder !=null){
            //entity转view
            JinronggongjuOrderView view = new JinronggongjuOrderView();
            BeanUtils.copyProperties( jinronggongjuOrder , view );//把实体数据重构到view中
            //级联表 金融工具
            //级联表
            JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(jinronggongjuOrder.getJinronggongjuId());
            if(jinronggongju != null){
            BeanUtils.copyProperties( jinronggongju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJinronggongjuId(jinronggongju.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jinronggongjuOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 银行卡
            //级联表
            YinhangkaEntity yinhangka = yinhangkaService.selectById(jinronggongjuOrder.getYinhangkaId());
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
    public R save(@RequestBody JinronggongjuOrderEntity jinronggongjuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jinronggongjuOrder:{}",this.getClass().getName(),jinronggongjuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jinronggongjuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jinronggongjuOrder.setCreateTime(new Date());
        jinronggongjuOrder.setInsertTime(new Date());
        jinronggongjuOrderService.insert(jinronggongjuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JinronggongjuOrderEntity jinronggongjuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jinronggongjuOrder:{}",this.getClass().getName(),jinronggongjuOrder.toString());
        JinronggongjuOrderEntity oldJinronggongjuOrderEntity = jinronggongjuOrderService.selectById(jinronggongjuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jinronggongjuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jinronggongjuOrder.getJinronggongjuOrderYesnoText()) || "null".equals(jinronggongjuOrder.getJinronggongjuOrderYesnoText())){
                jinronggongjuOrder.setJinronggongjuOrderYesnoText(null);
        }

            jinronggongjuOrderService.updateById(jinronggongjuOrder);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JinronggongjuOrderEntity jinronggongjuOrderEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,jinronggongjuOrderEntity:{}",this.getClass().getName(),jinronggongjuOrderEntity.toString());

        JinronggongjuOrderEntity oldJinronggongjuOrder = jinronggongjuOrderService.selectById(jinronggongjuOrderEntity.getId());//查询原先数据

        if(jinronggongjuOrderEntity.getJinronggongjuOrderYesnoTypes() == 2){//通过
            YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(oldJinronggongjuOrder.getYinhangkaId());
            if(yinhangkaEntity==null){
                return R.error("查不到银行卡");
            }
            yinhangkaEntity.setYinhangkaMoney(yinhangkaEntity.getYinhangkaMoney()+oldJinronggongjuOrder.getJinronggongjuOrderJiekuanjine());

            JinronggongjuEntity jinronggongjuEntity = jinronggongjuService.selectById(oldJinronggongjuOrder.getJinronggongjuId());
            if(jinronggongjuEntity==null)
                return R.error("查不到金融工具");


            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.set(Calendar.DAY_OF_MONTH,jinronggongjuEntity.getHuankuanNumber());
            jinronggongjuOrderEntity.setZuiwanhuankuanTime(instance.getTime());
            jinronggongjuOrderEntity.setJinronggongjuOrderTypes(103);
            yinhangkaService.updateById(yinhangkaEntity);


            YinhangkaJiluEntity yinhangkaJiluEntity = new YinhangkaJiluEntity();
            yinhangkaJiluEntity.setCreateTime(new Date());
            yinhangkaJiluEntity.setInsertTime(new Date());
            yinhangkaJiluEntity.setYinhangkaId(oldJinronggongjuOrder.getYinhangkaId());
            yinhangkaJiluEntity.setYinhangkaJiluJine(oldJinronggongjuOrder.getJinronggongjuOrderJiekuanjine());//金额
            yinhangkaJiluEntity.setYinhangkaJiluContent("购买金融工具,转入了"+yinhangkaJiluEntity.getYinhangkaJiluJine());
            yinhangkaJiluEntity.setYinhangkaJiluTypes(2); //1:购买理财  2:借贷收入 3:还款  4:存款是5:取款6:转账
            yinhangkaJiluEntity.setYinhangkaJiluUuidNumber(String.valueOf(new Date().getTime()));
            yinhangkaJiluService.insert(yinhangkaJiluEntity);

        }else if(jinronggongjuOrderEntity.getJinronggongjuOrderYesnoTypes() == 3){//拒绝
            jinronggongjuOrderEntity.setJinronggongjuOrderTypes(106);
        }
        jinronggongjuOrderEntity.setJinronggongjuOrderShenheTime(new Date());//审核时间
        jinronggongjuOrderService.updateById(jinronggongjuOrderEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JinronggongjuOrderEntity> oldJinronggongjuOrderList =jinronggongjuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jinronggongjuOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<JinronggongjuOrderEntity> jinronggongjuOrderList = new ArrayList<>();//上传的东西
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
                            JinronggongjuOrderEntity jinronggongjuOrderEntity = new JinronggongjuOrderEntity();
//                            jinronggongjuOrderEntity.setJinronggongjuOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuId(Integer.valueOf(data.get(0)));   //金融工具 要改的
//                            jinronggongjuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jinronggongjuOrderEntity.setYinhangkaId(Integer.valueOf(data.get(0)));   //银行卡 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderJiekuanjine(data.get(0));                    //借款金额 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderHuankuanjine(data.get(0));                    //还款金额 要改的
//                            jinronggongjuOrderEntity.setZuiwanhuankuanTime(sdf.parse(data.get(0)));          //最晚还款日期 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            jinronggongjuOrderEntity.setJinronggongjuOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            jinronggongjuOrderEntity.setInsertTime(date);//时间
//                            jinronggongjuOrderEntity.setCreateTime(date);//时间
                            jinronggongjuOrderList.add(jinronggongjuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("jinronggongjuOrderUuidNumber")){
                                    List<String> jinronggongjuOrderUuidNumber = seachFields.get("jinronggongjuOrderUuidNumber");
                                    jinronggongjuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jinronggongjuOrderUuidNumber = new ArrayList<>();
                                    jinronggongjuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jinronggongjuOrderUuidNumber",jinronggongjuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<JinronggongjuOrderEntity> jinronggongjuOrderEntities_jinronggongjuOrderUuidNumber = jinronggongjuOrderService.selectList(new EntityWrapper<JinronggongjuOrderEntity>().in("jinronggongju_order_uuid_number", seachFields.get("jinronggongjuOrderUuidNumber")));
                        if(jinronggongjuOrderEntities_jinronggongjuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JinronggongjuOrderEntity s:jinronggongjuOrderEntities_jinronggongjuOrderUuidNumber){
                                repeatFields.add(s.getJinronggongjuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jinronggongjuOrderService.insertBatch(jinronggongjuOrderList);
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
        PageUtils page = jinronggongjuOrderService.queryPage(params);

        //字典表数据转换
        List<JinronggongjuOrderView> list =(List<JinronggongjuOrderView>)page.getList();
        for(JinronggongjuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinronggongjuOrderEntity jinronggongjuOrder = jinronggongjuOrderService.selectById(id);
            if(jinronggongjuOrder !=null){


                //entity转view
                JinronggongjuOrderView view = new JinronggongjuOrderView();
                BeanUtils.copyProperties( jinronggongjuOrder , view );//把实体数据重构到view中

                //级联表
                    JinronggongjuEntity jinronggongju = jinronggongjuService.selectById(jinronggongjuOrder.getJinronggongjuId());
                if(jinronggongju != null){
                    BeanUtils.copyProperties( jinronggongju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJinronggongjuId(jinronggongju.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jinronggongjuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YinhangkaEntity yinhangka = yinhangkaService.selectById(jinronggongjuOrder.getYinhangkaId());
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
     * 还款
     */
    @RequestMapping("/huankuan")
    public R huankuan(Integer id, HttpServletRequest request){
        logger.debug("huankuan方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinronggongjuOrderEntity jinronggongjuOrder = jinronggongjuOrderService.selectById(id);
        if(jinronggongjuOrder ==null){
            return R.error(511,"查不到数据");
        }

        YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(jinronggongjuOrder.getYinhangkaId());
        if(yinhangkaEntity == null)
            return R.error("查不到银行卡");

        double balance = yinhangkaEntity.getYinhangkaMoney() - jinronggongjuOrder.getJinronggongjuOrderHuankuanjine();
        if(balance<0){
            return R.error("银行卡余额不够支付此次还款,请存款后再支付");
        }

        yinhangkaEntity.setYinhangkaMoney(balance);
        yinhangkaService.updateById(yinhangkaEntity);
        jinronggongjuOrder.setJinronggongjuOrderTypes(107);
        jinronggongjuOrderService.updateById(jinronggongjuOrder);



        YinhangkaJiluEntity yinhangkaJiluEntity = new YinhangkaJiluEntity();
        yinhangkaJiluEntity.setCreateTime(new Date());
        yinhangkaJiluEntity.setInsertTime(new Date());
        yinhangkaJiluEntity.setYinhangkaId(jinronggongjuOrder.getYinhangkaId());
        yinhangkaJiluEntity.setYinhangkaJiluJine(jinronggongjuOrder.getJinronggongjuOrderHuankuanjine());//金额
        yinhangkaJiluEntity.setYinhangkaJiluContent("还款金融工具,转出了"+yinhangkaJiluEntity.getYinhangkaJiluJine());
        yinhangkaJiluEntity.setYinhangkaJiluTypes(2); //1:购买理财  2:借贷收入 3:还款  4:存款是5:取款6:转账
        yinhangkaJiluEntity.setYinhangkaJiluUuidNumber(String.valueOf(new Date().getTime()));
        yinhangkaJiluService.insert(yinhangkaJiluEntity);
        return R.ok();
    }

    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JinronggongjuOrderEntity jinronggongjuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jinronggongjuOrder:{}",this.getClass().getName(),jinronggongjuOrder.toString());
            JinronggongjuEntity jinronggongjuEntity = jinronggongjuService.selectById(jinronggongjuOrder.getJinronggongjuId());
            if(jinronggongjuEntity == null){
                return R.error(511,"查不到该金融工具");
            }
            // Double jinronggongjuNewMoney = jinronggongjuEntity.getJinronggongjuNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
        YinhangkaEntity yinhangkaEntity = yinhangkaService.selectById(jinronggongjuOrder.getYinhangkaId());
        if(yinhangkaEntity == null)
            return R.error("查不到银行卡");



        if(yinhangkaEntity.getYinhangkaMoney() == null)
                return R.error(511,"银行卡余额为空");
//            double balance = yinhangkaEntity.getYinhangkaMoney() - jinronggongjuEntity.get();//余额
//            if(balance<0)
//                return R.error(511,"余额不够支付");
            jinronggongjuOrder.setJinronggongjuOrderTypes(101); //设置订单状态为已支付
        jinronggongjuOrder.setJinronggongjuOrderHuankuanjine(jinronggongjuOrder.getJinronggongjuOrderJiekuanjine()+jinronggongjuOrder.getJinronggongjuOrderJiekuanjine()*jinronggongjuEntity.getJinronggongjuLilv());
//            jinronggongjuOrder.setJinronggongjuOrderTruePrice(0.0); //设置实付价格
            jinronggongjuOrder.setYonghuId(userId); //设置订单支付人id
            jinronggongjuOrder.setJinronggongjuOrderUuidNumber(String.valueOf(new Date().getTime()));
            jinronggongjuOrder.setJinronggongjuOrderPaymentTypes(1);
            jinronggongjuOrder.setInsertTime(new Date());
            jinronggongjuOrder.setCreateTime(new Date());
                jinronggongjuOrderService.insert(jinronggongjuOrder);//新增订单


            return R.ok();
    }


    /**
    * 取消
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JinronggongjuOrderEntity jinronggongjuOrder = jinronggongjuOrderService.selectById(id);//当前表service
            Integer jinronggongjuOrderPaymentTypes = jinronggongjuOrder.getJinronggongjuOrderPaymentTypes();
            Integer jinronggongjuId = jinronggongjuOrder.getJinronggongjuId();
            if(jinronggongjuId == null)
                return R.error(511,"查不到该金融工具");
            JinronggongjuEntity jinronggongjuEntity = jinronggongjuService.selectById(jinronggongjuId);
            if(jinronggongjuEntity == null)
                return R.error(511,"查不到该金融工具");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(jinronggongjuOrderPaymentTypes == 1){//余额支付
                //计算金额
//                Double money = jinronggongjuEntity.getJinronggongjuNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
//                Double buyJifen = 0.0;


            }


            jinronggongjuOrder.setJinronggongjuOrderYesnoTypes(null);
            jinronggongjuOrder.setJinronggongjuOrderTypes(102);//设置订单状态为已取消
            jinronggongjuOrderService.updateAllColumnById(jinronggongjuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jinronggongjuService.updateById(jinronggongjuEntity);//更新订单中金融工具的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer jinronggongjuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            JinronggongjuOrderEntity jinronggongjuOrder = jinronggongjuOrderService.selectById(id);
        if(jinronggongjuOrder == null)
            return R.error(511,"查不到该订单");
        Integer jinronggongjuId = jinronggongjuOrder.getJinronggongjuId();
        if(jinronggongjuId == null)
            return R.error(511,"查不到该金融工具");

        JinronggongjuCommentbackEntity jinronggongjuCommentbackEntity = new JinronggongjuCommentbackEntity();
            jinronggongjuCommentbackEntity.setId(id);
            jinronggongjuCommentbackEntity.setJinronggongjuId(jinronggongjuId);
            jinronggongjuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            jinronggongjuCommentbackEntity.setJinronggongjuCommentbackText(commentbackText);
            jinronggongjuCommentbackEntity.setInsertTime(new Date());
            jinronggongjuCommentbackEntity.setReplyText(null);
            jinronggongjuCommentbackEntity.setUpdateTime(null);
            jinronggongjuCommentbackEntity.setCreateTime(new Date());
            jinronggongjuCommentbackService.insert(jinronggongjuCommentbackEntity);

            jinronggongjuOrder.setJinronggongjuOrderTypes(105);//设置订单状态为已评价
            jinronggongjuOrderService.updateById(jinronggongjuOrder);//根据id更新
            return R.ok();
    }

    /**
     * 购买成功
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JinronggongjuOrderEntity  jinronggongjuOrderEntity = jinronggongjuOrderService.selectById(id);
        jinronggongjuOrderEntity.setJinronggongjuOrderTypes(103);//设置订单状态为已购买成功
        jinronggongjuOrderService.updateById( jinronggongjuOrderEntity);

        return R.ok();
    }


}

