package com.entity.vo;

import com.entity.LicaichanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 理财产品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("licaichanpin")
public class LicaichanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 理财产品名称
     */

    @TableField(value = "licaichanpin_name")
    private String licaichanpinName;


    /**
     * 理财产品编号
     */

    @TableField(value = "licaichanpin_uuid_number")
    private String licaichanpinUuidNumber;


    /**
     * 理财产品照片
     */

    @TableField(value = "licaichanpin_photo")
    private String licaichanpinPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 投资类型
     */

    @TableField(value = "licaichanpin_types")
    private Integer licaichanpinTypes;


    /**
     * 发售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fashou_time")
    private Date fashouTime;


    /**
     * 年收益
     */

    @TableField(value = "licaichanpin_nianshouyi")
    private String licaichanpinNianshouyi;


    /**
     * 风险等级
     */

    @TableField(value = "licaichanpin_fengxian_types")
    private Integer licaichanpinFengxianTypes;


    /**
     * 剩余份数
     */

    @TableField(value = "licaichanpin_kucun_number")
    private Integer licaichanpinKucunNumber;


    /**
     * 原价/份
     */

    @TableField(value = "licaichanpin_old_money")
    private Double licaichanpinOldMoney;


    /**
     * 现价/份
     */

    @TableField(value = "licaichanpin_new_money")
    private Double licaichanpinNewMoney;


    /**
     * 理财产品热度
     */

    @TableField(value = "licaichanpin_clicknum")
    private Integer licaichanpinClicknum;


    /**
     * 理财产品介绍
     */

    @TableField(value = "licaichanpin_content")
    private String licaichanpinContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "licaichanpin_delete")
    private Integer licaichanpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：理财产品名称
	 */
    public String getLicaichanpinName() {
        return licaichanpinName;
    }


    /**
	 * 获取：理财产品名称
	 */

    public void setLicaichanpinName(String licaichanpinName) {
        this.licaichanpinName = licaichanpinName;
    }
    /**
	 * 设置：理财产品编号
	 */
    public String getLicaichanpinUuidNumber() {
        return licaichanpinUuidNumber;
    }


    /**
	 * 获取：理财产品编号
	 */

    public void setLicaichanpinUuidNumber(String licaichanpinUuidNumber) {
        this.licaichanpinUuidNumber = licaichanpinUuidNumber;
    }
    /**
	 * 设置：理财产品照片
	 */
    public String getLicaichanpinPhoto() {
        return licaichanpinPhoto;
    }


    /**
	 * 获取：理财产品照片
	 */

    public void setLicaichanpinPhoto(String licaichanpinPhoto) {
        this.licaichanpinPhoto = licaichanpinPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：投资类型
	 */
    public Integer getLicaichanpinTypes() {
        return licaichanpinTypes;
    }


    /**
	 * 获取：投资类型
	 */

    public void setLicaichanpinTypes(Integer licaichanpinTypes) {
        this.licaichanpinTypes = licaichanpinTypes;
    }
    /**
	 * 设置：发售时间
	 */
    public Date getFashouTime() {
        return fashouTime;
    }


    /**
	 * 获取：发售时间
	 */

    public void setFashouTime(Date fashouTime) {
        this.fashouTime = fashouTime;
    }
    /**
	 * 设置：年收益
	 */
    public String getLicaichanpinNianshouyi() {
        return licaichanpinNianshouyi;
    }


    /**
	 * 获取：年收益
	 */

    public void setLicaichanpinNianshouyi(String licaichanpinNianshouyi) {
        this.licaichanpinNianshouyi = licaichanpinNianshouyi;
    }
    /**
	 * 设置：风险等级
	 */
    public Integer getLicaichanpinFengxianTypes() {
        return licaichanpinFengxianTypes;
    }


    /**
	 * 获取：风险等级
	 */

    public void setLicaichanpinFengxianTypes(Integer licaichanpinFengxianTypes) {
        this.licaichanpinFengxianTypes = licaichanpinFengxianTypes;
    }
    /**
	 * 设置：剩余份数
	 */
    public Integer getLicaichanpinKucunNumber() {
        return licaichanpinKucunNumber;
    }


    /**
	 * 获取：剩余份数
	 */

    public void setLicaichanpinKucunNumber(Integer licaichanpinKucunNumber) {
        this.licaichanpinKucunNumber = licaichanpinKucunNumber;
    }
    /**
	 * 设置：原价/份
	 */
    public Double getLicaichanpinOldMoney() {
        return licaichanpinOldMoney;
    }


    /**
	 * 获取：原价/份
	 */

    public void setLicaichanpinOldMoney(Double licaichanpinOldMoney) {
        this.licaichanpinOldMoney = licaichanpinOldMoney;
    }
    /**
	 * 设置：现价/份
	 */
    public Double getLicaichanpinNewMoney() {
        return licaichanpinNewMoney;
    }


    /**
	 * 获取：现价/份
	 */

    public void setLicaichanpinNewMoney(Double licaichanpinNewMoney) {
        this.licaichanpinNewMoney = licaichanpinNewMoney;
    }
    /**
	 * 设置：理财产品热度
	 */
    public Integer getLicaichanpinClicknum() {
        return licaichanpinClicknum;
    }


    /**
	 * 获取：理财产品热度
	 */

    public void setLicaichanpinClicknum(Integer licaichanpinClicknum) {
        this.licaichanpinClicknum = licaichanpinClicknum;
    }
    /**
	 * 设置：理财产品介绍
	 */
    public String getLicaichanpinContent() {
        return licaichanpinContent;
    }


    /**
	 * 获取：理财产品介绍
	 */

    public void setLicaichanpinContent(String licaichanpinContent) {
        this.licaichanpinContent = licaichanpinContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLicaichanpinDelete() {
        return licaichanpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLicaichanpinDelete(Integer licaichanpinDelete) {
        this.licaichanpinDelete = licaichanpinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
