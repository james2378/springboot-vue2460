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
 * 取款
 *
 * @author 
 * @email
 */
@TableName("yinhangka_qukuan")
public class YinhangkaQukuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinhangkaQukuanEntity() {

	}

	public YinhangkaQukuanEntity(T t) {
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
     * 取款编号
     */
    @ColumnInfo(comment="取款编号",type="varchar(200)")
    @TableField(value = "yinhangka_qukuan_uuid_number")

    private String yinhangkaQukuanUuidNumber;


    /**
     * 取款金额
     */
    @ColumnInfo(comment="取款金额",type="decimal(10,2)")
    @TableField(value = "yinhangka_qukuan_jine")

    private Double yinhangkaQukuanJine;


    /**
     * 取款备注
     */
    @ColumnInfo(comment="取款备注",type="longtext")
    @TableField(value = "yinhangka_qukuan_content")

    private String yinhangkaQukuanContent;


    /**
     * 取款时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="取款时间",type="timestamp")
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
	 * 获取：取款编号
	 */
    public String getYinhangkaQukuanUuidNumber() {
        return yinhangkaQukuanUuidNumber;
    }
    /**
	 * 设置：取款编号
	 */

    public void setYinhangkaQukuanUuidNumber(String yinhangkaQukuanUuidNumber) {
        this.yinhangkaQukuanUuidNumber = yinhangkaQukuanUuidNumber;
    }
    /**
	 * 获取：取款金额
	 */
    public Double getYinhangkaQukuanJine() {
        return yinhangkaQukuanJine;
    }
    /**
	 * 设置：取款金额
	 */

    public void setYinhangkaQukuanJine(Double yinhangkaQukuanJine) {
        this.yinhangkaQukuanJine = yinhangkaQukuanJine;
    }
    /**
	 * 获取：取款备注
	 */
    public String getYinhangkaQukuanContent() {
        return yinhangkaQukuanContent;
    }
    /**
	 * 设置：取款备注
	 */

    public void setYinhangkaQukuanContent(String yinhangkaQukuanContent) {
        this.yinhangkaQukuanContent = yinhangkaQukuanContent;
    }
    /**
	 * 获取：取款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：取款时间
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
        return "YinhangkaQukuan{" +
            ", id=" + id +
            ", yinhangkaId=" + yinhangkaId +
            ", yinhangkaQukuanUuidNumber=" + yinhangkaQukuanUuidNumber +
            ", yinhangkaQukuanJine=" + yinhangkaQukuanJine +
            ", yinhangkaQukuanContent=" + yinhangkaQukuanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
