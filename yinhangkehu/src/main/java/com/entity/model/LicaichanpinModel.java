package com.entity.model;

import com.entity.LicaichanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 理财产品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LicaichanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 理财产品名称
     */
    private String licaichanpinName;


    /**
     * 理财产品编号
     */
    private String licaichanpinUuidNumber;


    /**
     * 理财产品照片
     */
    private String licaichanpinPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 投资类型
     */
    private Integer licaichanpinTypes;


    /**
     * 发售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fashouTime;


    /**
     * 年收益
     */
    private String licaichanpinNianshouyi;


    /**
     * 风险等级
     */
    private Integer licaichanpinFengxianTypes;


    /**
     * 剩余份数
     */
    private Integer licaichanpinKucunNumber;


    /**
     * 原价/份
     */
    private Double licaichanpinOldMoney;


    /**
     * 现价/份
     */
    private Double licaichanpinNewMoney;


    /**
     * 理财产品热度
     */
    private Integer licaichanpinClicknum;


    /**
     * 理财产品介绍
     */
    private String licaichanpinContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer licaichanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：理财产品名称
	 */
    public String getLicaichanpinName() {
        return licaichanpinName;
    }


    /**
	 * 设置：理财产品名称
	 */
    public void setLicaichanpinName(String licaichanpinName) {
        this.licaichanpinName = licaichanpinName;
    }
    /**
	 * 获取：理财产品编号
	 */
    public String getLicaichanpinUuidNumber() {
        return licaichanpinUuidNumber;
    }


    /**
	 * 设置：理财产品编号
	 */
    public void setLicaichanpinUuidNumber(String licaichanpinUuidNumber) {
        this.licaichanpinUuidNumber = licaichanpinUuidNumber;
    }
    /**
	 * 获取：理财产品照片
	 */
    public String getLicaichanpinPhoto() {
        return licaichanpinPhoto;
    }


    /**
	 * 设置：理财产品照片
	 */
    public void setLicaichanpinPhoto(String licaichanpinPhoto) {
        this.licaichanpinPhoto = licaichanpinPhoto;
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
	 * 获取：投资类型
	 */
    public Integer getLicaichanpinTypes() {
        return licaichanpinTypes;
    }


    /**
	 * 设置：投资类型
	 */
    public void setLicaichanpinTypes(Integer licaichanpinTypes) {
        this.licaichanpinTypes = licaichanpinTypes;
    }
    /**
	 * 获取：发售时间
	 */
    public Date getFashouTime() {
        return fashouTime;
    }


    /**
	 * 设置：发售时间
	 */
    public void setFashouTime(Date fashouTime) {
        this.fashouTime = fashouTime;
    }
    /**
	 * 获取：年收益
	 */
    public String getLicaichanpinNianshouyi() {
        return licaichanpinNianshouyi;
    }


    /**
	 * 设置：年收益
	 */
    public void setLicaichanpinNianshouyi(String licaichanpinNianshouyi) {
        this.licaichanpinNianshouyi = licaichanpinNianshouyi;
    }
    /**
	 * 获取：风险等级
	 */
    public Integer getLicaichanpinFengxianTypes() {
        return licaichanpinFengxianTypes;
    }


    /**
	 * 设置：风险等级
	 */
    public void setLicaichanpinFengxianTypes(Integer licaichanpinFengxianTypes) {
        this.licaichanpinFengxianTypes = licaichanpinFengxianTypes;
    }
    /**
	 * 获取：剩余份数
	 */
    public Integer getLicaichanpinKucunNumber() {
        return licaichanpinKucunNumber;
    }


    /**
	 * 设置：剩余份数
	 */
    public void setLicaichanpinKucunNumber(Integer licaichanpinKucunNumber) {
        this.licaichanpinKucunNumber = licaichanpinKucunNumber;
    }
    /**
	 * 获取：原价/份
	 */
    public Double getLicaichanpinOldMoney() {
        return licaichanpinOldMoney;
    }


    /**
	 * 设置：原价/份
	 */
    public void setLicaichanpinOldMoney(Double licaichanpinOldMoney) {
        this.licaichanpinOldMoney = licaichanpinOldMoney;
    }
    /**
	 * 获取：现价/份
	 */
    public Double getLicaichanpinNewMoney() {
        return licaichanpinNewMoney;
    }


    /**
	 * 设置：现价/份
	 */
    public void setLicaichanpinNewMoney(Double licaichanpinNewMoney) {
        this.licaichanpinNewMoney = licaichanpinNewMoney;
    }
    /**
	 * 获取：理财产品热度
	 */
    public Integer getLicaichanpinClicknum() {
        return licaichanpinClicknum;
    }


    /**
	 * 设置：理财产品热度
	 */
    public void setLicaichanpinClicknum(Integer licaichanpinClicknum) {
        this.licaichanpinClicknum = licaichanpinClicknum;
    }
    /**
	 * 获取：理财产品介绍
	 */
    public String getLicaichanpinContent() {
        return licaichanpinContent;
    }


    /**
	 * 设置：理财产品介绍
	 */
    public void setLicaichanpinContent(String licaichanpinContent) {
        this.licaichanpinContent = licaichanpinContent;
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
    public Integer getLicaichanpinDelete() {
        return licaichanpinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setLicaichanpinDelete(Integer licaichanpinDelete) {
        this.licaichanpinDelete = licaichanpinDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
