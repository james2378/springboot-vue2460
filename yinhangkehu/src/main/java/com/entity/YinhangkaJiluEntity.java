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
 * 银行卡记录
 *
 * @author 
 * @email
 */
@TableName("yinhangka_jilu")
public class YinhangkaJiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinhangkaJiluEntity() {

	}

	public YinhangkaJiluEntity(T t) {
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
     * 银行卡
     */
    @ColumnInfo(comment="银行卡",type="int(11)")
    @TableField(value = "yinhangka_id")

    private Integer yinhangkaId;


    /**
     * 记录卡号
     */
    @ColumnInfo(comment="记录卡号",type="varchar(200)")
    @TableField(value = "yinhangka_jilu_uuid_number")

    private String yinhangkaJiluUuidNumber;


    /**
     * 银行卡记录类型
     */
    @ColumnInfo(comment="银行卡记录类型",type="int(11)")
    @TableField(value = "yinhangka_jilu_types")

    private Integer yinhangkaJiluTypes;


    /**
     * 记录金额
     */
    @ColumnInfo(comment="记录金额",type="decimal(10,2)")
    @TableField(value = "yinhangka_jilu_jine")

    private Double yinhangkaJiluJine;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="longtext")
    @TableField(value = "yinhangka_jilu_content")

    private String yinhangkaJiluContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="记录时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：记录卡号
	 */
    public String getYinhangkaJiluUuidNumber() {
        return yinhangkaJiluUuidNumber;
    }
    /**
	 * 设置：记录卡号
	 */

    public void setYinhangkaJiluUuidNumber(String yinhangkaJiluUuidNumber) {
        this.yinhangkaJiluUuidNumber = yinhangkaJiluUuidNumber;
    }
    /**
	 * 获取：银行卡记录类型
	 */
    public Integer getYinhangkaJiluTypes() {
        return yinhangkaJiluTypes;
    }
    /**
	 * 设置：银行卡记录类型
	 */

    public void setYinhangkaJiluTypes(Integer yinhangkaJiluTypes) {
        this.yinhangkaJiluTypes = yinhangkaJiluTypes;
    }
    /**
	 * 获取：记录金额
	 */
    public Double getYinhangkaJiluJine() {
        return yinhangkaJiluJine;
    }
    /**
	 * 设置：记录金额
	 */

    public void setYinhangkaJiluJine(Double yinhangkaJiluJine) {
        this.yinhangkaJiluJine = yinhangkaJiluJine;
    }
    /**
	 * 获取：详情
	 */
    public String getYinhangkaJiluContent() {
        return yinhangkaJiluContent;
    }
    /**
	 * 设置：详情
	 */

    public void setYinhangkaJiluContent(String yinhangkaJiluContent) {
        this.yinhangkaJiluContent = yinhangkaJiluContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "YinhangkaJilu{" +
            ", id=" + id +
            ", yinhangkaId=" + yinhangkaId +
            ", yinhangkaJiluUuidNumber=" + yinhangkaJiluUuidNumber +
            ", yinhangkaJiluTypes=" + yinhangkaJiluTypes +
            ", yinhangkaJiluJine=" + yinhangkaJiluJine +
            ", yinhangkaJiluContent=" + yinhangkaJiluContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
