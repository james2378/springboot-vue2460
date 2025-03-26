package com.entity.model;

import com.entity.YinhangkaZhuanzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 转账
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinhangkaZhuanzhangModel implements Serializable {
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
     * 转账编号
     */
    private String yinhangkaZhuanzhangUuidNumber;


    /**
     * 转账金额
     */
    private Double yinhangkaZhuanzhangJine;


    /**
     * 银行
     */
    private Integer yinhangTypes;


    /**
     * 接收卡号
     */
    private String yinhangkaZhuanzhangJieshouKahao;


    /**
     * 转账备注
     */
    private String yinhangkaZhuanzhangContent;


    /**
     * 转账时间
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
