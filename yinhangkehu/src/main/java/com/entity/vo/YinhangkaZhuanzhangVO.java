package com.entity.vo;

import com.entity.YinhangkaZhuanzhangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 转账
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinhangka_zhuanzhang")
public class YinhangkaZhuanzhangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 银行卡
     */

    @TableField(value = "yinhangka_id")
    private Integer yinhangkaId;


    /**
     * 转账编号
     */

    @TableField(value = "yinhangka_zhuanzhang_uuid_number")
    private String yinhangkaZhuanzhangUuidNumber;


    /**
     * 转账金额
     */

    @TableField(value = "yinhangka_zhuanzhang_jine")
    private Double yinhangkaZhuanzhangJine;


    /**
     * 银行
     */

    @TableField(value = "yinhang_types")
    private Integer yinhangTypes;


    /**
     * 接收卡号
     */

    @TableField(value = "yinhangka_zhuanzhang_jieshou_kahao")
    private String yinhangkaZhuanzhangJieshouKahao;


    /**
     * 转账备注
     */

    @TableField(value = "yinhangka_zhuanzhang_content")
    private String yinhangkaZhuanzhangContent;


    /**
     * 转账时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：银行卡
	 */
    public Integer getYinhangkaId() {
        return yinhangkaId;
    }


    /**
	 * 获取：银行卡
	 */

    public void setYinhangkaId(Integer yinhangkaId) {
        this.yinhangkaId = yinhangkaId;
    }
    /**
	 * 设置：转账编号
	 */
    public String getYinhangkaZhuanzhangUuidNumber() {
        return yinhangkaZhuanzhangUuidNumber;
    }


    /**
	 * 获取：转账编号
	 */

    public void setYinhangkaZhuanzhangUuidNumber(String yinhangkaZhuanzhangUuidNumber) {
        this.yinhangkaZhuanzhangUuidNumber = yinhangkaZhuanzhangUuidNumber;
    }
    /**
	 * 设置：转账金额
	 */
    public Double getYinhangkaZhuanzhangJine() {
        return yinhangkaZhuanzhangJine;
    }


    /**
	 * 获取：转账金额
	 */

    public void setYinhangkaZhuanzhangJine(Double yinhangkaZhuanzhangJine) {
        this.yinhangkaZhuanzhangJine = yinhangkaZhuanzhangJine;
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
	 * 设置：接收卡号
	 */
    public String getYinhangkaZhuanzhangJieshouKahao() {
        return yinhangkaZhuanzhangJieshouKahao;
    }


    /**
	 * 获取：接收卡号
	 */

    public void setYinhangkaZhuanzhangJieshouKahao(String yinhangkaZhuanzhangJieshouKahao) {
        this.yinhangkaZhuanzhangJieshouKahao = yinhangkaZhuanzhangJieshouKahao;
    }
    /**
	 * 设置：转账备注
	 */
    public String getYinhangkaZhuanzhangContent() {
        return yinhangkaZhuanzhangContent;
    }


    /**
	 * 获取：转账备注
	 */

    public void setYinhangkaZhuanzhangContent(String yinhangkaZhuanzhangContent) {
        this.yinhangkaZhuanzhangContent = yinhangkaZhuanzhangContent;
    }
    /**
	 * 设置：转账时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：转账时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
