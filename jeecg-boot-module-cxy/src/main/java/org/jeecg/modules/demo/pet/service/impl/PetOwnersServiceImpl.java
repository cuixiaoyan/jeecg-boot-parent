package org.jeecg.modules.demo.pet.service.impl;

import org.jeecg.modules.demo.pet.entity.PetOwners;
import org.jeecg.modules.demo.pet.entity.PetDog;
import org.jeecg.modules.demo.pet.entity.PetCat;
import org.jeecg.modules.demo.pet.mapper.PetDogMapper;
import org.jeecg.modules.demo.pet.mapper.PetCatMapper;
import org.jeecg.modules.demo.pet.mapper.PetOwnersMapper;
import org.jeecg.modules.demo.pet.service.IPetOwnersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 宠物主人
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
@Service
public class PetOwnersServiceImpl extends ServiceImpl<PetOwnersMapper, PetOwners> implements IPetOwnersService {

	@Autowired
	private PetOwnersMapper petOwnersMapper;
	@Autowired
	private PetDogMapper petDogMapper;
	@Autowired
	private PetCatMapper petCatMapper;
	
	@Override
	@Transactional
	public void saveMain(PetOwners petOwners, List<PetDog> petDogList,List<PetCat> petCatList) {
		petOwnersMapper.insert(petOwners);
		if(petDogList!=null && petDogList.size()>0) {
			for(PetDog entity:petDogList) {
				//外键设置
				entity.setPetownersid(petOwners.getId());
				petDogMapper.insert(entity);
			}
		}
		if(petCatList!=null && petCatList.size()>0) {
			for(PetCat entity:petCatList) {
				//外键设置
				entity.setPetownersid(petOwners.getId());
				petCatMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional
	public void updateMain(PetOwners petOwners,List<PetDog> petDogList,List<PetCat> petCatList) {
		petOwnersMapper.updateById(petOwners);
		
		//1.先删除子表数据
		petDogMapper.deleteByMainId(petOwners.getId());
		petCatMapper.deleteByMainId(petOwners.getId());
		
		//2.子表数据重新插入
		if(petDogList!=null && petDogList.size()>0) {
			for(PetDog entity:petDogList) {
				//外键设置
				entity.setPetownersid(petOwners.getId());
				petDogMapper.insert(entity);
			}
		}
		if(petCatList!=null && petCatList.size()>0) {
			for(PetCat entity:petCatList) {
				//外键设置
				entity.setPetownersid(petOwners.getId());
				petCatMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional
	public void delMain(String id) {
		petDogMapper.deleteByMainId(id);
		petCatMapper.deleteByMainId(id);
		petOwnersMapper.deleteById(id);
	}

	@Override
	@Transactional
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			petDogMapper.deleteByMainId(id.toString());
			petCatMapper.deleteByMainId(id.toString());
			petOwnersMapper.deleteById(id);
		}
	}
	
}
