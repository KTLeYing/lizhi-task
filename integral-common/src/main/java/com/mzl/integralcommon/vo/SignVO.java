package com.mzl.integralcommon.vo;

import com.mzl.integralcommon.entity.Sign;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName :   SignVO
 * @Description: 签到表实体类VO
 * @Author: mzl
 * @CreateDate: 2022/7/3 11:43
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignVO extends Sign implements Serializable {

    private static final long serialVersionUID = 1L;

    private String activityName;

}
