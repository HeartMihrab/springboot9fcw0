package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuzhifengcaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuzhifengcaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuzhifengcaiView;


/**
 * 组织风采
 *
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
public interface ZuzhifengcaiService extends IService<ZuzhifengcaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhifengcaiVO> selectListVO(Wrapper<ZuzhifengcaiEntity> wrapper);
   	
   	ZuzhifengcaiVO selectVO(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
   	
   	List<ZuzhifengcaiView> selectListView(Wrapper<ZuzhifengcaiEntity> wrapper);
   	
   	ZuzhifengcaiView selectView(@Param("ew") Wrapper<ZuzhifengcaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhifengcaiEntity> wrapper);
   	

}

