package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JinronggongjuCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 金融工具评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jinronggongju_commentback")
public class JinronggongjuCommentbackView extends JinronggongjuCommentbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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



	public JinronggongjuCommentbackView() {

	}

	public JinronggongjuCommentbackView(JinronggongjuCommentbackEntity jinronggongjuCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, jinronggongjuCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return "JinronggongjuCommentbackView{" +
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
			"} " + super.toString();
	}
}
