package com.entity.vo;

import com.entity.JinronggongjuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 金融工具
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jinronggongju")
public class JinronggongjuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 产品名称
     */

    @TableField(value = "jinronggongju_name")
    private String jinronggongjuName;


    /**
     * 金融工具编号
     */

    @TableField(value = "jinronggongju_uuid_number")
    private String jinronggongjuUuidNumber;


    /**
     * 产品照片
     */

    @TableField(value = "jinronggongju_photo")
    private String jinronggongjuPhoto;


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
     * 产品类型
     */

    @TableField(value = "jinronggongju_types")
    private Integer jinronggongjuTypes;


    /**
     * 还款天数
     */

    @TableField(value = "huankuan_number")
    private Integer huankuanNumber;


    /**
     * 利率
     */

    @TableField(value = "jinronggongju_lilv")
    private Double jinronggongjuLilv;


    /**
     * 金融工具热度
     */

    @TableField(value = "jinronggongju_clicknum")
    private Integer jinronggongjuClicknum;


    /**
     * 产品介绍
     */

    @TableField(value = "jinronggongju_content")
    private String jinronggongjuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jinronggongju_delete")
    private Integer jinronggongjuDelete;


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
	 * 设置：产品名称
	 */
    public String getJinronggongjuName() {
        return jinronggongjuName;
    }


    /**
	 * 获取：产品名称
	 */

    public void setJinronggongjuName(String jinronggongjuName) {
        this.jinronggongjuName = jinronggongjuName;
    }
    /**
	 * 设置：金融工具编号
	 */
    public String getJinronggongjuUuidNumber() {
        return jinronggongjuUuidNumber;
    }


    /**
	 * 获取：金融工具编号
	 */

    public void setJinronggongjuUuidNumber(String jinronggongjuUuidNumber) {
        this.jinronggongjuUuidNumber = jinronggongjuUuidNumber;
    }
    /**
	 * 设置：产品照片
	 */
    public String getJinronggongjuPhoto() {
        return jinronggongjuPhoto;
    }


    /**
	 * 获取：产品照片
	 */

    public void setJinronggongjuPhoto(String jinronggongjuPhoto) {
        this.jinronggongjuPhoto = jinronggongjuPhoto;
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
	 * 设置：产品类型
	 */
    public Integer getJinronggongjuTypes() {
        return jinronggongjuTypes;
    }


    /**
	 * 获取：产品类型
	 */

    public void setJinronggongjuTypes(Integer jinronggongjuTypes) {
        this.jinronggongjuTypes = jinronggongjuTypes;
    }
    /**
	 * 设置：还款天数
	 */
    public Integer getHuankuanNumber() {
        return huankuanNumber;
    }


    /**
	 * 获取：还款天数
	 */

    public void setHuankuanNumber(Integer huankuanNumber) {
        this.huankuanNumber = huankuanNumber;
    }
    /**
	 * 设置：利率
	 */
    public Double getJinronggongjuLilv() {
        return jinronggongjuLilv;
    }


    /**
	 * 获取：利率
	 */

    public void setJinronggongjuLilv(Double jinronggongjuLilv) {
        this.jinronggongjuLilv = jinronggongjuLilv;
    }
    /**
	 * 设置：金融工具热度
	 */
    public Integer getJinronggongjuClicknum() {
        return jinronggongjuClicknum;
    }


    /**
	 * 获取：金融工具热度
	 */

    public void setJinronggongjuClicknum(Integer jinronggongjuClicknum) {
        this.jinronggongjuClicknum = jinronggongjuClicknum;
    }
    /**
	 * 设置：产品介绍
	 */
    public String getJinronggongjuContent() {
        return jinronggongjuContent;
    }


    /**
	 * 获取：产品介绍
	 */

    public void setJinronggongjuContent(String jinronggongjuContent) {
        this.jinronggongjuContent = jinronggongjuContent;
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
    public Integer getJinronggongjuDelete() {
        return jinronggongjuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJinronggongjuDelete(Integer jinronggongjuDelete) {
        this.jinronggongjuDelete = jinronggongjuDelete;
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
