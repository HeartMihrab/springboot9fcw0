package com.entity.view;

import com.entity.ZuzhifengcaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 组织风采
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@TableName("zuzhifengcai")
public class ZuzhifengcaiView  extends ZuzhifengcaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuzhifengcaiView(){
	}
 
 	public ZuzhifengcaiView(ZuzhifengcaiEntity zuzhifengcaiEntity){
 	try {
			BeanUtils.copyProperties(this, zuzhifengcaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
