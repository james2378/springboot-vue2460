package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JinronggongjuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 借款
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jinronggongju_order")
public class JinronggongjuOrderView extends JinronggongjuOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String jinronggongjuOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String jinronggongjuOrderPaymentValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String jinronggongjuOrderYesnoValue;

	//级联表 金融工具
		/**
		* 产品名称
		*/

		@ColumnInfo(comment="产品名称",type="varchar(200)")
		private String jinronggongjuName;
		/**
		* 金融工具编号
		*/

		@ColumnInfo(comment="金融工具编号",type="varchar(200)")
		private String jinronggongjuUuidNumber;
		/**
		* 产品照片
		*/

		@ColumnInfo(comment="产品照片",type="varchar(200)")
		private String jinronggongjuPhoto;
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
		* 产品类型
		*/
		@ColumnInfo(comment="产品类型",type="int(11)")
		private Integer jinronggongjuTypes;
			/**
			* 产品类型的值
			*/
			@ColumnInfo(comment="产品类型的字典表值",type="varchar(200)")
			private String jinronggongjuValue;
		/**
		* 还款天数
		*/

		@ColumnInfo(comment="还款天数",type="int(11)")
		private Integer huankuanNumber;
		/**
		* 利率
		*/
		@ColumnInfo(comment="利率",type="decimal(10,2)")
		private Double jinronggongjuLilv;
		/**
		* 金融工具热度
		*/

		@ColumnInfo(comment="金融工具热度",type="int(11)")
		private Integer jinronggongjuClicknum;
		/**
		* 产品介绍
		*/

		@ColumnInfo(comment="产品介绍",type="longtext")
		private String jinronggongjuContent;
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
		private Integer jinronggongjuDelete;
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



	public JinronggongjuOrderView() {

	}

	public JinronggongjuOrderView(JinronggongjuOrderEntity jinronggongjuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, jinronggongjuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getJinronggongjuOrderValue() {
		return jinronggongjuOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setJinronggongjuOrderValue(String jinronggongjuOrderValue) {
		this.jinronggongjuOrderValue = jinronggongjuOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getJinronggongjuOrderPaymentValue() {
		return jinronggongjuOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setJinronggongjuOrderPaymentValue(String jinronggongjuOrderPaymentValue) {
		this.jinronggongjuOrderPaymentValue = jinronggongjuOrderPaymentValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getJinronggongjuOrderYesnoValue() {
		return jinronggongjuOrderYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setJinronggongjuOrderYesnoValue(String jinronggongjuOrderYesnoValue) {
		this.jinronggongjuOrderYesnoValue = jinronggongjuOrderYesnoValue;
	}


	//级联表的get和set 金融工具

		/**
		* 获取： 产品名称
		*/
		public String getJinronggongjuName() {
			return jinronggongjuName;
		}
		/**
		* 设置： 产品名称
		*/
		public void setJinronggongjuName(String jinronggongjuName) {
			this.jinronggongjuName = jinronggongjuName;
		}

		/**
		* 获取： 金融工具编号
		*/
		public String getJinronggongjuUuidNumber() {
			return jinronggongjuUuidNumber;
		}
		/**
		* 设置： 金融工具编号
		*/
		public void setJinronggongjuUuidNumber(String jinronggongjuUuidNumber) {
			this.jinronggongjuUuidNumber = jinronggongjuUuidNumber;
		}

		/**
		* 获取： 产品照片
		*/
		public String getJinronggongjuPhoto() {
			return jinronggongjuPhoto;
		}
		/**
		* 设置： 产品照片
		*/
		public void setJinronggongjuPhoto(String jinronggongjuPhoto) {
			this.jinronggongjuPhoto = jinronggongjuPhoto;
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
		* 获取： 产品类型
		*/
		public Integer getJinronggongjuTypes() {
			return jinronggongjuTypes;
		}
		/**
		* 设置： 产品类型
		*/
		public void setJinronggongjuTypes(Integer jinronggongjuTypes) {
			this.jinronggongjuTypes = jinronggongjuTypes;
		}


			/**
			* 获取： 产品类型的值
			*/
			public String getJinronggongjuValue() {
				return jinronggongjuValue;
			}
			/**
			* 设置： 产品类型的值
			*/
			public void setJinronggongjuValue(String jinronggongjuValue) {
				this.jinronggongjuValue = jinronggongjuValue;
			}

		/**
		* 获取： 还款天数
		*/
		public Integer getHuankuanNumber() {
			return huankuanNumber;
		}
		/**
		* 设置： 还款天数
		*/
		public void setHuankuanNumber(Integer huankuanNumber) {
			this.huankuanNumber = huankuanNumber;
		}

		/**
		* 获取： 利率
		*/
		public Double getJinronggongjuLilv() {
			return jinronggongjuLilv;
		}
		/**
		* 设置： 利率
		*/
		public void setJinronggongjuLilv(Double jinronggongjuLilv) {
			this.jinronggongjuLilv = jinronggongjuLilv;
		}

		/**
		* 获取： 金融工具热度
		*/
		public Integer getJinronggongjuClicknum() {
			return jinronggongjuClicknum;
		}
		/**
		* 设置： 金融工具热度
		*/
		public void setJinronggongjuClicknum(Integer jinronggongjuClicknum) {
			this.jinronggongjuClicknum = jinronggongjuClicknum;
		}

		/**
		* 获取： 产品介绍
		*/
		public String getJinronggongjuContent() {
			return jinronggongjuContent;
		}
		/**
		* 设置： 产品介绍
		*/
		public void setJinronggongjuContent(String jinronggongjuContent) {
			this.jinronggongjuContent = jinronggongjuContent;
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
		public Integer getJinronggongjuDelete() {
			return jinronggongjuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJinronggongjuDelete(Integer jinronggongjuDelete) {
			this.jinronggongjuDelete = jinronggongjuDelete;
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
		return "JinronggongjuOrderView{" +
			", jinronggongjuOrderValue=" + jinronggongjuOrderValue +
			", jinronggongjuOrderPaymentValue=" + jinronggongjuOrderPaymentValue +
			", jinronggongjuOrderYesnoValue=" + jinronggongjuOrderYesnoValue +
			", jinronggongjuName=" + jinronggongjuName +
			", jinronggongjuUuidNumber=" + jinronggongjuUuidNumber +
			", jinronggongjuPhoto=" + jinronggongjuPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", huankuanNumber=" + huankuanNumber +
			", jinronggongjuLilv=" + jinronggongjuLilv +
			", jinronggongjuClicknum=" + jinronggongjuClicknum +
			", jinronggongjuContent=" + jinronggongjuContent +
			", jinronggongjuDelete=" + jinronggongjuDelete +
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
