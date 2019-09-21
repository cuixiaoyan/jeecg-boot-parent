package org.jeecg.modules.demo.pet.vo;

import java.util.List;
import org.jeecg.modules.demo.pet.entity.PetOwners;
import org.jeecg.modules.demo.pet.entity.PetDog;
import org.jeecg.modules.demo.pet.entity.PetCat;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Description: 宠物主人
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
@Data
public class PetOwnersPage {
	
	/**主键*/
	private String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
	private String createBy;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
	private String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
	private String sysOrgCode;
	/**主人名字*/
	@Excel(name = "主人名字", width = 15)
	private String zhurenmingzi;
	/**年龄*/
	@Excel(name = "年龄", width = 15)
	private Integer age;
	/**性别*/
	@Excel(name = "性别", width = 15)
	private String sex;
	/**电话*/
	@Excel(name = "电话", width = 15)
	private String iphone;
	/**等级*/
	@Excel(name = "等级", width = 15)
	private String huiyuan;
	/**种类*/
	@Excel(name = "种类", width = 15)
	private String weiyangzhonglei;
	
	@ExcelCollection(name="宠物狗")
	private List<PetDog> petDogList;	
	@ExcelCollection(name="宠物猫")
	private List<PetCat> petCatList;	
	
}
