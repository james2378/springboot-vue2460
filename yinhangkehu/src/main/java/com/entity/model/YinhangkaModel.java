package com.entity.model;

import com.entity.YinhangkaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 银行卡
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinhangkaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 银行卡卡号
     */
    private String yinhangkaUuidNumber;


    /**
     * 银行卡照片
     */
    private String yinhangkaPhoto;


    /**
     * 开卡地
     */
    private String yinhangkaKaikadi;


    /**
     * 银行
     */
    private Integer yinhangTypes;


    /**
     * 银行卡类型
     */
    private Integer yinhangkaTypes;


    /**
     * 开卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 编码
     */
    private String yinhangkaAddress;


    /**
     * 余额
     */
    private Double yinhangkaMoney;


    /**
     * 卡片备注
     */
    private String yinhangkaContent;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：银行卡卡号
	 */
    public String getYinhangkaUuidNumber() {
        return yinhangkaUuidNumber;
    }


    /**
	 * 设置：银行卡卡号
	 */
    public void setYinhangkaUuidNumber(String yinhangkaUuidNumber) {
        this.yinhangkaUuidNumber = yinhangkaUuidNumber;
    }
    /**
	 * 获取：银行卡照片
	 */
    public String getYinhangkaPhoto() {
        return yinhangkaPhoto;
    }


    /**
	 * 设置：银行卡照片
	 */
    public void setYinhangkaPhoto(String yinhangkaPhoto) {
        this.yinhangkaPhoto = yinhangkaPhoto;
    }
    /**
	 * 获取：开卡地
	 */
    public String getYinhangkaKaikadi() {
        return yinhangkaKaikadi;
    }


    /**
	 * 设置：开卡地
	 */
    public void setYinhangkaKaikadi(String yinhangkaKaikadi) {
        this.yinhangkaKaikadi = yinhangkaKaikadi;
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
	 * 获取：银行卡类型
	 */
    public Integer getYinhangkaTypes() {
        return yinhangkaTypes;
    }


    /**
	 * 设置：银行卡类型
	 */
    public void setYinhangkaTypes(Integer yinhangkaTypes) {
        this.yinhangkaTypes = yinhangkaTypes;
    }
    /**
	 * 获取：开卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：开卡日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：编码
	 */
    public String getYinhangkaAddress() {
        return yinhangkaAddress;
    }


    /**
	 * 设置：编码
	 */
    public void setYinhangkaAddress(String yinhangkaAddress) {
        this.yinhangkaAddress = yinhangkaAddress;
    }
    /**
	 * 获取：余额
	 */
    public Double getYinhangkaMoney() {
        return yinhangkaMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setYinhangkaMoney(Double yinhangkaMoney) {
        this.yinhangkaMoney = yinhangkaMoney;
    }
    /**
	 * 获取：卡片备注
	 */
    public String getYinhangkaContent() {
        return yinhangkaContent;
    }


    /**
	 * 设置：卡片备注
	 */
    public void setYinhangkaContent(String yinhangkaContent) {
        this.yinhangkaContent = yinhangkaContent;
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
