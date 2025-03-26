package com.entity.model;

import com.entity.LicaichanpinOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 理财产品订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LicaichanpinOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String licaichanpinOrderUuidNumber;


    /**
     * 理财产品
     */
    private Integer licaichanpinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 银行卡
     */
    private Integer yinhangkaId;


    /**
     * 购买份数
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double licaichanpinOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer licaichanpinOrderTypes;


    /**
     * 审核状态
     */
    private Integer licaichanpinOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String licaichanpinOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date licaichanpinOrderShenheTime;


    /**
     * 支付类型
     */
    private Integer licaichanpinOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getLicaichanpinOrderUuidNumber() {
        return licaichanpinOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setLicaichanpinOrderUuidNumber(String licaichanpinOrderUuidNumber) {
        this.licaichanpinOrderUuidNumber = licaichanpinOrderUuidNumber;
    }
    /**
	 * 获取：理财产品
	 */
    public Integer getLicaichanpinId() {
        return licaichanpinId;
    }


    /**
	 * 设置：理财产品
	 */
    public void setLicaichanpinId(Integer licaichanpinId) {
        this.licaichanpinId = licaichanpinId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：银行卡
	 */
    public Integer getYinhangkaId() {
        return yinhangkaId;
    }


    /**
	 * 设置：银行卡
	 */
    public void setYinhangkaId(Integer yinhangkaId) {
        this.yinhangkaId = yinhangkaId;
    }
    /**
	 * 获取：购买份数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买份数
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getLicaichanpinOrderTruePrice() {
        return licaichanpinOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setLicaichanpinOrderTruePrice(Double licaichanpinOrderTruePrice) {
        this.licaichanpinOrderTruePrice = licaichanpinOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getLicaichanpinOrderTypes() {
        return licaichanpinOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setLicaichanpinOrderTypes(Integer licaichanpinOrderTypes) {
        this.licaichanpinOrderTypes = licaichanpinOrderTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getLicaichanpinOrderYesnoTypes() {
        return licaichanpinOrderYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setLicaichanpinOrderYesnoTypes(Integer licaichanpinOrderYesnoTypes) {
        this.licaichanpinOrderYesnoTypes = licaichanpinOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getLicaichanpinOrderYesnoText() {
        return licaichanpinOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setLicaichanpinOrderYesnoText(String licaichanpinOrderYesnoText) {
        this.licaichanpinOrderYesnoText = licaichanpinOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLicaichanpinOrderShenheTime() {
        return licaichanpinOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setLicaichanpinOrderShenheTime(Date licaichanpinOrderShenheTime) {
        this.licaichanpinOrderShenheTime = licaichanpinOrderShenheTime;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getLicaichanpinOrderPaymentTypes() {
        return licaichanpinOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setLicaichanpinOrderPaymentTypes(Integer licaichanpinOrderPaymentTypes) {
        this.licaichanpinOrderPaymentTypes = licaichanpinOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
