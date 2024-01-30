package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuzhibaomingDao;
import com.entity.ZuzhibaomingEntity;
import com.service.ZuzhibaomingService;
import com.entity.vo.ZuzhibaomingVO;
import com.entity.view.ZuzhibaomingView;

@Service("zuzhibaomingService")
public class ZuzhibaomingServiceImpl extends ServiceImpl<ZuzhibaomingDao, ZuzhibaomingEntity> implements ZuzhibaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhibaomingEntity> page = this.selectPage(
                new Query<ZuzhibaomingEntity>(params).getPage(),
                new EntityWrapper<ZuzhibaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhibaomingEntity> wrapper) {
		  Page<ZuzhibaomingView> page =new Query<ZuzhibaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhibaomingVO> selectListVO(Wrapper<ZuzhibaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhibaomingVO selectVO(Wrapper<ZuzhibaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhibaomingView> selectListView(Wrapper<ZuzhibaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhibaomingView selectView(Wrapper<ZuzhibaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
