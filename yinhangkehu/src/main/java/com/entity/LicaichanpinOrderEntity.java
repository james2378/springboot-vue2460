package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 理财产品订单
 *
 * @author 
 * @email
 */
@TableName("licaichanpin_order")
public class LicaichanpinOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LicaichanpinOrderEntity() {

	}

	public LicaichanpinOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "licaichanpin_order_uuid_number")

    private String licaichanpinOrderUuidNumber;


    /**
     * 理财产品
     */
    @ColumnInfo(comment="理财产品",type="int(11)")
    @TableField(value = "licaichanpin_id")

    private Integer licaichanpinId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 银行卡
     */
    @ColumnInfo(comment="银行卡",type="int(11)")
    @TableField(value = "yinhangka_id")

    private Integer yinhangkaId;


    /**
     * 购买份数
     */
    @ColumnInfo(comment="购买份数",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "licaichanpin_order_true_price")

    private Double licaichanpinOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "licaichanpin_order_types")

    private Integer licaichanpinOrderTypes;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "licaichanpin_order_yesno_types")

    private Integer licaichanpinOrderYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "licaichanpin_order_yesno_text")

    private String licaichanpinOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "licaichanpin_order_shenhe_time")

    private Date licaichanpinOrderShenheTime;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "licaichanpin_order_payment_types")

    private Integer licaichanpinOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LicaichanpinOrder{" +
            ", id=" + id +
            ", licaichanpinOrderUuidNumber=" + licaichanpinOrderUuidNumber +
            ", licaichanpinId=" + licaichanpinId +
            ", yonghuId=" + yonghuId +
            ", yinhangkaId=" + yinhangkaId +
            ", buyNumber=" + buyNumber +
            ", licaichanpinOrderTruePrice=" + licaichanpinOrderTruePrice +
            ", licaichanpinOrderTypes=" + licaichanpinOrderTypes +
            ", licaichanpinOrderYesnoTypes=" + licaichanpinOrderYesnoTypes +
            ", licaichanpinOrderYesnoText=" + licaichanpinOrderYesnoText +
            ", licaichanpinOrderShenheTime=" + DateUtil.convertString(licaichanpinOrderShenheTime,"yyyy-MM-dd") +
            ", licaichanpinOrderPaymentTypes=" + licaichanpinOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
