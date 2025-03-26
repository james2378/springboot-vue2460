package com.entity.model;

import com.entity.YinhangkaQukuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 取款
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinhangkaQukuanModel implements Serializable {
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
     * 取款编号
     */
    private String yinhangkaQukuanUuidNumber;


    /**
     * 取款金额
     */
    private Double yinhangkaQukuanJine;


    /**
     * 取款备注
     */
    private String yinhangkaQukuanContent;


    /**
     * 取款时间
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
