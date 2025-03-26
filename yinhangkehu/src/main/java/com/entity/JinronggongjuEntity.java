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
 * 金融工具
 *
 * @author 
 * @email
 */
@TableName("jinronggongju")
public class JinronggongjuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JinronggongjuEntity() {

	}

	public JinronggongjuEntity(T t) {
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
     * 产品名称
     */
    @ColumnInfo(comment="产品名称",type="varchar(200)")
    @TableField(value = "jinronggongju_name")

    private String jinronggongjuName;


    /**
     * 金融工具编号
     */
    @ColumnInfo(comment="金融工具编号",type="varchar(200)")
    @TableField(value = "jinronggongju_uuid_number")

    private String jinronggongjuUuidNumber;


    /**
     * 产品照片
     */
    @ColumnInfo(comment="产品照片",type="varchar(200)")
    @TableField(value = "jinronggongju_photo")

    private String jinronggongjuPhoto;


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
     * 产品类型
     */
    @ColumnInfo(comment="产品类型",type="int(11)")
    @TableField(value = "jinronggongju_types")

    private Integer jinronggongjuTypes;


    /**
     * 还款天数
     */
    @ColumnInfo(comment="还款天数",type="int(11)")
    @TableField(value = "huankuan_number")

    private Integer huankuanNumber;


    /**
     * 利率
     */
    @ColumnInfo(comment="利率",type="decimal(10,2)")
    @TableField(value = "jinronggongju_lilv")

    private Double jinronggongjuLilv;


    /**
     * 金融工具热度
     */
    @ColumnInfo(comment="金融工具热度",type="int(11)")
    @TableField(value = "jinronggongju_clicknum")

    private Integer jinronggongjuClicknum;


    /**
     * 产品介绍
     */
    @ColumnInfo(comment="产品介绍",type="longtext")
    @TableField(value = "jinronggongju_content")

    private String jinronggongjuContent;


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
    @TableField(value = "jinronggongju_delete")

    private Integer jinronggongjuDelete;


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
	 * 获取：产品名称
	 */
    public String getJinronggongjuName() {
        return jinronggongjuName;
    }
    /**
	 * 设置：产品名称
	 */

    public void setJinronggongjuName(String jinronggongjuName) {
        this.jinronggongjuName = jinronggongjuName;
    }
    /**
	 * 获取：金融工具编号
	 */
    public String getJinronggongjuUuidNumber() {
        return jinronggongjuUuidNumber;
    }
    /**
	 * 设置：金融工具编号
	 */

    public void setJinronggongjuUuidNumber(String jinronggongjuUuidNumber) {
        this.jinronggongjuUuidNumber = jinronggongjuUuidNumber;
    }
    /**
	 * 获取：产品照片
	 */
    public String getJinronggongjuPhoto() {
        return jinronggongjuPhoto;
    }
    /**
	 * 设置：产品照片
	 */

    public void setJinronggongjuPhoto(String jinronggongjuPhoto) {
        this.jinronggongjuPhoto = jinronggongjuPhoto;
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
	 * 获取：产品类型
	 */
    public Integer getJinronggongjuTypes() {
        return jinronggongjuTypes;
    }
    /**
	 * 设置：产品类型
	 */

    public void setJinronggongjuTypes(Integer jinronggongjuTypes) {
        this.jinronggongjuTypes = jinronggongjuTypes;
    }
    /**
	 * 获取：还款天数
	 */
    public Integer getHuankuanNumber() {
        return huankuanNumber;
    }
    /**
	 * 设置：还款天数
	 */

    public void setHuankuanNumber(Integer huankuanNumber) {
        this.huankuanNumber = huankuanNumber;
    }
    /**
	 * 获取：利率
	 */
    public Double getJinronggongjuLilv() {
        return jinronggongjuLilv;
    }
    /**
	 * 设置：利率
	 */

    public void setJinronggongjuLilv(Double jinronggongjuLilv) {
        this.jinronggongjuLilv = jinronggongjuLilv;
    }
    /**
	 * 获取：金融工具热度
	 */
    public Integer getJinronggongjuClicknum() {
        return jinronggongjuClicknum;
    }
    /**
	 * 设置：金融工具热度
	 */

    public void setJinronggongjuClicknum(Integer jinronggongjuClicknum) {
        this.jinronggongjuClicknum = jinronggongjuClicknum;
    }
    /**
	 * 获取：产品介绍
	 */
    public String getJinronggongjuContent() {
        return jinronggongjuContent;
    }
    /**
	 * 设置：产品介绍
	 */

    public void setJinronggongjuContent(String jinronggongjuContent) {
        this.jinronggongjuContent = jinronggongjuContent;
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
    public Integer getJinronggongjuDelete() {
        return jinronggongjuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJinronggongjuDelete(Integer jinronggongjuDelete) {
        this.jinronggongjuDelete = jinronggongjuDelete;
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
        return "Jinronggongju{" +
            ", id=" + id +
            ", jinronggongjuName=" + jinronggongjuName +
            ", jinronggongjuUuidNumber=" + jinronggongjuUuidNumber +
            ", jinronggongjuPhoto=" + jinronggongjuPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jinronggongjuTypes=" + jinronggongjuTypes +
            ", huankuanNumber=" + huankuanNumber +
            ", jinronggongjuLilv=" + jinronggongjuLilv +
            ", jinronggongjuClicknum=" + jinronggongjuClicknum +
            ", jinronggongjuContent=" + jinronggongjuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jinronggongjuDelete=" + jinronggongjuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
