package com.entity.vo;

import com.entity.ZuzhifengcaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 组织风采
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
public class ZuzhifengcaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 组织名称
	 */
	
	private String zuzhimingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 视频
	 */
	
	private String shipin;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
				
	
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
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：视频
	 */
	 
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
			
}
