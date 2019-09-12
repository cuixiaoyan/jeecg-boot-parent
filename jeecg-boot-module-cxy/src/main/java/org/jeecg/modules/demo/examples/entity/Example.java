package org.jeecg.modules.demo.examples.entity;

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
 * @Description: 例子
 * @Author: jeecg-boot
 * @Date:   2019-09-07
 * @Version: V1.0
 */
@Data
@TableName("example")
public class Example implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
	private java.lang.String createBy;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
	private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
	private java.lang.String sysOrgCode;
	/**用户名*/
	@Excel(name = "用户名", width = 15)
	private java.lang.String name;
	/**性别*/
	@Excel(name = "性别", width = 15)
	private java.lang.String sex;
	/**年龄*/
	@Excel(name = "年龄", width = 15)
	private java.lang.Integer age;
	/**描述*/
	@Excel(name = "描述", width = 15)
	private java.lang.String descc;
	/**生日*/
	@Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthday;
	/**手机号*/
	@Excel(name = "手机号", width = 15)
	private java.lang.String userCode;
	/**头像*/
	@Excel(name = "头像", width = 15)
	private java.lang.String topPic;
	/**简历*/
	@Excel(name = "简历", width = 15)
	private java.lang.String fileKk;
	/**部门*/
	@Excel(name = "部门", width = 15)
	private java.lang.String bumen;
	/**领导*/
	@Excel(name = "领导", width = 15)
	private java.lang.String lingdao;
}
