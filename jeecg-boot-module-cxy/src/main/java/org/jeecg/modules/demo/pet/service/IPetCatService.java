package org.jeecg.modules.demo.pet.service;

import org.jeecg.modules.demo.pet.entity.PetCat;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 宠物猫
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
public interface IPetCatService extends IService<PetCat> {

	public List<PetCat> selectByMainId(String mainId);
}
