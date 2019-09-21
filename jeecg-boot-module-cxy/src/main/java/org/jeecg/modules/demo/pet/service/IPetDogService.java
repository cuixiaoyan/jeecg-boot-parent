package org.jeecg.modules.demo.pet.service;

import org.jeecg.modules.demo.pet.entity.PetDog;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 宠物狗
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
public interface IPetDogService extends IService<PetDog> {

	public List<PetDog> selectByMainId(String mainId);
}
