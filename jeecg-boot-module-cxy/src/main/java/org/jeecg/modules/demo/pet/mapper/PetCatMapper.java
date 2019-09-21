package org.jeecg.modules.demo.pet.mapper;

import java.util.List;
import org.jeecg.modules.demo.pet.entity.PetCat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 宠物猫
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
public interface PetCatMapper extends BaseMapper<PetCat> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<PetCat> selectByMainId(@Param("mainId") String mainId);
}
