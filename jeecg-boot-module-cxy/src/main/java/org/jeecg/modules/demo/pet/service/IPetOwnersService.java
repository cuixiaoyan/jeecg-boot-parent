package org.jeecg.modules.demo.pet.service;

import org.jeecg.modules.demo.pet.entity.PetDog;
import org.jeecg.modules.demo.pet.entity.PetCat;
import org.jeecg.modules.demo.pet.entity.PetOwners;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 宠物主人
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
public interface IPetOwnersService extends IService<PetOwners> {

	/**
	 * 添加一对多
	 * 
	 */
	public void saveMain(PetOwners petOwners, List<PetDog> petDogList, List<PetCat> petCatList) ;
	
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(PetOwners petOwners, List<PetDog> petDogList, List<PetCat> petCatList);
	
	/**
	 * 删除一对多
	 */
	public void delMain(String id);
	
	/**
	 * 批量删除一对多
	 */
	public void delBatchMain(Collection<? extends Serializable> idList);
	
}
