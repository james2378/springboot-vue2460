package com.entity.vo;

import com.entity.YinhangkaQukuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 取款
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinhangka_qukuan")
public class YinhangkaQukuanVO implements Serializable {
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
     * 取款编号
     */

    @TableField(value = "yinhangka_qukuan_uuid_number")
    private String yinhangkaQukuanUuidNumber;


    /**
     * 取款金额
     */

    @TableField(value = "yinhangka_qukuan_jine")
    private Double yinhangkaQukuanJine;


    /**
     * 取款备注
     */

    @TableField(value = "yinhangka_qukuan_content")
    private String yinhangkaQukuanContent;


    /**
     * 取款时间
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
	 * 设置：取款编号
	 */
    public String getYinhangkaQukuanUuidNumber() {
        return yinhangkaQukuanUuidNumber;
    }


    /**
	 * 获取：取款编号
	 */

    public void setYinhangkaQukuanUuidNumber(String yinhangkaQukuanUuidNumber) {
        this.yinhangkaQukuanUuidNumber = yinhangkaQukuanUuidNumber;
    }
    /**
	 * 设置：取款金额
	 */
    public Double getYinhangkaQukuanJine() {
        return yinhangkaQukuanJine;
    }


    /**
	 * 获取：取款金额
	 */

    public void setYinhangkaQukuanJine(Double yinhangkaQukuanJine) {
        this.yinhangkaQukuanJine = yinhangkaQukuanJine;
    }
    /**
	 * 设置：取款备注
	 */
    public String getYinhangkaQukuanContent() {
        return yinhangkaQukuanContent;
    }


    /**
	 * 获取：取款备注
	 */

    public void setYinhangkaQukuanContent(String yinhangkaQukuanContent) {
        this.yinhangkaQukuanContent = yinhangkaQukuanContent;
    }
    /**
	 * 设置：取款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：取款时间
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
