package com.entity.vo;

import com.entity.JinronggongjuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 借款
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jinronggongju_order")
public class JinronggongjuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "jinronggongju_order_uuid_number")
    private String jinronggongjuOrderUuidNumber;


    /**
     * 金融工具
     */

    @TableField(value = "jinronggongju_id")
    private Integer jinronggongjuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 银行卡
     */

    @TableField(value = "yinhangka_id")
    private Integer yinhangkaId;


    /**
     * 借款金额
     */

    @TableField(value = "jinronggongju_order_jiekuanjine")
    private Double jinronggongjuOrderJiekuanjine;


    /**
     * 还款金额
     */

    @TableField(value = "jinronggongju_order_huankuanjine")
    private Double jinronggongjuOrderHuankuanjine;


    /**
     * 最晚还款日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zuiwanhuankuan_time")
    private Date zuiwanhuankuanTime;


    /**
     * 订单类型
     */

    @TableField(value = "jinronggongju_order_types")
    private Integer jinronggongjuOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "jinronggongju_order_payment_types")
    private Integer jinronggongjuOrderPaymentTypes;


    /**
     * 审核状态
     */

    @TableField(value = "jinronggongju_order_yesno_types")
    private Integer jinronggongjuOrderYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "jinronggongju_order_yesno_text")
    private String jinronggongjuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jinronggongju_order_shenhe_time")
    private Date jinronggongjuOrderShenheTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getJinronggongjuOrderUuidNumber() {
        return jinronggongjuOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setJinronggongjuOrderUuidNumber(String jinronggongjuOrderUuidNumber) {
        this.jinronggongjuOrderUuidNumber = jinronggongjuOrderUuidNumber;
    }
    /**
	 * 设置：金融工具
	 */
    public Integer getJinronggongjuId() {
        return jinronggongjuId;
    }


    /**
	 * 获取：金融工具
	 */

    public void setJinronggongjuId(Integer jinronggongjuId) {
        this.jinronggongjuId = jinronggongjuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：银行卡
	 */
    public Integer getYinhangkaId() {
        return yinhangkaId;
    }


    /**
	 * 获取：银行卡
	 */

    public void setYinhangkaId(Integer yinhangkaId) {
        this.yinhangkaId = yinhangkaId;
    }
    /**
	 * 设置：借款金额
	 */
    public Double getJinronggongjuOrderJiekuanjine() {
        return jinronggongjuOrderJiekuanjine;
    }


    /**
	 * 获取：借款金额
	 */

    public void setJinronggongjuOrderJiekuanjine(Double jinronggongjuOrderJiekuanjine) {
        this.jinronggongjuOrderJiekuanjine = jinronggongjuOrderJiekuanjine;
    }
    /**
	 * 设置：还款金额
	 */
    public Double getJinronggongjuOrderHuankuanjine() {
        return jinronggongjuOrderHuankuanjine;
    }


    /**
	 * 获取：还款金额
	 */

    public void setJinronggongjuOrderHuankuanjine(Double jinronggongjuOrderHuankuanjine) {
        this.jinronggongjuOrderHuankuanjine = jinronggongjuOrderHuankuanjine;
    }
    /**
	 * 设置：最晚还款日期
	 */
    public Date getZuiwanhuankuanTime() {
        return zuiwanhuankuanTime;
    }


    /**
	 * 获取：最晚还款日期
	 */

    public void setZuiwanhuankuanTime(Date zuiwanhuankuanTime) {
        this.zuiwanhuankuanTime = zuiwanhuankuanTime;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJinronggongjuOrderTypes() {
        return jinronggongjuOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJinronggongjuOrderTypes(Integer jinronggongjuOrderTypes) {
        this.jinronggongjuOrderTypes = jinronggongjuOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getJinronggongjuOrderPaymentTypes() {
        return jinronggongjuOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setJinronggongjuOrderPaymentTypes(Integer jinronggongjuOrderPaymentTypes) {
        this.jinronggongjuOrderPaymentTypes = jinronggongjuOrderPaymentTypes;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getJinronggongjuOrderYesnoTypes() {
        return jinronggongjuOrderYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setJinronggongjuOrderYesnoTypes(Integer jinronggongjuOrderYesnoTypes) {
        this.jinronggongjuOrderYesnoTypes = jinronggongjuOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getJinronggongjuOrderYesnoText() {
        return jinronggongjuOrderYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setJinronggongjuOrderYesnoText(String jinronggongjuOrderYesnoText) {
        this.jinronggongjuOrderYesnoText = jinronggongjuOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getJinronggongjuOrderShenheTime() {
        return jinronggongjuOrderShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setJinronggongjuOrderShenheTime(Date jinronggongjuOrderShenheTime) {
        this.jinronggongjuOrderShenheTime = jinronggongjuOrderShenheTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
