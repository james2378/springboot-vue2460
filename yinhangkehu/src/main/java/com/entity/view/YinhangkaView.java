package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YinhangkaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 银行卡
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yinhangka")
public class YinhangkaView extends YinhangkaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 银行的值
	*/
	@ColumnInfo(comment="银行的字典表值",type="varchar(200)")
	private String yinhangValue;
	/**
	* 银行卡类型的值
	*/
	@ColumnInfo(comment="银行卡类型的字典表值",type="varchar(200)")
	private String yinhangkaValue;

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



	public YinhangkaView() {

	}

	public YinhangkaView(YinhangkaEntity yinhangkaEntity) {
		try {
			BeanUtils.copyProperties(this, yinhangkaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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
		return "YinhangkaView{" +
			", yinhangValue=" + yinhangValue +
			", yinhangkaValue=" + yinhangkaValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
