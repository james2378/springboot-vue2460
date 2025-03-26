package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LicaichanpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 理财产品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("licaichanpin")
public class LicaichanpinView extends LicaichanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 投资类型的值
	*/
	@ColumnInfo(comment="投资类型的字典表值",type="varchar(200)")
	private String licaichanpinValue;
	/**
	* 风险等级的值
	*/
	@ColumnInfo(comment="风险等级的字典表值",type="varchar(200)")
	private String licaichanpinFengxianValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public LicaichanpinView() {

	}

	public LicaichanpinView(LicaichanpinEntity licaichanpinEntity) {
		try {
			BeanUtils.copyProperties(this, licaichanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 投资类型的值
	*/
	public String getLicaichanpinValue() {
		return licaichanpinValue;
	}
	/**
	* 设置： 投资类型的值
	*/
	public void setLicaichanpinValue(String licaichanpinValue) {
		this.licaichanpinValue = licaichanpinValue;
	}
	//当前表的
	/**
	* 获取： 风险等级的值
	*/
	public String getLicaichanpinFengxianValue() {
		return licaichanpinFengxianValue;
	}
	/**
	* 设置： 风险等级的值
	*/
	public void setLicaichanpinFengxianValue(String licaichanpinFengxianValue) {
		this.licaichanpinFengxianValue = licaichanpinFengxianValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "LicaichanpinView{" +
			", licaichanpinValue=" + licaichanpinValue +
			", licaichanpinFengxianValue=" + licaichanpinFengxianValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
