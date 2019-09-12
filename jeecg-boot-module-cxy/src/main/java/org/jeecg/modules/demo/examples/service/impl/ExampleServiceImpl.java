package org.jeecg.modules.demo.examples.service.impl;

import org.jeecg.modules.demo.examples.entity.Example;
import org.jeecg.modules.demo.examples.mapper.ExampleMapper;
import org.jeecg.modules.demo.examples.service.IExampleService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 例子
 * @Author: jeecg-boot
 * @Date:   2019-09-07
 * @Version: V1.0
 */
@Service
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, Example> implements IExampleService {

}
