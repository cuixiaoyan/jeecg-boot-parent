package org.jeecg.modules.demo.participate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.participate.entity.Personnel;
import org.jeecg.modules.demo.participate.entity.Region;

import java.util.List;
import java.util.Map;

/**
 * @Description: 地区表
 * @Author: jeecg-boot
 * @Date:   2019-09-14
 * @Version: V1.0
 */
public interface RegionService extends IService<Region> {

    public List<Map<String,Object>> getRegion();

}
