package org.jeecg.modules.demo.participate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.participate.entity.Personnel;
import org.jeecg.modules.demo.participate.entity.Region;
import org.jeecg.modules.demo.participate.mapper.PersonnelMapper;
import org.jeecg.modules.demo.participate.mapper.RegionMapper;
import org.jeecg.modules.demo.participate.service.IPersonnelService;
import org.jeecg.modules.demo.participate.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityWriter;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.beans.Expression;
import java.util.List;
import java.util.Map;

/**
 * @Description: 地区表
 * @Author: jeecg-boot
 * @Date:   2019-09-14
 * @Version: V1.0
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Autowired
    private RegionMapper regionMapper;


    @Override
    public List<Map<String,Object>> getRegion() {
        List<Map<String, Object>> maps = regionMapper.selectMaps( null);
        return maps;
    }






}
