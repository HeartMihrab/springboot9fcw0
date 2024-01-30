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


import com.dao.ZuzhifengcaiDao;
import com.entity.ZuzhifengcaiEntity;
import com.service.ZuzhifengcaiService;
import com.entity.vo.ZuzhifengcaiVO;
import com.entity.view.ZuzhifengcaiView;

@Service("zuzhifengcaiService")
public class ZuzhifengcaiServiceImpl extends ServiceImpl<ZuzhifengcaiDao, ZuzhifengcaiEntity> implements ZuzhifengcaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhifengcaiEntity> page = this.selectPage(
                new Query<ZuzhifengcaiEntity>(params).getPage(),
                new EntityWrapper<ZuzhifengcaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhifengcaiEntity> wrapper) {
		  Page<ZuzhifengcaiView> page =new Query<ZuzhifengcaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhifengcaiVO> selectListVO(Wrapper<ZuzhifengcaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhifengcaiVO selectVO(Wrapper<ZuzhifengcaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhifengcaiView> selectListView(Wrapper<ZuzhifengcaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhifengcaiView selectView(Wrapper<ZuzhifengcaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
