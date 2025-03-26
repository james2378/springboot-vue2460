package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YinhangkaQukuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 取款
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yinhangka_qukuan")
public class YinhangkaQukuanView extends YinhangkaQukuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 银行卡
					 
		/**
		* 银行卡 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer yinhangkaYonghuId;
		/**
		* 银行卡卡号
		*/

		@ColumnInfo(comment="银行卡卡号",type="varchar(200)")
		private String yinhangkaUuidNumber;
		/**
		* 银行卡照片
		*/

		@ColumnInfo(comment="银行卡照片",type="varchar(200)")
		private String yinhangkaPhoto;
		/**
		* 开卡地
		*/

		@ColumnInfo(comment="开卡地",type="varchar(200)")
		private String yinhangkaKaikadi;
		/**
		* 银行
		*/
		@ColumnInfo(comment="银行",type="int(11)")
		private Integer yinhangTypes;
			/**
			* 银行的值
			*/
			@ColumnInfo(comment="银行的字典表值",type="varchar(200)")
			private String yinhangValue;
		/**
		* 银行卡类型
		*/
		@ColumnInfo(comment="银行卡类型",type="int(11)")
		private Integer yinhangkaTypes;
			/**
			* 银行卡类型的值
			*/
			@ColumnInfo(comment="银行卡类型的字典表值",type="varchar(200)")
			private String yinhangkaValue;
		/**
		* 编码
		*/

		@ColumnInfo(comment="编码",type="varchar(200)")
		private String yinhangkaAddress;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double yinhangkaMoney;
		/**
		* 卡片备注
		*/

		@ColumnInfo(comment="卡片备注",type="longtext")
		private String yinhangkaContent;



	public YinhangkaQukuanView() {

	}

	public YinhangkaQukuanView(YinhangkaQukuanEntity yinhangkaQukuanEntity) {
		try {
			BeanUtils.copyProperties(this, yinhangkaQukuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 银行卡
		/**
		* 获取：银行卡 的 用户
		*/
		public Integer getYinhangkaYonghuId() {
			return yinhangkaYonghuId;
		}
		/**
		* 设置：银行卡 的 用户
		*/
		public void setYinhangkaYonghuId(Integer yinhangkaYonghuId) {
			this.yinhangkaYonghuId = yinhangkaYonghuId;
		}

		/**
		* 获取： 银行卡卡号
		*/
		public String getYinhangkaUuidNumber() {
			return yinhangkaUuidNumber;
		}
		/**
		* 设置： 银行卡卡号
		*/
		public void setYinhangkaUuidNumber(String yinhangkaUuidNumber) {
			this.yinhangkaUuidNumber = yinhangkaUuidNumber;
		}

		/**
		* 获取： 银行卡照片
		*/
		public String getYinhangkaPhoto() {
			return yinhangkaPhoto;
		}
		/**
		* 设置： 银行卡照片
		*/
		public void setYinhangkaPhoto(String yinhangkaPhoto) {
			this.yinhangkaPhoto = yinhangkaPhoto;
		}

		/**
		* 获取： 开卡地
		*/
		public String getYinhangkaKaikadi() {
			return yinhangkaKaikadi;
		}
		/**
		* 设置： 开卡地
		*/
		public void setYinhangkaKaikadi(String yinhangkaKaikadi) {
			this.yinhangkaKaikadi = yinhangkaKaikadi;
		}
		/**
		* 获取： 银行
		*/
		public Integer getYinhangTypes() {
			return yinhangTypes;
		}
		/**
		* 设置： 银行
		*/
		public void setYinhangTypes(Integer yinhangTypes) {
			this.yinhangTypes = yinhangTypes;
		}


			/**
			* 获取： 银行的值
			*/
			public String getYinhangValue() {
				return yinhangValue;
			}
			/**
			* 设置： 银行的值
			*/
			public void setYinhangValue(String yinhangValue) {
				this.yinhangValue = yinhangValue;
			}
		/**
		* 获取： 银行卡类型
		*/
		public Integer getYinhangkaTypes() {
			return yinhangkaTypes;
		}
		/**
		* 设置： 银行卡类型
		*/
		public void setYinhangkaTypes(Integer yinhangkaTypes) {
			this.yinhangkaTypes = yinhangkaTypes;
		}


			/**
			* 获取： 银行卡类型的值
			*/
			public String getYinhangkaValue() {
				return yinhangkaValue;
			}
			/**
			* 设置： 银行卡类型的值
			*/
			public void setYinhangkaValue(String yinhangkaValue) {
				this.yinhangkaValue = yinhangkaValue;
			}

		/**
		* 获取： 编码
		*/
		public String getYinhangkaAddress() {
			return yinhangkaAddress;
		}
		/**
		* 设置： 编码
		*/
		public void setYinhangkaAddress(String yinhangkaAddress) {
			this.yinhangkaAddress = yinhangkaAddress;
		}

		/**
		* 获取： 余额
		*/
		public Double getYinhangkaMoney() {
			return yinhangkaMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setYinhangkaMoney(Double yinhangkaMoney) {
			this.yinhangkaMoney = yinhangkaMoney;
		}

		/**
		* 获取： 卡片备注
		*/
		public String getYinhangkaContent() {
			return yinhangkaContent;
		}
		/**
		* 设置： 卡片备注
		*/
		public void setYinhangkaContent(String yinhangkaContent) {
			this.yinhangkaContent = yinhangkaContent;
		}


	@Override
	public String toString() {
		return "YinhangkaQukuanView{" +
			", yinhangkaUuidNumber=" + yinhangkaUuidNumber +
			", yinhangkaPhoto=" + yinhangkaPhoto +
			", yinhangkaKaikadi=" + yinhangkaKaikadi +
			", yinhangkaAddress=" + yinhangkaAddress +
			", yinhangkaMoney=" + yinhangkaMoney +
			", yinhangkaContent=" + yinhangkaContent +
			"} " + super.toString();
	}
}
