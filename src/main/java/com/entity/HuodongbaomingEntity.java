package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 活动报名
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@TableName("huodongbaoming")
public class HuodongbaomingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuodongbaomingEntity() {
		
	}
	
	public HuodongbaomingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;

	/**
	 * 活动id
	 */
//	private Long huodongid;
	/**
	 * 活动主题
	 */
					
	private String huodongzhuti;
	
	/**
	 * 活动类型
	 */
					
//	private String huodongleixing;
	
	/**
	 * 活动地点
	 */
					
	private String huodongdidian;
	
	/**
	 * 组织编号
	 */
					
//	private String zuzhibianhao;
	
	/**
	 * 组织名称
	 */
					
//	private String zuzhimingcheng;
	
	/**
	 * 志愿者账号
	 */
					
	private String zhiyuanzhezhanghao;
	
	/**
	 * 志愿者姓名
	 */
					
	private String zhiyuanzhexingming;
	
	/**
	 * 报名理由
	 */
					
	private String baomingliyou;
	
	/**
	 * 报名时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baomingshijian;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	/**
//	 * 获取：活动ID
//	 */
//	public Long getHuodongid() {
//		return huodongid;
//	}
//
//	/**
//	 * 设置：活动ID
//	 */
//	public void setHuodongid(Long huodongid) {
//		this.huodongid = huodongid;
//	}

	/**
	 * 设置：活动主题
	 */
	public void setHuodongzhuti(String huodongzhuti) {
		this.huodongzhuti = huodongzhuti;
	}
	/**
	 * 获取：活动主题
	 */
	public String getHuodongzhuti() {
		return huodongzhuti;
	}
//	/**
//	 * 设置：活动类型
//	 */
//	public void setHuodongleixing(String huodongleixing) {
//		this.huodongleixing = huodongleixing;
//	}
//	/**
//	 * 获取：活动类型
//	 */
//	public String getHuodongleixing() {
//		return huodongleixing;
//	}
	/**
	 * 设置：活动地点
	 */
	public void setHuodongdidian(String huodongdidian) {
		this.huodongdidian = huodongdidian;
	}
	/**
	 * 获取：活动地点
	 */
	public String getHuodongdidian() {
		return huodongdidian;
	}
//	/**
//	 * 设置：组织编号
//	 */
//	public void setZuzhibianhao(String zuzhibianhao) {
//		this.zuzhibianhao = zuzhibianhao;
//	}
//	/**
//	 * 获取：组织编号
//	 */
//	public String getZuzhibianhao() {
//		return zuzhibianhao;
//	}
//	/**
//	 * 设置：组织名称
//	 */
//	public void setZuzhimingcheng(String zuzhimingcheng) {
//		this.zuzhimingcheng = zuzhimingcheng;
//	}
//	/**
//	 * 获取：组织名称
//	 */
//	public String getZuzhimingcheng() {
//		return zuzhimingcheng;
//	}
	/**
	 * 设置：志愿者账号
	 */
	public void setZhiyuanzhezhanghao(String zhiyuanzhezhanghao) {
		this.zhiyuanzhezhanghao = zhiyuanzhezhanghao;
	}
	/**
	 * 获取：志愿者账号
	 */
	public String getZhiyuanzhezhanghao() {
		return zhiyuanzhezhanghao;
	}
	/**
	 * 设置：志愿者姓名
	 */
	public void setZhiyuanzhexingming(String zhiyuanzhexingming) {
		this.zhiyuanzhexingming = zhiyuanzhexingming;
	}
	/**
	 * 获取：志愿者姓名
	 */
	public String getZhiyuanzhexingming() {
		return zhiyuanzhexingming;
	}
	/**
	 * 设置：报名理由
	 */
	public void setBaomingliyou(String baomingliyou) {
		this.baomingliyou = baomingliyou;
	}
	/**
	 * 获取：报名理由
	 */
	public String getBaomingliyou() {
		return baomingliyou;
	}
	/**
	 * 设置：报名时间
	 */
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	/**
	 * 获取：报名时间
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
