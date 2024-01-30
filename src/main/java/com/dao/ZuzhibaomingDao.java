package com.dao;

import com.entity.ZuzhibaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuzhibaomingVO;
import com.entity.view.ZuzhibaomingView;


/**
 * 组织报名
 * 
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
public interface ZuzhibaomingDao extends BaseMapper<ZuzhibaomingEntity> {
	
	List<ZuzhibaomingVO> selectListVO(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
	
	ZuzhibaomingVO selectVO(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
	
	List<ZuzhibaomingView> selectListView(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);

	List<ZuzhibaomingView> selectListView(Pagination page,@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
	
	ZuzhibaomingView selectView(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
	

}
