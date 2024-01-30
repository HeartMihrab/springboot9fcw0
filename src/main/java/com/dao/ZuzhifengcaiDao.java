package com.dao;

import com.entity.ZuzhifengcaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuzhifengcaiVO;
import com.entity.view.ZuzhifengcaiView;


/**
 * 组织风采
 * 
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
public interface ZuzhifengcaiDao extends BaseMapper<ZuzhifengcaiEntity> {
	
	List<ZuzhifengcaiVO> selectListVO(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
	
	ZuzhifengcaiVO selectVO(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
	
	List<ZuzhifengcaiView> selectListView(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);

	List<ZuzhifengcaiView> selectListView(Pagination page,@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
	
	ZuzhifengcaiView selectView(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
	

}
