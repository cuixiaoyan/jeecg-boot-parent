package org.jeecg.modules.demo.pet.mapper;

import java.util.List;
import org.jeecg.modules.demo.pet.entity.PetDog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 宠物狗
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
public interface PetDogMapper extends BaseMapper<PetDog> {

	public boolean deleteByMainId(@Param("mainId") String mainId);
    
	public List<PetDog> selectByMainId(@Param("mainId") String mainId);
}
