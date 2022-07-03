package com.mzl.integralcommon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName :   PageVo
 * @Description: 分页DTO
 * @Author: mzl
 * @CreateDate: 2022/7/3 12:09
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String activityName;

    //年-月-日的格式
    private String dayTime;

    private Integer currentPage;

    private Integer pageSize;

}
