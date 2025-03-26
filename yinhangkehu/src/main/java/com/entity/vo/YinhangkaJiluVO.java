package com.entity.vo;

import com.entity.YinhangkaJiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 银行卡记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinhangka_jilu")
public class YinhangkaJiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 银行卡
     */

    @TableField(value = "yinhangka_id")
    private Integer yinhangkaId;


    /**
     * 记录卡号
     */

    @TableField(value = "yinhangka_jilu_uuid_number")
    private String yinhangkaJiluUuidNumber;


    /**
     * 银行卡记录类型
     */

    @TableField(value = "yinhangka_jilu_types")
    private Integer yinhangkaJiluTypes;


    /**
     * 记录金额
     */

    @TableField(value = "yinhangka_jilu_jine")
    private Double yinhangkaJiluJine;


    /**
     * 详情
     */

    @TableField(value = "yinhangka_jilu_content")
    private String yinhangkaJiluContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：记录卡号
	 */
    public String getYinhangkaJiluUuidNumber() {
        return yinhangkaJiluUuidNumber;
    }


    /**
	 * 获取：记录卡号
	 */

    public void setYinhangkaJiluUuidNumber(String yinhangkaJiluUuidNumber) {
        this.yinhangkaJiluUuidNumber = yinhangkaJiluUuidNumber;
    }
    /**
	 * 设置：银行卡记录类型
	 */
    public Integer getYinhangkaJiluTypes() {
        return yinhangkaJiluTypes;
    }


    /**
	 * 获取：银行卡记录类型
	 */

    public void setYinhangkaJiluTypes(Integer yinhangkaJiluTypes) {
        this.yinhangkaJiluTypes = yinhangkaJiluTypes;
    }
    /**
	 * 设置：记录金额
	 */
    public Double getYinhangkaJiluJine() {
        return yinhangkaJiluJine;
    }


    /**
	 * 获取：记录金额
	 */

    public void setYinhangkaJiluJine(Double yinhangkaJiluJine) {
        this.yinhangkaJiluJine = yinhangkaJiluJine;
    }
    /**
	 * 设置：详情
	 */
    public String getYinhangkaJiluContent() {
        return yinhangkaJiluContent;
    }


    /**
	 * 获取：详情
	 */

    public void setYinhangkaJiluContent(String yinhangkaJiluContent) {
        this.yinhangkaJiluContent = yinhangkaJiluContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
