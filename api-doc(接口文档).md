
**Swagger接口文档**


**简介**：<p>Swagger测试</p>


**HOST**:localhost:8880


**联系人**: mzl


**Version**:2.0

**接口路径**：/v2/api-docs


# 用户积分模块接口
## 用户活动签到


**接口描述**:


**接口地址**:`/userIntegral/activitySign`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|activityId| activityId  | query | false |integer  |    |
|userId| userId  | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据用户id查询用户总积分【通过数据库查询，性能低，不推荐】


**接口描述**:


**接口地址**:`/userIntegral/selectIntegralById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userId| userId  | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据用户id查询用户总积分【通过Redis查询，性能高】


**接口描述**:


**接口地址**:`/userIntegral/selectIntegralById1`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userId| userId  | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页模糊查询用户的签到历史表


**接口描述**:


**接口地址**:`/userIntegral/selectSignByPage`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|activityName|   | query | false |string  |    |
|currentPage|   | query | false |integer  |    |
|dayTime|   | query | false |string  |    |
|pageSize|   | query | false |integer  |    |
|userId|   | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id查询用户


**接口描述**:


**接口地址**:`/userIntegral/selectUserById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userId| userId  | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 积分排行模块接口
    

## 用户积分排行榜


**接口描述**:


**接口地址**:`/integralRank/rankByIntegral`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 添加用户积分(只用于个人测试)


**接口描述**:


**接口地址**:`/integralRank/zSetAdd`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userId| userId  | query | false |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 积分活动模块接口

## 配置/添加活动(管理员)


**接口描述**:


**接口地址**:`/integralActivity/addActivity`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"activityId": 0,
	"activityName": "",
	"endTime": {
		"date": 0,
		"day": 0,
		"hours": 0,
		"minutes": 0,
		"month": 0,
		"nanos": 0,
		"seconds": 0,
		"time": 0,
		"timezoneOffset": 0,
		"year": 0
	},
	"note": "",
	"startTime": {
		"date": 0,
		"day": 0,
		"hours": 0,
		"minutes": 0,
		"month": 0,
		"nanos": 0,
		"seconds": 0,
		"time": 0,
		"timezoneOffset": 0,
		"year": 0
	}
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|activity| activity  | body | true |Activity对象  | Activity对象   |

**schema属性说明**



**Activity对象**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|activityId| 活动自增id  | body | false |integer(int32)  |    |
|activityName| 活动名称  | body | false |string  |    |
|endTime| 活动结束时间  | body | false |Timestamp  | Timestamp   |
|note| 活动备注  | body | false |string  |    |
|startTime| 活动开始时间  | body | false |Timestamp  | Timestamp   |

**Timestamp**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|date|   | body | false |integer(int32)  |    |
|day|   | body | false |integer(int32)  |    |
|hours|   | body | false |integer(int32)  |    |
|minutes|   | body | false |integer(int32)  |    |
|month|   | body | false |integer(int32)  |    |
|nanos|   | body | false |integer(int32)  |    |
|seconds|   | body | false |integer(int32)  |    |
|time|   | body | false |integer(int64)  |    |
|timezoneOffset|   | body | false |integer(int32)  |    |
|year|   | body | false |integer(int32)  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"datetime": "",
	"msg": "",
	"timestamp": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回码  |integer(int32)  | integer(int32)   |
|data| 返回数据  |object  |    |
|datetime| 返回时间  |string  |    |
|msg| 返回消息  |string  |    |
|timestamp| 时间戳  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RetResult|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
