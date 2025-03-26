package com.entity.vo;

import com.entity.YinhangkaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 银行卡
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinhangka")
public class YinhangkaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 银行卡卡号
     */

    @TableField(value = "yinhangka_uuid_number")
    private String yinhangkaUuidNumber;


    /**
     * 银行卡照片
     */

    @TableField(value = "yinhangka_photo")
    private String yinhangkaPhoto;


    /**
     * 开卡地
     */

    @TableField(value = "yinhangka_kaikadi")
    private String yinhangkaKaikadi;


    /**
     * 银行
     */

    @TableField(value = "yinhang_types")
    private Integer yinhangTypes;


    /**
     * 银行卡类型
     */

    @TableField(value = "yinhangka_types")
    private Integer yinhangkaTypes;


    /**
     * 开卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 编码
     */

    @TableField(value = "yinhangka_address")
    private String yinhangkaAddress;


    /**
     * 余额
     */

    @TableField(value = "yinhangka_money")
    private Double yinhangkaMoney;


    /**
     * 卡片备注
     */

    @TableField(value = "yinhangka_content")
    private String yinhangkaContent;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：银行卡卡号
	 */
    public String getYinhangkaUuidNumber() {
        return yinhangkaUuidNumber;
    }


    /**
	 * 获取：银行卡卡号
	 */

    public void setYinhangkaUuidNumber(String yinhangkaUuidNumber) {
        this.yinhangkaUuidNumber = yinhangkaUuidNumber;
    }
    /**
	 * 设置：银行卡照片
	 */
    public String getYinhangkaPhoto() {
        return yinhangkaPhoto;
    }


    /**
	 * 获取：银行卡照片
	 */

    public void setYinhangkaPhoto(String yinhangkaPhoto) {
        this.yinhangkaPhoto = yinhangkaPhoto;
    }
    /**
	 * 设置：开卡地
	 */
    public String getYinhangkaKaikadi() {
        return yinhangkaKaikadi;
    }


    /**
	 * 获取：开卡地
	 */

    public void setYinhangkaKaikadi(String yinhangkaKaikadi) {
        this.yinhangkaKaikadi = yinhangkaKaikadi;
    }
    /**
	 * 设置：银行
	 */
    public Integer getYinhangTypes() {
        return yinhangTypes;
    }


    /**
	 * 获取：银行
	 */

    public void setYinhangTypes(Integer yinhangTypes) {
        this.yinhangTypes = yinhangTypes;
    }
    /**
	 * 设置：银行卡类型
	 */
    public Integer getYinhangkaTypes() {
        return yinhangkaTypes;
    }


    /**
	 * 获取：银行卡类型
	 */

    public void setYinhangkaTypes(Integer yinhangkaTypes) {
        this.yinhangkaTypes = yinhangkaTypes;
    }
    /**
	 * 设置：开卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：开卡日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：编码
	 */
    public String getYinhangkaAddress() {
        return yinhangkaAddress;
    }


    /**
	 * 获取：编码
	 */

    public void setYinhangkaAddress(String yinhangkaAddress) {
        this.yinhangkaAddress = yinhangkaAddress;
    }
    /**
	 * 设置：余额
	 */
    public Double getYinhangkaMoney() {
        return yinhangkaMoney;
    }


    /**
	 * 获取：余额
	 */

    public void setYinhangkaMoney(Double yinhangkaMoney) {
        this.yinhangkaMoney = yinhangkaMoney;
    }
    /**
	 * 设置：卡片备注
	 */
    public String getYinhangkaContent() {
        return yinhangkaContent;
    }


    /**
	 * 获取：卡片备注
	 */

    public void setYinhangkaContent(String yinhangkaContent) {
        this.yinhangkaContent = yinhangkaContent;
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
