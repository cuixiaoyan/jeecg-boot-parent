package org.jeecg.modules.demo.activities.entity;

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
 * @Description: 发布活动
 * @Author: jeecg-boot
 * @Date:   2019-09-01
 * @Version: V1.0
 */
@Data
@TableName("publishingActivities")
public class PublishingActivities implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.UUID)
	private String id;
	/**创建人*/
	//@Excel(name = "创建人", width = 15)
	private String createBy;
	/**创建日期*/
//	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新人*/
	//@Excel(name = "更新人", width = 15)
	private String updateBy;
	/**更新日期*/
//	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**所属部门*/
	//@Excel(name = "所属部门", width = 15)
	private String sysOrgCode;
	/**活动名称*/
	@Excel(name = "活动名称", width = 15)
	private String activities;
	/**开始时间*/
	@Excel(name = "开始时间", width = 15, format = "yyyy-MM-dd HH:mm")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date starttime;
	/**结束时间*/
	@Excel(name = "结束时间", width = 15, format = "yyyy-MM-dd HH:mm")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date endtime;
	/**责任人*/
	//数据字典数据库转换
	@Dict(dicCode = "id",dictTable="sys_user",dicText="realname")
	@Excel(name = "责任人", width = 15 ,dictTable="sys_user",dicCode="id",dicText="realname")
	private String personliable;
	/**活动类型 自动转换*/
	//单纯数据字典转换
	@Dict(dicCode = "acttype")
	@Excel(name = "活动类型", width = 15 ,dicCode="acttype")
	private String acttype;

	/**参与人数*/
	@Excel(name = "参与人数", width = 15)
	private Integer number;
	/**电话号码*/
	@Excel(name = "电话号码", width = 15)
	private String telephone;

    /**
     * 活动图片
     */
    //@Excel(name = "活动图片", width = 15)
    private String avatar;

}
