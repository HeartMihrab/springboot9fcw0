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
 * 志愿组织
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@TableName("zhiyuanzuzhi")
public class ZhiyuanzuzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhiyuanzuzhiEntity() {
		
	}
	
	public ZhiyuanzuzhiEntity(T t) {
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
	 * 组织编号
	 */
					
	private String zuzhibianhao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 组织名称
	 */
					
	private String zuzhimingcheng;
	
	/**
	 * 组织logo
	 */
					
	private String tupian;
	
	/**
	 * 成立时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chenglishijian;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 组织简介
	 */
					
	private String zuzhijianjie;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
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
	/**
	 * 设置：组织编号
	 */
	public void setZuzhibianhao(String zuzhibianhao) {
		this.zuzhibianhao = zuzhibianhao;
	}
	/**
	 * 获取：组织编号
	 */
	public String getZuzhibianhao() {
		return zuzhibianhao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：组织名称
	 */
	public void setZuzhimingcheng(String zuzhimingcheng) {
		this.zuzhimingcheng = zuzhimingcheng;
	}
	/**
	 * 获取：组织名称
	 */
	public String getZuzhimingcheng() {
		return zuzhimingcheng;
	}
	/**
	 * 设置：组织logo
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：组织logo
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：成立时间
	 */
	public void setChenglishijian(Date chenglishijian) {
		this.chenglishijian = chenglishijian;
	}
	/**
	 * 获取：成立时间
	 */
	public Date getChenglishijian() {
		return chenglishijian;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：组织简介
	 */
	public void setZuzhijianjie(String zuzhijianjie) {
		this.zuzhijianjie = zuzhijianjie;
	}
	/**
	 * 获取：组织简介
	 */
	public String getZuzhijianjie() {
		return zuzhijianjie;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
