package com.entity.model;

import com.entity.YinhangkaCunkuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 存款
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinhangkaCunkuanModel implements Serializable {
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
     * 存款编号
     */
    private String yinhangkaCunkuanUuidNumber;


    /**
     * 存款金额
     */
    private Double yinhangkaCunkuanJine;


    /**
     * 存款备注
     */
    private String yinhangkaCunkuanContent;


    /**
     * 存款时间
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
	 * 获取：存款编号
	 */
    public String getYinhangkaCunkuanUuidNumber() {
        return yinhangkaCunkuanUuidNumber;
    }


    /**
	 * 设置：存款编号
	 */
    public void setYinhangkaCunkuanUuidNumber(String yinhangkaCunkuanUuidNumber) {
        this.yinhangkaCunkuanUuidNumber = yinhangkaCunkuanUuidNumber;
    }
    /**
	 * 获取：存款金额
	 */
    public Double getYinhangkaCunkuanJine() {
        return yinhangkaCunkuanJine;
    }


    /**
	 * 设置：存款金额
	 */
    public void setYinhangkaCunkuanJine(Double yinhangkaCunkuanJine) {
        this.yinhangkaCunkuanJine = yinhangkaCunkuanJine;
    }
    /**
	 * 获取：存款备注
	 */
    public String getYinhangkaCunkuanContent() {
        return yinhangkaCunkuanContent;
    }


    /**
	 * 设置：存款备注
	 */
    public void setYinhangkaCunkuanContent(String yinhangkaCunkuanContent) {
        this.yinhangkaCunkuanContent = yinhangkaCunkuanContent;
    }
    /**
	 * 获取：存款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：存款时间
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
