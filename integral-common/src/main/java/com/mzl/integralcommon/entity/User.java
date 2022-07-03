package com.mzl.integralcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "用户主键自增id")
        @TableId(value = "user_id", type = IdType.AUTO)
      private Integer userId;

      @ApiModelProperty(value = "用户名")
      private String username;

      @ApiModelProperty(value = "密码")
      private String password;

      @ApiModelProperty(value = "性别，0：男生  1：女生")
      private Integer sex;

      @ApiModelProperty(value = "年龄")
      private Integer age;

      @ApiModelProperty(value = "积分")
      private Integer integralNum;

}
