package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.HuodongbaomingEntity;
import com.entity.ZhiyuanhuodongEntity;
import com.entity.ZhiyuanzheEntity;
import com.entity.view.ZhiyuanhuodongView;
import com.service.HuodongbaomingService;
import com.service.ZhiyuanhuodongService;
import com.service.ZhiyuanzheService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 志愿活动
 * 后端接口
 * @author
 * @email
 * @date 2023-03-07 16:39:19
 */
@RestController
@RequestMapping("/zhiyuanhuodong")
public class ZhiyuanhuodongController {
    @Autowired
    private ZhiyuanhuodongService zhiyuanhuodongService;


    @Autowired
    private HuodongbaomingService huodongbaomingService;

    @Autowired
    private ZhiyuanzheService zhiyuanzheService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhiyuanhuodongEntity zhiyuanhuodong,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<>();

        PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ZhiyuanhuodongEntity zhiyuanhuodong,
                  HttpServletRequest request) {
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<>();

        PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ZhiyuanhuodongEntity zhiyuanhuodong) {
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
        ew.allEq(MPUtil.allEQMapPre(zhiyuanhuodong, "zhiyuanhuodong"));
        return R.ok().put("data", zhiyuanhuodongService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanhuodongEntity zhiyuanhuodong) {
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(zhiyuanhuodong, "zhiyuanhuodong"));
        ZhiyuanhuodongView zhiyuanhuodongView = zhiyuanhuodongService.selectView(ew);
        return R.ok("查询志愿活动成功").put("data", zhiyuanhuodongView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
        return R.ok().put("data", zhiyuanhuodong);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
        return R.ok().put("data", zhiyuanhuodong);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request) {
        zhiyuanhuodong.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        String filename = zhiyuanhuodong.getId() + ".txt";
        String directory = "D:/download/";
        String filepath = directory + filename;
        try {
            File file = new File(filepath);
            if (!file.exists()) file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("活动ID: " + zhiyuanhuodong.getId());
            bw.newLine();
            bw.write("活动主题: " + zhiyuanhuodong.getHuodongzhuti());
            bw.newLine();
            bw.write("活动类型: " + zhiyuanhuodong.getHuodongleixing());
            bw.newLine();
            bw.write("活动地点: " + zhiyuanhuodong.getHuodongdidian());
            bw.newLine();
            bw.write("活动积分: " + zhiyuanhuodong.getJifen());
            bw.newLine();
            bw.write("开始时间: " + zhiyuanhuodong.getKaishishijian());
            bw.newLine();
            bw.write("结束时间: " + zhiyuanhuodong.getJieshushijian());
            bw.newLine();
            bw.write("活动详情: " + zhiyuanhuodong.getHuodongxiangqing());
            bw.close();
        } catch (Exception e) {
            return R.error("文件上传失败");
        }
        zhiyuanhuodong.setRenshu(0L);
        if (zhiyuanhuodong.getJifen() == null) {
            zhiyuanhuodong.setJifen(0);
        }
        if (zhiyuanhuodongService.selectOne(new EntityWrapper<ZhiyuanhuodongEntity>().eq("huodongzhuti", zhiyuanhuodong.getHuodongzhuti())) != null) {
            return R.error("该活动主题已存在");
        }
        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok();

    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    @Transactional
    public R add(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request) {
        zhiyuanhuodong.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        String filename = zhiyuanhuodong.getId() + "";
        String directory = "D:/download/";
        String filepath = directory + filename;
        try {
            File file = File.createTempFile(filepath, ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("活动ID: " + zhiyuanhuodong.getId());
            bw.newLine();
            bw.write("活动主题: " + zhiyuanhuodong.getHuodongzhuti());
            bw.newLine();
            bw.write("活动类型: " + zhiyuanhuodong.getHuodongleixing());
            bw.newLine();
            bw.write("活动地点: " + zhiyuanhuodong.getHuodongdidian());
            bw.newLine();
            bw.write("活动积分: " + zhiyuanhuodong.getJifen());
            bw.newLine();
            bw.write("开始时间: " + zhiyuanhuodong.getKaishishijian());
            bw.newLine();
            bw.write("结束时间: " + zhiyuanhuodong.getJieshushijian());
            bw.newLine();
            bw.write("活动详情: " + zhiyuanhuodong.getHuodongxiangqing());
            bw.close();
            zhiyuanhuodong.setRenshu(0L);
            if (zhiyuanhuodong.getJifen() == null) {
                zhiyuanhuodong.setJifen(0);
            }
            zhiyuanhuodongService.insert(zhiyuanhuodong);
            return R.ok();
        } catch (Exception e) {
            return R.error("文件上传失败");
        }
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        String filename = zhiyuanhuodong.getId() + ".txt";
        String directory = "D:/download/";
        String filepath = directory + filename;
        try {
            File file = new File(filepath);
            if (!file.exists()) file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("活动ID: " + zhiyuanhuodong.getId());
            bw.newLine();
            bw.write("活动主题: " + zhiyuanhuodong.getHuodongzhuti());
            bw.newLine();
            bw.write("活动类型: " + zhiyuanhuodong.getHuodongleixing());
            bw.newLine();
            bw.write("活动地点: " + zhiyuanhuodong.getHuodongdidian());
            bw.newLine();
            bw.write("活动积分: " + zhiyuanhuodong.getJifen());
            bw.newLine();
            bw.write("开始时间: " + zhiyuanhuodong.getKaishishijian());
            bw.newLine();
            bw.write("结束时间: " + zhiyuanhuodong.getJieshushijian());
            bw.newLine();
            bw.write("活动详情: " + zhiyuanhuodong.getHuodongxiangqing());
            bw.close();
        } catch (Exception e) {
            return R.error("文件上传失败");
        }
        zhiyuanhuodongService.updateById(zhiyuanhuodong);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Transactional
    public R delete(@RequestBody Long[] ids) {
        List<ZhiyuanhuodongEntity> zhiyuanhuodongList = zhiyuanhuodongService.selectList(new EntityWrapper<ZhiyuanhuodongEntity>().in("id", Arrays.asList(ids)));
        List<String> huodongzhuti = new ArrayList<>();
        for (ZhiyuanhuodongEntity t : zhiyuanhuodongList) {
            huodongzhuti.add(t.getHuodongzhuti());
        }
        List<HuodongbaomingEntity> huodongbaomingList = huodongbaomingService.selectList(new EntityWrapper<HuodongbaomingEntity>().in("huodongzhuti", huodongzhuti));
        for (HuodongbaomingEntity t : huodongbaomingList) {
            Integer jifen = zhiyuanhuodongService.selectOne(new EntityWrapper<ZhiyuanhuodongEntity>().eq("huodongzhuti", t.getHuodongzhuti())).getJifen();
            String zhiyuanzhezhanghao = t.getZhiyuanzhezhanghao();
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhezhanghao));
            zhiyuanzhe.setJifen(zhiyuanzhe.getJifen() + jifen);
            zhiyuanzheService.updateById(zhiyuanzhe);
        }
        for (ZhiyuanhuodongEntity t : zhiyuanhuodongList) {
            huodongbaomingService.delete(new EntityWrapper<HuodongbaomingEntity>().eq("huodongzhuti", t.getHuodongzhuti()));
        }
        zhiyuanhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 下载接口
     */
    @RequestMapping("/download")
    @Transactional
    public R download(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:/download/" + zhiyuanhuodong.getId() + ".txt"));
            String fileContent = br.lines().collect(Collectors.joining("\n"));
            return R.ok().put("data", fileContent);
        } catch (Exception e) {
            return R.error("文件下载失败");
        }
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

        Wrapper<ZhiyuanhuodongEntity> wrapper = new EntityWrapper<ZhiyuanhuodongEntity>();
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

        int count = zhiyuanhuodongService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}
