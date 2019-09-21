package org.jeecg.modules.demo.pet.service.impl;

import org.jeecg.modules.demo.pet.entity.PetDog;
import org.jeecg.modules.demo.pet.mapper.PetDogMapper;
import org.jeecg.modules.demo.pet.service.IPetDogService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 宠物狗
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
@Service
public class PetDogServiceImpl extends ServiceImpl<PetDogMapper, PetDog> implements IPetDogService {
	
	@Autowired
	private PetDogMapper petDogMapper;
	
	@Override
	public List<PetDog> selectByMainId(String mainId) {
		return petDogMapper.selectByMainId(mainId);
	}
}
