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
 * 转账
 *
 * @author 
 * @email
 */
@TableName("yinhangka_zhuanzhang")
public class YinhangkaZhuanzhangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinhangkaZhuanzhangEntity() {

	}

	public YinhangkaZhuanzhangEntity(T t) {
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
     * 转账编号
     */
    @ColumnInfo(comment="转账编号",type="varchar(200)")
    @TableField(value = "yinhangka_zhuanzhang_uuid_number")

    private String yinhangkaZhuanzhangUuidNumber;


    /**
     * 转账金额
     */
    @ColumnInfo(comment="转账金额",type="decimal(10,2)")
    @TableField(value = "yinhangka_zhuanzhang_jine")

    private Double yinhangkaZhuanzhangJine;


    /**
     * 银行
     */
    @ColumnInfo(comment="银行",type="int(11)")
    @TableField(value = "yinhang_types")

    private Integer yinhangTypes;


    /**
     * 接收卡号
     */
    @ColumnInfo(comment="接收卡号",type="varchar(200)")
    @TableField(value = "yinhangka_zhuanzhang_jieshou_kahao")

    private String yinhangkaZhuanzhangJieshouKahao;


    /**
     * 转账备注
     */
    @ColumnInfo(comment="转账备注",type="longtext")
    @TableField(value = "yinhangka_zhuanzhang_content")

    private String yinhangkaZhuanzhangContent;


    /**
     * 转账时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="转账时间",type="timestamp")
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
	 * 获取：转账编号
	 */
    public String getYinhangkaZhuanzhangUuidNumber() {
        return yinhangkaZhuanzhangUuidNumber;
    }
    /**
	 * 设置：转账编号
	 */

    public void setYinhangkaZhuanzhangUuidNumber(String yinhangkaZhuanzhangUuidNumber) {
        this.yinhangkaZhuanzhangUuidNumber = yinhangkaZhuanzhangUuidNumber;
    }
    /**
	 * 获取：转账金额
	 */
    public Double getYinhangkaZhuanzhangJine() {
        return yinhangkaZhuanzhangJine;
    }
    /**
	 * 设置：转账金额
	 */

    public void setYinhangkaZhuanzhangJine(Double yinhangkaZhuanzhangJine) {
        this.yinhangkaZhuanzhangJine = yinhangkaZhuanzhangJine;
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
	 * 获取：接收卡号
	 */
    public String getYinhangkaZhuanzhangJieshouKahao() {
        return yinhangkaZhuanzhangJieshouKahao;
    }
    /**
	 * 设置：接收卡号
	 */

    public void setYinhangkaZhuanzhangJieshouKahao(String yinhangkaZhuanzhangJieshouKahao) {
        this.yinhangkaZhuanzhangJieshouKahao = yinhangkaZhuanzhangJieshouKahao;
    }
    /**
	 * 获取：转账备注
	 */
    public String getYinhangkaZhuanzhangContent() {
        return yinhangkaZhuanzhangContent;
    }
    /**
	 * 设置：转账备注
	 */

    public void setYinhangkaZhuanzhangContent(String yinhangkaZhuanzhangContent) {
        this.yinhangkaZhuanzhangContent = yinhangkaZhuanzhangContent;
    }
    /**
	 * 获取：转账时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：转账时间
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
        return "YinhangkaZhuanzhang{" +
            ", id=" + id +
            ", yinhangkaId=" + yinhangkaId +
            ", yinhangkaZhuanzhangUuidNumber=" + yinhangkaZhuanzhangUuidNumber +
            ", yinhangkaZhuanzhangJine=" + yinhangkaZhuanzhangJine +
            ", yinhangTypes=" + yinhangTypes +
            ", yinhangkaZhuanzhangJieshouKahao=" + yinhangkaZhuanzhangJieshouKahao +
            ", yinhangkaZhuanzhangContent=" + yinhangkaZhuanzhangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
