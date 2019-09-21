package org.jeecg.modules.demo.pet.service.impl;

import org.jeecg.modules.demo.pet.entity.PetCat;
import org.jeecg.modules.demo.pet.mapper.PetCatMapper;
import org.jeecg.modules.demo.pet.service.IPetCatService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 宠物猫
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
@Service
public class PetCatServiceImpl extends ServiceImpl<PetCatMapper, PetCat> implements IPetCatService {
	
	@Autowired
	private PetCatMapper petCatMapper;
	
	@Override
	public List<PetCat> selectByMainId(String mainId) {
		return petCatMapper.selectByMainId(mainId);
	}
}
