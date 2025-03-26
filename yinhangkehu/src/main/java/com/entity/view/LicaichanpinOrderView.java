package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LicaichanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 理财产品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("licaichanpin_order")
public class LicaichanpinOrderView extends LicaichanpinOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String licaichanpinOrderValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String licaichanpinOrderYesnoValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String licaichanpinOrderPaymentValue;

	//级联表 理财产品
		/**
		* 理财产品名称
		*/

		@ColumnInfo(comment="理财产品名称",type="varchar(200)")
		private String licaichanpinName;
		/**
		* 理财产品编号
		*/

		@ColumnInfo(comment="理财产品编号",type="varchar(200)")
		private String licaichanpinUuidNumber;
		/**
		* 理财产品照片
		*/

		@ColumnInfo(comment="理财产品照片",type="varchar(200)")
		private String licaichanpinPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 投资类型
		*/
		@ColumnInfo(comment="投资类型",type="int(11)")
		private Integer licaichanpinTypes;
			/**
			* 投资类型的值
			*/
			@ColumnInfo(comment="投资类型的字典表值",type="varchar(200)")
			private String licaichanpinValue;
		/**
		* 发售时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="发售时间",type="timestamp")
		private Date fashouTime;
		/**
		* 年收益
		*/

		@ColumnInfo(comment="年收益",type="varchar(200)")
		private String licaichanpinNianshouyi;
		/**
		* 风险等级
		*/
		@ColumnInfo(comment="风险等级",type="int(11)")
		private Integer licaichanpinFengxianTypes;
			/**
			* 风险等级的值
			*/
			@ColumnInfo(comment="风险等级的字典表值",type="varchar(200)")
			private String licaichanpinFengxianValue;
		/**
		* 剩余份数
		*/

		@ColumnInfo(comment="剩余份数",type="int(11)")
		private Integer licaichanpinKucunNumber;
		/**
		* 原价/份
		*/
		@ColumnInfo(comment="原价/份",type="decimal(10,2)")
		private Double licaichanpinOldMoney;
		/**
		* 现价/份
		*/
		@ColumnInfo(comment="现价/份",type="decimal(10,2)")
		private Double licaichanpinNewMoney;
		/**
		* 理财产品热度
		*/

		@ColumnInfo(comment="理财产品热度",type="int(11)")
		private Integer licaichanpinClicknum;
		/**
		* 理财产品介绍
		*/

		@ColumnInfo(comment="理财产品介绍",type="longtext")
		private String licaichanpinContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer licaichanpinDelete;
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
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 征信等级
		*/
		@ColumnInfo(comment="征信等级",type="int(11)")
		private Integer zhengxindengjiTypes;
			/**
			* 征信等级的值
			*/
			@ColumnInfo(comment="征信等级的字典表值",type="varchar(200)")
			private String zhengxindengjiValue;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public LicaichanpinOrderView() {

	}

	public LicaichanpinOrderView(LicaichanpinOrderEntity licaichanpinOrderEntity) {
		try {
			BeanUtils.copyProperties(this, licaichanpinOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getLicaichanpinOrderValue() {
		return licaichanpinOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setLicaichanpinOrderValue(String licaichanpinOrderValue) {
		this.licaichanpinOrderValue = licaichanpinOrderValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getLicaichanpinOrderYesnoValue() {
		return licaichanpinOrderYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setLicaichanpinOrderYesnoValue(String licaichanpinOrderYesnoValue) {
		this.licaichanpinOrderYesnoValue = licaichanpinOrderYesnoValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getLicaichanpinOrderPaymentValue() {
		return licaichanpinOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setLicaichanpinOrderPaymentValue(String licaichanpinOrderPaymentValue) {
		this.licaichanpinOrderPaymentValue = licaichanpinOrderPaymentValue;
	}


	//级联表的get和set 理财产品

		/**
		* 获取： 理财产品名称
		*/
		public String getLicaichanpinName() {
			return licaichanpinName;
		}
		/**
		* 设置： 理财产品名称
		*/
		public void setLicaichanpinName(String licaichanpinName) {
			this.licaichanpinName = licaichanpinName;
		}

		/**
		* 获取： 理财产品编号
		*/
		public String getLicaichanpinUuidNumber() {
			return licaichanpinUuidNumber;
		}
		/**
		* 设置： 理财产品编号
		*/
		public void setLicaichanpinUuidNumber(String licaichanpinUuidNumber) {
			this.licaichanpinUuidNumber = licaichanpinUuidNumber;
		}

		/**
		* 获取： 理财产品照片
		*/
		public String getLicaichanpinPhoto() {
			return licaichanpinPhoto;
		}
		/**
		* 设置： 理财产品照片
		*/
		public void setLicaichanpinPhoto(String licaichanpinPhoto) {
			this.licaichanpinPhoto = licaichanpinPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 投资类型
		*/
		public Integer getLicaichanpinTypes() {
			return licaichanpinTypes;
		}
		/**
		* 设置： 投资类型
		*/
		public void setLicaichanpinTypes(Integer licaichanpinTypes) {
			this.licaichanpinTypes = licaichanpinTypes;
		}


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

		/**
		* 获取： 发售时间
		*/
		public Date getFashouTime() {
			return fashouTime;
		}
		/**
		* 设置： 发售时间
		*/
		public void setFashouTime(Date fashouTime) {
			this.fashouTime = fashouTime;
		}

		/**
		* 获取： 年收益
		*/
		public String getLicaichanpinNianshouyi() {
			return licaichanpinNianshouyi;
		}
		/**
		* 设置： 年收益
		*/
		public void setLicaichanpinNianshouyi(String licaichanpinNianshouyi) {
			this.licaichanpinNianshouyi = licaichanpinNianshouyi;
		}
		/**
		* 获取： 风险等级
		*/
		public Integer getLicaichanpinFengxianTypes() {
			return licaichanpinFengxianTypes;
		}
		/**
		* 设置： 风险等级
		*/
		public void setLicaichanpinFengxianTypes(Integer licaichanpinFengxianTypes) {
			this.licaichanpinFengxianTypes = licaichanpinFengxianTypes;
		}


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

		/**
		* 获取： 剩余份数
		*/
		public Integer getLicaichanpinKucunNumber() {
			return licaichanpinKucunNumber;
		}
		/**
		* 设置： 剩余份数
		*/
		public void setLicaichanpinKucunNumber(Integer licaichanpinKucunNumber) {
			this.licaichanpinKucunNumber = licaichanpinKucunNumber;
		}

		/**
		* 获取： 原价/份
		*/
		public Double getLicaichanpinOldMoney() {
			return licaichanpinOldMoney;
		}
		/**
		* 设置： 原价/份
		*/
		public void setLicaichanpinOldMoney(Double licaichanpinOldMoney) {
			this.licaichanpinOldMoney = licaichanpinOldMoney;
		}

		/**
		* 获取： 现价/份
		*/
		public Double getLicaichanpinNewMoney() {
			return licaichanpinNewMoney;
		}
		/**
		* 设置： 现价/份
		*/
		public void setLicaichanpinNewMoney(Double licaichanpinNewMoney) {
			this.licaichanpinNewMoney = licaichanpinNewMoney;
		}

		/**
		* 获取： 理财产品热度
		*/
		public Integer getLicaichanpinClicknum() {
			return licaichanpinClicknum;
		}
		/**
		* 设置： 理财产品热度
		*/
		public void setLicaichanpinClicknum(Integer licaichanpinClicknum) {
			this.licaichanpinClicknum = licaichanpinClicknum;
		}

		/**
		* 获取： 理财产品介绍
		*/
		public String getLicaichanpinContent() {
			return licaichanpinContent;
		}
		/**
		* 设置： 理财产品介绍
		*/
		public void setLicaichanpinContent(String licaichanpinContent) {
			this.licaichanpinContent = licaichanpinContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getLicaichanpinDelete() {
			return licaichanpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setLicaichanpinDelete(Integer licaichanpinDelete) {
			this.licaichanpinDelete = licaichanpinDelete;
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
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 征信等级
		*/
		public Integer getZhengxindengjiTypes() {
			return zhengxindengjiTypes;
		}
		/**
		* 设置： 征信等级
		*/
		public void setZhengxindengjiTypes(Integer zhengxindengjiTypes) {
			this.zhengxindengjiTypes = zhengxindengjiTypes;
		}


			/**
			* 获取： 征信等级的值
			*/
			public String getZhengxindengjiValue() {
				return zhengxindengjiValue;
			}
			/**
			* 设置： 征信等级的值
			*/
			public void setZhengxindengjiValue(String zhengxindengjiValue) {
				this.zhengxindengjiValue = zhengxindengjiValue;
			}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "LicaichanpinOrderView{" +
			", licaichanpinOrderValue=" + licaichanpinOrderValue +
			", licaichanpinOrderYesnoValue=" + licaichanpinOrderYesnoValue +
			", licaichanpinOrderPaymentValue=" + licaichanpinOrderPaymentValue +
			", licaichanpinName=" + licaichanpinName +
			", licaichanpinUuidNumber=" + licaichanpinUuidNumber +
			", licaichanpinPhoto=" + licaichanpinPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", fashouTime=" + DateUtil.convertString(fashouTime,"yyyy-MM-dd") +
			", licaichanpinNianshouyi=" + licaichanpinNianshouyi +
			", licaichanpinKucunNumber=" + licaichanpinKucunNumber +
			", licaichanpinOldMoney=" + licaichanpinOldMoney +
			", licaichanpinNewMoney=" + licaichanpinNewMoney +
			", licaichanpinClicknum=" + licaichanpinClicknum +
			", licaichanpinContent=" + licaichanpinContent +
			", licaichanpinDelete=" + licaichanpinDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yinhangkaUuidNumber=" + yinhangkaUuidNumber +
			", yinhangkaPhoto=" + yinhangkaPhoto +
			", yinhangkaKaikadi=" + yinhangkaKaikadi +
			", yinhangkaAddress=" + yinhangkaAddress +
			", yinhangkaMoney=" + yinhangkaMoney +
			", yinhangkaContent=" + yinhangkaContent +
			"} " + super.toString();
	}
}
