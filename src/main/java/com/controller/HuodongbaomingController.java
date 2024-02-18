package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuodongbaomingEntity;
import com.entity.ZhiyuanhuodongEntity;
import com.entity.view.HuodongbaomingView;
import com.service.HuodongbaomingService;
import com.service.ZhiyuanhuodongService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 活动报名
 * 后端接口
 * @author
 * @email
 * @date 2023-03-07 16:39:19
 */
@RestController
@RequestMapping("/huodongbaoming")
public class HuodongbaomingController {

    @Autowired
    private HuodongbaomingService huodongbaomingService;

    @Autowired
    private ZhiyuanhuodongService zhiyuanhuodongService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HuodongbaomingEntity huodongbaoming,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("zhiyuanzhe")) {
            huodongbaoming.setZhiyuanzhezhanghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<HuodongbaomingEntity> ew = new EntityWrapper<>();

        PageUtils page = huodongbaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongbaoming), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HuodongbaomingEntity huodongbaoming,
                  HttpServletRequest request) {
        EntityWrapper<HuodongbaomingEntity> ew = new EntityWrapper<HuodongbaomingEntity>();

        PageUtils page = huodongbaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongbaoming), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(HuodongbaomingEntity huodongbaoming) {
        EntityWrapper<HuodongbaomingEntity> ew = new EntityWrapper<HuodongbaomingEntity>();
        ew.allEq(MPUtil.allEQMapPre(huodongbaoming, "huodongbaoming"));
        return R.ok().put("data", huodongbaomingService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongbaomingEntity huodongbaoming) {
        EntityWrapper<HuodongbaomingEntity> ew = new EntityWrapper<HuodongbaomingEntity>();
        ew.allEq(MPUtil.allEQMapPre(huodongbaoming, "huodongbaoming"));
        HuodongbaomingView huodongbaomingView = huodongbaomingService.selectView(ew);
        return R.ok("查询活动报名成功").put("data", huodongbaomingView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        HuodongbaomingEntity huodongbaoming = huodongbaomingService.selectById(id);
        return R.ok().put("data", huodongbaoming);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        HuodongbaomingEntity huodongbaoming = huodongbaomingService.selectById(id);
        return R.ok().put("data", huodongbaoming);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @Transactional
    public R save(@RequestBody HuodongbaomingEntity huodongbaoming, HttpServletRequest request) {
        huodongbaoming.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(huodongbaoming);
        String huodongzhuti = huodongbaoming.getHuodongzhuti();
        String zhiyuanzhezhanghao = huodongbaoming.getZhiyuanzhezhanghao();
        int count = huodongbaomingService.selectCount(new EntityWrapper<HuodongbaomingEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhezhanghao).eq("huodongzhuti", huodongzhuti));
        if (count > 0) {
            return R.error("已报名当前活动");
        }
        long renshu = huodongbaomingService.selectCount(new EntityWrapper<HuodongbaomingEntity>().eq("huodongzhuti", huodongbaoming.getHuodongzhuti()));
        ZhiyuanhuodongEntity zhiyuanhuodongEntity = zhiyuanhuodongService.selectOne(new EntityWrapper<ZhiyuanhuodongEntity>().eq("huodongzhuti", huodongbaoming.getHuodongzhuti()));
        if (zhiyuanhuodongEntity.getJieshushijian().before(new Date())){
            return R.error("活动已结束");
        }
        zhiyuanhuodongEntity.setRenshu(renshu);
        zhiyuanhuodongService.updateById(zhiyuanhuodongEntity);
        huodongbaomingService.insert(huodongbaoming);

        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    @Transactional
    public R add(@RequestBody HuodongbaomingEntity huodongbaoming, HttpServletRequest request) {
        huodongbaoming.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(huodongbaoming);
        String huodongzhuti = huodongbaoming.getHuodongzhuti();
        String zhiyuanzhezhanghao = huodongbaoming.getZhiyuanzhezhanghao();
        int count = huodongbaomingService.selectCount(new EntityWrapper<HuodongbaomingEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhezhanghao).eq("huodongzhuti", huodongzhuti));
        if (count > 0) {
            return R.error("已报名当前活动");
        }
        long renshu = huodongbaomingService.selectCount(new EntityWrapper<HuodongbaomingEntity>().eq("huodongzhuti", huodongbaoming.getHuodongzhuti()));
        ZhiyuanhuodongEntity zhiyuanhuodongEntity = zhiyuanhuodongService.selectOne(new EntityWrapper<ZhiyuanhuodongEntity>().eq("huodongzhuti", huodongbaoming.getHuodongzhuti()));
        if (zhiyuanhuodongEntity.getJieshushijian().before(new Date())){
            return R.error("活动已结束");
        }
        zhiyuanhuodongEntity.setRenshu(renshu);
        zhiyuanhuodongService.updateById(zhiyuanhuodongEntity);
        huodongbaomingService.insert(huodongbaoming);

        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongbaomingEntity huodongbaoming, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(huodongbaoming);
        huodongbaomingService.updateById(huodongbaoming);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        huodongbaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if (type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if (map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if (map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<HuodongbaomingEntity> wrapper = new EntityWrapper<HuodongbaomingEntity>();
        if (map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if (map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("zhiyuanzuzhi")) {
            wrapper.eq("zuzhibianhao", (String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("zhiyuanzhe")) {
            wrapper.eq("zhiyuanzhezhanghao", (String) request.getSession().getAttribute("username"));
        }

        int count = huodongbaomingService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}
