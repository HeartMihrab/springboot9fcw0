package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuzhibaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuzhibaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuzhibaomingView;


/**
 * 组织报名
 *
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
public interface ZuzhibaomingService extends IService<ZuzhibaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhibaomingVO> selectListVO(Wrapper<ZuzhibaomingEntity> wrapper);
   	
   	ZuzhibaomingVO selectVO(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
   	
   	List<ZuzhibaomingView> selectListView(Wrapper<ZuzhibaomingEntity> wrapper);
   	
   	ZuzhibaomingView selectView(@Param("ew") Wrapper<ZuzhibaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhibaomingEntity> wrapper);
   	

}

