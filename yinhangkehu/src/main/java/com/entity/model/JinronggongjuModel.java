package com.entity.model;

import com.entity.JinronggongjuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 金融工具
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JinronggongjuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 产品名称
     */
    private String jinronggongjuName;


    /**
     * 金融工具编号
     */
    private String jinronggongjuUuidNumber;


    /**
     * 产品照片
     */
    private String jinronggongjuPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 产品类型
     */
    private Integer jinronggongjuTypes;


    /**
     * 还款天数
     */
    private Integer huankuanNumber;


    /**
     * 利率
     */
    private Double jinronggongjuLilv;


    /**
     * 金融工具热度
     */
    private Integer jinronggongjuClicknum;


    /**
     * 产品介绍
     */
    private String jinronggongjuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jinronggongjuDelete;


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
