package com.mzl.integralcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.sql.Timestamp;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="Activity对象", description="")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "活动自增id")
        @TableId(value = "activity_id", type = IdType.AUTO)
      private Integer activityId;

      @ApiModelProperty(value = "活动名称")
      private String activityName;

      @ApiModelProperty(value = "活动开始时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private Timestamp startTime;

      @ApiModelProperty(value = "活动结束时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private Timestamp endTime;

      @ApiModelProperty(value = "活动备注")
      private String note;


}
