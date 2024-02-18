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
 * 志愿活动
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@TableName("zhiyuanhuodong")
public class ZhiyuanhuodongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhiyuanhuodongEntity() {
		
	}
	
	public ZhiyuanhuodongEntity(T t) {
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
	 * 活动主题
	 */
					
	private String huodongzhuti;
	
	/**
	 * 活动类型
	 */
					
	private String huodongleixing;
	
	/**
	 * 活动图片
	 */
					
	private String huodongtupian;

	/**
	 * 积分
	 */

	private Integer jifen;

	/**
	 * 活动地点
	 */

	private String huodongdidian;

	/**
	 * 参加人数
	 */
	private Long renshu;

	/**
	 * 开始时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date kaishishijian;

	/**
	 * 结束时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date jieshushijian;

	/**
	 * 活动详情
	 */

	private String huodongxiangqing;



//	private String zuzhibianhao;

	/**
	 * 组织名称
	 */

//	private String zuzhimingcheng;
	/**
	 * 发布时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	private Date fabushijian;


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

	/**
	 * 设置：活动类型
	 */
	public void setHuodongleixing(String huodongleixing) {
		this.huodongleixing = huodongleixing;
	}
	/**
	 * 获取：活动类型
	 */
	public String getHuodongleixing() {
		return huodongleixing;
	}
	/**
	 * 设置：活动图片
	 */
	public void setHuodongtupian(String huodongtupian) {
		this.huodongtupian = huodongtupian;
	}
	/**
	 * 获取：活动图片
	 */
	public String getHuodongtupian() {
		return huodongtupian;
	}

	/**
	 * 获取：活动积分
	 */
	public Integer getJifen() {
		return jifen;
	}

	/**
	 * 设置：活动积分
	 */
	public void setJifen(Integer jifen) {
		this.jifen = jifen;
	}
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
	/**
	 * 设置：参加人数
	 */
	public void setRenshu(Long renshu) {
		this.renshu = renshu;
	}
	/**
	 * 获取：参加人数
	 */
	public Long getRenshu() {
		return renshu;
	}
	/**
	 * 设置：开始时间
	 */
	public void setKaishishijian(Date kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getKaishishijian() {
		return kaishishijian;
	}
	/**
	 * 设置：结束时间
	 */
	public void setJieshushijian(Date jieshushijian) {
		this.jieshushijian = jieshushijian;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getJieshushijian() {
		return jieshushijian;
	}
	/**
	 * 设置：活动详情
	 */
	public void setHuodongxiangqing(String huodongxiangqing) {
		this.huodongxiangqing = huodongxiangqing;
	}
	/**
	 * 获取：活动详情
	 */
	public String getHuodongxiangqing() {
		return huodongxiangqing;
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
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}

}
