package org.jeecg.modules.demo.doctors.service.impl;

import org.jeecg.modules.demo.doctors.entity.PetDoctor;
import org.jeecg.modules.demo.doctors.mapper.PetDoctorMapper;
import org.jeecg.modules.demo.doctors.service.IPetDoctorService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 宠物医生
 * @Author: jeecg-boot
 * @Date:   2019-09-29
 * @Version: V1.0
 */
@Service
public class PetDoctorServiceImpl extends ServiceImpl<PetDoctorMapper, PetDoctor> implements IPetDoctorService {

}
