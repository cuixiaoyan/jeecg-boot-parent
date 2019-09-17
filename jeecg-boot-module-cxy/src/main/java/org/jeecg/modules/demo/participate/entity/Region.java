package org.jeecg.modules.demo.participate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 地区表
 * @Author: jeecg-boot
 * @Date:   2019-09-14
 * @Version: V1.0
 */
@Data
@TableName("t_s_region")
public class Region implements Serializable {

    private String id;

    private String name;

    private String pid;

    private String name_en;
    

}
