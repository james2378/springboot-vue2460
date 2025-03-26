package com.entity.vo;

import com.entity.YinhangkaCunkuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 存款
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinhangka_cunkuan")
public class YinhangkaCunkuanVO implements Serializable {
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
     * 存款编号
     */

    @TableField(value = "yinhangka_cunkuan_uuid_number")
    private String yinhangkaCunkuanUuidNumber;


    /**
     * 存款金额
     */

    @TableField(value = "yinhangka_cunkuan_jine")
    private Double yinhangkaCunkuanJine;


    /**
     * 存款备注
     */

    @TableField(value = "yinhangka_cunkuan_content")
    private String yinhangkaCunkuanContent;


    /**
     * 存款时间
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
	 * 设置：存款编号
	 */
    public String getYinhangkaCunkuanUuidNumber() {
        return yinhangkaCunkuanUuidNumber;
    }


    /**
	 * 获取：存款编号
	 */

    public void setYinhangkaCunkuanUuidNumber(String yinhangkaCunkuanUuidNumber) {
        this.yinhangkaCunkuanUuidNumber = yinhangkaCunkuanUuidNumber;
    }
    /**
	 * 设置：存款金额
	 */
    public Double getYinhangkaCunkuanJine() {
        return yinhangkaCunkuanJine;
    }


    /**
	 * 获取：存款金额
	 */

    public void setYinhangkaCunkuanJine(Double yinhangkaCunkuanJine) {
        this.yinhangkaCunkuanJine = yinhangkaCunkuanJine;
    }
    /**
	 * 设置：存款备注
	 */
    public String getYinhangkaCunkuanContent() {
        return yinhangkaCunkuanContent;
    }


    /**
	 * 获取：存款备注
	 */

    public void setYinhangkaCunkuanContent(String yinhangkaCunkuanContent) {
        this.yinhangkaCunkuanContent = yinhangkaCunkuanContent;
    }
    /**
	 * 设置：存款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：存款时间
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
