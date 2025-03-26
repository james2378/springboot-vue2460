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
 * 借款
 *
 * @author 
 * @email
 */
@TableName("jinronggongju_order")
public class JinronggongjuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JinronggongjuOrderEntity() {

	}

	public JinronggongjuOrderEntity(T t) {
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
    @TableField(value = "jinronggongju_order_uuid_number")

    private String jinronggongjuOrderUuidNumber;


    /**
     * 金融工具
     */
    @ColumnInfo(comment="金融工具",type="int(11)")
    @TableField(value = "jinronggongju_id")

    private Integer jinronggongjuId;


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
     * 借款金额
     */
    @ColumnInfo(comment="借款金额",type="decimal(10,2)")
    @TableField(value = "jinronggongju_order_jiekuanjine")

    private Double jinronggongjuOrderJiekuanjine;


    /**
     * 还款金额
     */
    @ColumnInfo(comment="还款金额",type="decimal(10,2)")
    @TableField(value = "jinronggongju_order_huankuanjine")

    private Double jinronggongjuOrderHuankuanjine;


    /**
     * 最晚还款日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="最晚还款日期",type="timestamp")
    @TableField(value = "zuiwanhuankuan_time")

    private Date zuiwanhuankuanTime;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "jinronggongju_order_types")

    private Integer jinronggongjuOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "jinronggongju_order_payment_types")

    private Integer jinronggongjuOrderPaymentTypes;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "jinronggongju_order_yesno_types")

    private Integer jinronggongjuOrderYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "jinronggongju_order_yesno_text")

    private String jinronggongjuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "jinronggongju_order_shenhe_time")

    private Date jinronggongjuOrderShenheTime;


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
    public String getJinronggongjuOrderUuidNumber() {
        return jinronggongjuOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setJinronggongjuOrderUuidNumber(String jinronggongjuOrderUuidNumber) {
        this.jinronggongjuOrderUuidNumber = jinronggongjuOrderUuidNumber;
    }
    /**
	 * 获取：金融工具
	 */
    public Integer getJinronggongjuId() {
        return jinronggongjuId;
    }
    /**
	 * 设置：金融工具
	 */

    public void setJinronggongjuId(Integer jinronggongjuId) {
        this.jinronggongjuId = jinronggongjuId;
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
	 * 获取：借款金额
	 */
    public Double getJinronggongjuOrderJiekuanjine() {
        return jinronggongjuOrderJiekuanjine;
    }
    /**
	 * 设置：借款金额
	 */

    public void setJinronggongjuOrderJiekuanjine(Double jinronggongjuOrderJiekuanjine) {
        this.jinronggongjuOrderJiekuanjine = jinronggongjuOrderJiekuanjine;
    }
    /**
	 * 获取：还款金额
	 */
    public Double getJinronggongjuOrderHuankuanjine() {
        return jinronggongjuOrderHuankuanjine;
    }
    /**
	 * 设置：还款金额
	 */

    public void setJinronggongjuOrderHuankuanjine(Double jinronggongjuOrderHuankuanjine) {
        this.jinronggongjuOrderHuankuanjine = jinronggongjuOrderHuankuanjine;
    }
    /**
	 * 获取：最晚还款日期
	 */
    public Date getZuiwanhuankuanTime() {
        return zuiwanhuankuanTime;
    }
    /**
	 * 设置：最晚还款日期
	 */

    public void setZuiwanhuankuanTime(Date zuiwanhuankuanTime) {
        this.zuiwanhuankuanTime = zuiwanhuankuanTime;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getJinronggongjuOrderTypes() {
        return jinronggongjuOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setJinronggongjuOrderTypes(Integer jinronggongjuOrderTypes) {
        this.jinronggongjuOrderTypes = jinronggongjuOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getJinronggongjuOrderPaymentTypes() {
        return jinronggongjuOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setJinronggongjuOrderPaymentTypes(Integer jinronggongjuOrderPaymentTypes) {
        this.jinronggongjuOrderPaymentTypes = jinronggongjuOrderPaymentTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getJinronggongjuOrderYesnoTypes() {
        return jinronggongjuOrderYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setJinronggongjuOrderYesnoTypes(Integer jinronggongjuOrderYesnoTypes) {
        this.jinronggongjuOrderYesnoTypes = jinronggongjuOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getJinronggongjuOrderYesnoText() {
        return jinronggongjuOrderYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setJinronggongjuOrderYesnoText(String jinronggongjuOrderYesnoText) {
        this.jinronggongjuOrderYesnoText = jinronggongjuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getJinronggongjuOrderShenheTime() {
        return jinronggongjuOrderShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setJinronggongjuOrderShenheTime(Date jinronggongjuOrderShenheTime) {
        this.jinronggongjuOrderShenheTime = jinronggongjuOrderShenheTime;
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
        return "JinronggongjuOrder{" +
            ", id=" + id +
            ", jinronggongjuOrderUuidNumber=" + jinronggongjuOrderUuidNumber +
            ", jinronggongjuId=" + jinronggongjuId +
            ", yonghuId=" + yonghuId +
            ", yinhangkaId=" + yinhangkaId +
            ", jinronggongjuOrderJiekuanjine=" + jinronggongjuOrderJiekuanjine +
            ", jinronggongjuOrderHuankuanjine=" + jinronggongjuOrderHuankuanjine +
            ", zuiwanhuankuanTime=" + DateUtil.convertString(zuiwanhuankuanTime,"yyyy-MM-dd") +
            ", jinronggongjuOrderTypes=" + jinronggongjuOrderTypes +
            ", jinronggongjuOrderPaymentTypes=" + jinronggongjuOrderPaymentTypes +
            ", jinronggongjuOrderYesnoTypes=" + jinronggongjuOrderYesnoTypes +
            ", jinronggongjuOrderYesnoText=" + jinronggongjuOrderYesnoText +
            ", jinronggongjuOrderShenheTime=" + DateUtil.convertString(jinronggongjuOrderShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
