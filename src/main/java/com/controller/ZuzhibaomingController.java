package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuzhibaomingEntity;
import com.entity.view.ZuzhibaomingView;

import com.service.ZuzhibaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 组织报名
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-07 16:39:19
 */
@RestController
@RequestMapping("/zuzhibaoming")
public class ZuzhibaomingController {
    @Autowired
    private ZuzhibaomingService zuzhibaomingService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuzhibaomingEntity zuzhibaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzuzhi")) {
			zuzhibaoming.setZuzhibianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			zuzhibaoming.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuzhibaomingEntity> ew = new EntityWrapper<ZuzhibaomingEntity>();

		PageUtils page = zuzhibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuzhibaoming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuzhibaomingEntity zuzhibaoming, 
		HttpServletRequest request){
        EntityWrapper<ZuzhibaomingEntity> ew = new EntityWrapper<ZuzhibaomingEntity>();

		PageUtils page = zuzhibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuzhibaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuzhibaomingEntity zuzhibaoming){
       	EntityWrapper<ZuzhibaomingEntity> ew = new EntityWrapper<ZuzhibaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuzhibaoming, "zuzhibaoming")); 
        return R.ok().put("data", zuzhibaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuzhibaomingEntity zuzhibaoming){
        EntityWrapper< ZuzhibaomingEntity> ew = new EntityWrapper< ZuzhibaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuzhibaoming, "zuzhibaoming")); 
		ZuzhibaomingView zuzhibaomingView =  zuzhibaomingService.selectView(ew);
		return R.ok("查询组织报名成功").put("data", zuzhibaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuzhibaomingEntity zuzhibaoming = zuzhibaomingService.selectById(id);
        return R.ok().put("data", zuzhibaoming);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuzhibaomingEntity zuzhibaoming = zuzhibaomingService.selectById(id);
        return R.ok().put("data", zuzhibaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuzhibaomingEntity zuzhibaoming, HttpServletRequest request){
    	zuzhibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuzhibaoming);
        zuzhibaomingService.insert(zuzhibaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuzhibaomingEntity zuzhibaoming, HttpServletRequest request){
    	zuzhibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuzhibaoming);
        zuzhibaomingService.insert(zuzhibaoming);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuzhibaomingEntity zuzhibaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuzhibaoming);
        zuzhibaomingService.updateById(zuzhibaoming);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuzhibaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZuzhibaomingEntity> wrapper = new EntityWrapper<ZuzhibaomingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzuzhi")) {
			wrapper.eq("zuzhibianhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			wrapper.eq("zhiyuanzhezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zuzhibaomingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
