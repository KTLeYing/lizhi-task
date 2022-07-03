package com.mzl.integralcommon.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName :   ActivityDTO
 * @Description: 活动实体类DTO
 * @Author: mzl
 * @CreateDate: 2022/7/3 16:24
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动自增id")
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "活动开始时间")
    private String startTime;

    @ApiModelProperty(value = "活动结束时间")
    private String endTime;

    @ApiModelProperty(value = "活动备注")
    private String note;

}
