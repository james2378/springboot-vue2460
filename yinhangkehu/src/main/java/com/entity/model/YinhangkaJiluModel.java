package com.entity.model;

import com.entity.YinhangkaJiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 银行卡记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinhangkaJiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 银行卡
     */
    private Integer yinhangkaId;


    /**
     * 记录卡号
     */
    private String yinhangkaJiluUuidNumber;


    /**
     * 银行卡记录类型
     */
    private Integer yinhangkaJiluTypes;


    /**
     * 记录金额
     */
    private Double yinhangkaJiluJine;


    /**
     * 详情
     */
    private String yinhangkaJiluContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
