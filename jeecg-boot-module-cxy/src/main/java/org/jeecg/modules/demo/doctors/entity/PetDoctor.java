package org.jeecg.modules.demo.doctors.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: 宠物医生
 * @Author: jeecg-boot
 * @Date:   2019-09-29
 * @Version: V1.0
 */
@Data
@TableName("petDoctor")
public class PetDoctor implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.UUID)
	private String id;
	/**创建人*/
	//@Excel(name = "创建人", width = 15)
	private String createBy;
	/**创建日期*/
	//@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新人*/
	//@Excel(name = "更新人", width = 15)
	private String updateBy;
	/**更新日期*/
	//@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**所属部门*/
	//@Excel(name = "所属部门", width = 15)
	private String sysOrgCode;
	/**名字*/
	@Excel(name = "名字", width = 15)
	private String name;
	/**工作年限*/
	@Excel(name = "工作年限", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date workinglife;
	/**手机号*/
	@Excel(name = "手机号", width = 15)
	private String iphone;
	/**级别*/
	@Dict(dicCode = "level")
	@Excel(name = "级别", width = 15,dicCode = "level")
	private String level;
	/**照片*/
	//@Excel(name = "照片", width = 15)
	private String photo;
	/**资格证*/
	//@Excel(name = "资格证", width = 15)
	private String qualificationsphoto;
	/**简介*/
	//@Excel(name = "简介", width = 15)
	private String resume;
}
