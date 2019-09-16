package org.jeecg.modules.demo.participate.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
 * @Description: 参加活动人员表
 * @Author: jeecg-boot
 * @Date:   2019-09-14
 * @Version: V1.0
 */
@Data
@TableName("personnel")
public class Personnel implements Serializable {
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
	/**参与者名字*/
	@Excel(name = "用户名称", width = 15)
	private String name;
	/**手机号*/
	@Excel(name = "手机号", width = 15)
	private String phone;
	/**会员(0不是会员1是会员2是超级会员)*/
	@Excel(name = "等级", width = 15)
	@Dict(dicCode = "member")
	private String member;
	/**参与的人数*/
	@Excel(name = "人数", width = 15)
	private Integer number;
	/**哪次活动*/
	@Dict(dicCode = "id",dictTable="publishingActivities",dicText="activities")
	@Excel(name="活动",dictTable="publishingActivities",dicCode="id",dicText="activities")
	private String activity;
	/**活动地区*/
	@Excel(name = "地区", width = 15)
	private String region;
	/**提醒时间*/
	@Excel(name = "提醒时间", width = 15, format = "yyyy-MM-dd HH:mm")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date remindertime;
	/**参与的部门*/
	@Excel(name="参与的部门",dictTable="sys_depart",dicCode="id",dicText="depart_name")
	private String department;
}
