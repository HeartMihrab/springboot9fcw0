package com.entity.view;

import com.entity.ZuzhibaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 组织报名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@TableName("zuzhibaoming")
public class ZuzhibaomingView  extends ZuzhibaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuzhibaomingView(){
	}
 
 	public ZuzhibaomingView(ZuzhibaomingEntity zuzhibaomingEntity){
 	try {
			BeanUtils.copyProperties(this, zuzhibaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
