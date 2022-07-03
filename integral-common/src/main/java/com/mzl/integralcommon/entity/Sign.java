package com.mzl.integralcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.sql.Timestamp;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author mzl
 * @since 2022-07-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="Sign对象", description="")
public class Sign implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "签到表自增id")
        @TableId(value = "sign_id", type = IdType.AUTO)
      private Integer signId;

      @ApiModelProperty(value = "用户id")
      private Integer userId;

      @ApiModelProperty(value = "活动id")
      private Integer activityId;

      @ApiModelProperty(value = "签到时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private Timestamp signTime;

      @ApiModelProperty(value = "签到备注")
      private String note;


}
