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
 * 理财产品
 *
 * @author 
 * @email
 */
@TableName("licaichanpin")
public class LicaichanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LicaichanpinEntity() {

	}

	public LicaichanpinEntity(T t) {
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
     * 理财产品名称
     */
    @ColumnInfo(comment="理财产品名称",type="varchar(200)")
    @TableField(value = "licaichanpin_name")

    private String licaichanpinName;


    /**
     * 理财产品编号
     */
    @ColumnInfo(comment="理财产品编号",type="varchar(200)")
    @TableField(value = "licaichanpin_uuid_number")

    private String licaichanpinUuidNumber;


    /**
     * 理财产品照片
     */
    @ColumnInfo(comment="理财产品照片",type="varchar(200)")
    @TableField(value = "licaichanpin_photo")

    private String licaichanpinPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 投资类型
     */
    @ColumnInfo(comment="投资类型",type="int(11)")
    @TableField(value = "licaichanpin_types")

    private Integer licaichanpinTypes;


    /**
     * 发售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发售时间",type="timestamp")
    @TableField(value = "fashou_time")

    private Date fashouTime;


    /**
     * 年收益
     */
    @ColumnInfo(comment="年收益",type="varchar(200)")
    @TableField(value = "licaichanpin_nianshouyi")

    private String licaichanpinNianshouyi;


    /**
     * 风险等级
     */
    @ColumnInfo(comment="风险等级",type="int(11)")
    @TableField(value = "licaichanpin_fengxian_types")

    private Integer licaichanpinFengxianTypes;


    /**
     * 剩余份数
     */
    @ColumnInfo(comment="剩余份数",type="int(11)")
    @TableField(value = "licaichanpin_kucun_number")

    private Integer licaichanpinKucunNumber;


    /**
     * 原价/份
     */
    @ColumnInfo(comment="原价/份",type="decimal(10,2)")
    @TableField(value = "licaichanpin_old_money")

    private Double licaichanpinOldMoney;


    /**
     * 现价/份
     */
    @ColumnInfo(comment="现价/份",type="decimal(10,2)")
    @TableField(value = "licaichanpin_new_money")

    private Double licaichanpinNewMoney;


    /**
     * 理财产品热度
     */
    @ColumnInfo(comment="理财产品热度",type="int(11)")
    @TableField(value = "licaichanpin_clicknum")

    private Integer licaichanpinClicknum;


    /**
     * 理财产品介绍
     */
    @ColumnInfo(comment="理财产品介绍",type="longtext")
    @TableField(value = "licaichanpin_content")

    private String licaichanpinContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "licaichanpin_delete")

    private Integer licaichanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：理财产品名称
	 */
    public String getLicaichanpinName() {
        return licaichanpinName;
    }
    /**
	 * 设置：理财产品名称
	 */

    public void setLicaichanpinName(String licaichanpinName) {
        this.licaichanpinName = licaichanpinName;
    }
    /**
	 * 获取：理财产品编号
	 */
    public String getLicaichanpinUuidNumber() {
        return licaichanpinUuidNumber;
    }
    /**
	 * 设置：理财产品编号
	 */

    public void setLicaichanpinUuidNumber(String licaichanpinUuidNumber) {
        this.licaichanpinUuidNumber = licaichanpinUuidNumber;
    }
    /**
	 * 获取：理财产品照片
	 */
    public String getLicaichanpinPhoto() {
        return licaichanpinPhoto;
    }
    /**
	 * 设置：理财产品照片
	 */

    public void setLicaichanpinPhoto(String licaichanpinPhoto) {
        this.licaichanpinPhoto = licaichanpinPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：投资类型
	 */
    public Integer getLicaichanpinTypes() {
        return licaichanpinTypes;
    }
    /**
	 * 设置：投资类型
	 */

    public void setLicaichanpinTypes(Integer licaichanpinTypes) {
        this.licaichanpinTypes = licaichanpinTypes;
    }
    /**
	 * 获取：发售时间
	 */
    public Date getFashouTime() {
        return fashouTime;
    }
    /**
	 * 设置：发售时间
	 */

    public void setFashouTime(Date fashouTime) {
        this.fashouTime = fashouTime;
    }
    /**
	 * 获取：年收益
	 */
    public String getLicaichanpinNianshouyi() {
        return licaichanpinNianshouyi;
    }
    /**
	 * 设置：年收益
	 */

    public void setLicaichanpinNianshouyi(String licaichanpinNianshouyi) {
        this.licaichanpinNianshouyi = licaichanpinNianshouyi;
    }
    /**
	 * 获取：风险等级
	 */
    public Integer getLicaichanpinFengxianTypes() {
        return licaichanpinFengxianTypes;
    }
    /**
	 * 设置：风险等级
	 */

    public void setLicaichanpinFengxianTypes(Integer licaichanpinFengxianTypes) {
        this.licaichanpinFengxianTypes = licaichanpinFengxianTypes;
    }
    /**
	 * 获取：剩余份数
	 */
    public Integer getLicaichanpinKucunNumber() {
        return licaichanpinKucunNumber;
    }
    /**
	 * 设置：剩余份数
	 */

    public void setLicaichanpinKucunNumber(Integer licaichanpinKucunNumber) {
        this.licaichanpinKucunNumber = licaichanpinKucunNumber;
    }
    /**
	 * 获取：原价/份
	 */
    public Double getLicaichanpinOldMoney() {
        return licaichanpinOldMoney;
    }
    /**
	 * 设置：原价/份
	 */

    public void setLicaichanpinOldMoney(Double licaichanpinOldMoney) {
        this.licaichanpinOldMoney = licaichanpinOldMoney;
    }
    /**
	 * 获取：现价/份
	 */
    public Double getLicaichanpinNewMoney() {
        return licaichanpinNewMoney;
    }
    /**
	 * 设置：现价/份
	 */

    public void setLicaichanpinNewMoney(Double licaichanpinNewMoney) {
        this.licaichanpinNewMoney = licaichanpinNewMoney;
    }
    /**
	 * 获取：理财产品热度
	 */
    public Integer getLicaichanpinClicknum() {
        return licaichanpinClicknum;
    }
    /**
	 * 设置：理财产品热度
	 */

    public void setLicaichanpinClicknum(Integer licaichanpinClicknum) {
        this.licaichanpinClicknum = licaichanpinClicknum;
    }
    /**
	 * 获取：理财产品介绍
	 */
    public String getLicaichanpinContent() {
        return licaichanpinContent;
    }
    /**
	 * 设置：理财产品介绍
	 */

    public void setLicaichanpinContent(String licaichanpinContent) {
        this.licaichanpinContent = licaichanpinContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLicaichanpinDelete() {
        return licaichanpinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLicaichanpinDelete(Integer licaichanpinDelete) {
        this.licaichanpinDelete = licaichanpinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Licaichanpin{" +
            ", id=" + id +
            ", licaichanpinName=" + licaichanpinName +
            ", licaichanpinUuidNumber=" + licaichanpinUuidNumber +
            ", licaichanpinPhoto=" + licaichanpinPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", licaichanpinTypes=" + licaichanpinTypes +
            ", fashouTime=" + DateUtil.convertString(fashouTime,"yyyy-MM-dd") +
            ", licaichanpinNianshouyi=" + licaichanpinNianshouyi +
            ", licaichanpinFengxianTypes=" + licaichanpinFengxianTypes +
            ", licaichanpinKucunNumber=" + licaichanpinKucunNumber +
            ", licaichanpinOldMoney=" + licaichanpinOldMoney +
            ", licaichanpinNewMoney=" + licaichanpinNewMoney +
            ", licaichanpinClicknum=" + licaichanpinClicknum +
            ", licaichanpinContent=" + licaichanpinContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", licaichanpinDelete=" + licaichanpinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
