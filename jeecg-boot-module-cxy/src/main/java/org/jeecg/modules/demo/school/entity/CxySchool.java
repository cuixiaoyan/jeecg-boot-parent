package org.jeecg.modules.demo.school.entity;

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
 * @Description: 学校表
 * @Author: jeecg-boot
 * @Date:   2019-11-18
 * @Version: V1.0
 */
@Data
@TableName("cxy_school")
public class CxySchool implements Serializable {
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
	/**学校名称*/
	@Excel(name = "学校名称", width = 15)
	private String name;
	/**最低年级*/
	@Excel(name = "最低年级", width = 15)
	private Integer startGrade;
	/**最高年级*/
	@Excel(name = "最高年级", width = 15)
	private Integer endGrade;
	/**地区*/
	@Excel(name = "地区", width = 15)
	private String regionId;
	/**官网*/
	@Excel(name = "官网", width = 15)
	private String website;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
	private String phone;
	/**联系人*/
	@Dict(dicCode = "id",dictTable="sys_user",dicText="realname")
	@Excel(name = "联系人", width = 15 ,dictTable="sys_user",dicCode="id",dicText="realname")
	private String contacts;
	/**地址*/
	@Excel(name = "地址", width = 15)
	private String address;
	/**邮政编码*/
	@Excel(name = "邮政编码", width = 15)
	private String postCode;
	/**图片*/
	@Excel(name = "图片", width = 15)
	private String pic;
	/**简介*/
	@Excel(name = "简介", width = 15)
	private String introduce;
	/**备注*/
	//@Excel(name = "备注", width = 15)
	private String remarks;
	/**文件存储名字*/
	@Excel(name = "文件存储名字", width = 15)
	private String bucket;
	/**类别*/
	@Dict(dicCode = "schoolType")
	@Excel(name = "类别", width = 15 ,dicCode="schoolType")
	private String schoolType;
	/**唯一标示*/
	//@Excel(name = "唯一标示", width = 15)
	private String schoolSign;
	/**学校状态*/
	//@Excel(name = "学校状态", width = 15)
	private String status;
}
