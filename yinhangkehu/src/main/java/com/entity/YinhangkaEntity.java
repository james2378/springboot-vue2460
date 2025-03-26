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
 * 银行卡
 *
 * @author 
 * @email
 */
@TableName("yinhangka")
public class YinhangkaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinhangkaEntity() {

	}

	public YinhangkaEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 银行卡卡号
     */
    @ColumnInfo(comment="银行卡卡号",type="varchar(200)")
    @TableField(value = "yinhangka_uuid_number")

    private String yinhangkaUuidNumber;


    /**
     * 银行卡照片
     */
    @ColumnInfo(comment="银行卡照片",type="varchar(200)")
    @TableField(value = "yinhangka_photo")

    private String yinhangkaPhoto;


    /**
     * 开卡地
     */
    @ColumnInfo(comment="开卡地",type="varchar(200)")
    @TableField(value = "yinhangka_kaikadi")

    private String yinhangkaKaikadi;


    /**
     * 银行
     */
    @ColumnInfo(comment="银行",type="int(11)")
    @TableField(value = "yinhang_types")

    private Integer yinhangTypes;


    /**
     * 银行卡类型
     */
    @ColumnInfo(comment="银行卡类型",type="int(11)")
    @TableField(value = "yinhangka_types")

    private Integer yinhangkaTypes;


    /**
     * 开卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="开卡日期",type="date")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 编码
     */
    @ColumnInfo(comment="编码",type="varchar(200)")
    @TableField(value = "yinhangka_address")

    private String yinhangkaAddress;


    /**
     * 余额
     */
    @ColumnInfo(comment="余额",type="decimal(10,2)")
    @TableField(value = "yinhangka_money")

    private Double yinhangkaMoney;


    /**
     * 卡片备注
     */
    @ColumnInfo(comment="卡片备注",type="longtext")
    @TableField(value = "yinhangka_content")

    private String yinhangkaContent;


    /**
     * 创建时间   listShow
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
	 * 获取：银行卡卡号
	 */
    public String getYinhangkaUuidNumber() {
        return yinhangkaUuidNumber;
    }
    /**
	 * 设置：银行卡卡号
	 */

    public void setYinhangkaUuidNumber(String yinhangkaUuidNumber) {
        this.yinhangkaUuidNumber = yinhangkaUuidNumber;
    }
    /**
	 * 获取：银行卡照片
	 */
    public String getYinhangkaPhoto() {
        return yinhangkaPhoto;
    }
    /**
	 * 设置：银行卡照片
	 */

    public void setYinhangkaPhoto(String yinhangkaPhoto) {
        this.yinhangkaPhoto = yinhangkaPhoto;
    }
    /**
	 * 获取：开卡地
	 */
    public String getYinhangkaKaikadi() {
        return yinhangkaKaikadi;
    }
    /**
	 * 设置：开卡地
	 */

    public void setYinhangkaKaikadi(String yinhangkaKaikadi) {
        this.yinhangkaKaikadi = yinhangkaKaikadi;
    }
    /**
	 * 获取：银行
	 */
    public Integer getYinhangTypes() {
        return yinhangTypes;
    }
    /**
	 * 设置：银行
	 */

    public void setYinhangTypes(Integer yinhangTypes) {
        this.yinhangTypes = yinhangTypes;
    }
    /**
	 * 获取：银行卡类型
	 */
    public Integer getYinhangkaTypes() {
        return yinhangkaTypes;
    }
    /**
	 * 设置：银行卡类型
	 */

    public void setYinhangkaTypes(Integer yinhangkaTypes) {
        this.yinhangkaTypes = yinhangkaTypes;
    }
    /**
	 * 获取：开卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：开卡日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：编码
	 */
    public String getYinhangkaAddress() {
        return yinhangkaAddress;
    }
    /**
	 * 设置：编码
	 */

    public void setYinhangkaAddress(String yinhangkaAddress) {
        this.yinhangkaAddress = yinhangkaAddress;
    }
    /**
	 * 获取：余额
	 */
    public Double getYinhangkaMoney() {
        return yinhangkaMoney;
    }
    /**
	 * 设置：余额
	 */

    public void setYinhangkaMoney(Double yinhangkaMoney) {
        this.yinhangkaMoney = yinhangkaMoney;
    }
    /**
	 * 获取：卡片备注
	 */
    public String getYinhangkaContent() {
        return yinhangkaContent;
    }
    /**
	 * 设置：卡片备注
	 */

    public void setYinhangkaContent(String yinhangkaContent) {
        this.yinhangkaContent = yinhangkaContent;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yinhangka{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yinhangkaUuidNumber=" + yinhangkaUuidNumber +
            ", yinhangkaPhoto=" + yinhangkaPhoto +
            ", yinhangkaKaikadi=" + yinhangkaKaikadi +
            ", yinhangTypes=" + yinhangTypes +
            ", yinhangkaTypes=" + yinhangkaTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", yinhangkaAddress=" + yinhangkaAddress +
            ", yinhangkaMoney=" + yinhangkaMoney +
            ", yinhangkaContent=" + yinhangkaContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
