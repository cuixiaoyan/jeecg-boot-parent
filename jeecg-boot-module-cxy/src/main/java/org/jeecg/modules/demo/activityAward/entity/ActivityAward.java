package org.jeecg.modules.demo.activityAward.entity;

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
 * @Description: 活动奖励
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Data
@TableName("activityAward")
public class ActivityAward implements Serializable {
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

	/**第一名人数*/
	@Excel(name = "第一名人数", width = 15)
	private Integer diyirenshu;
	/**第一名奖品*/
	@Excel(name = "第一名奖品", width = 15)
	private String diyijiangpin;

	/**第二名人数*/
	@Excel(name = "第二名人数", width = 15)
	private Integer dierrenshu;
	/**第二名奖品*/
	@Excel(name = "第二名奖品", width = 15)
	private String direjiangpin;

	/**第三名人数*/
	@Excel(name = "第三名人数", width = 15)
	private Integer disanrenshu;
	/**第三名奖品*/
	@Excel(name = "第三名奖品", width = 15)
	private String disanjiangpin;
	/**参与人数*/
	@Excel(name = "参与人数", width = 15)
	private Integer canyurenshu;
	/**参与奖品*/
	@Excel(name = "参与奖品", width = 15)
	private String canyujiangpin;
	/**哪次活动*/
	@Excel(name = "哪次活动", width = 15, dictTable="publishingActivities",dicCode="id",dicText="activities")
	private String huodong;
	/**是否结束*/
	@Excel(name = "是否结束", width = 15 ,dicCode="jieshu")
	private String zhuangtai;
	/**结束时间*/
	@Excel(name = "结束时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date jieshushijian;
}
