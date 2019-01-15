# 一、基本介绍
Jwt-Security的演示Demo

# 二、功能测试
## 权限划分
用户表：

|  账户名  |  密码  |  角色  |
| ------------ | ------------ | ------------ |
|  user  |  123456  |  USER  |
|  admin  |  123456  |  USER，ADMIN  |


------------


角色权限表：

|  角色  |  权限  |  说明  |
| ------------ | ------------ | ------------ |
|  USER  |  account_users_info  |  拥有查看用户信息的权限  |
|  ADMIN  |  account_users_create  |  拥有添加用户的权限  |

## 资源列表
* localhost:8080/    `主页，都可访问`
* localhost:8080/auth/login   `登录页面，都可访问`
* localhost:8080/user/info    `用户登录后均可访问，即需要 account_users_info 权限`
* localhost:8080/admin/create   `添加用户页面，admin登录后可访问，即需要 account_users_create 权限`


## 开始测试
1. 删除`@EnableJwtSecurity`注解：
> * `发现任意资源均可访问 (╥╯^╰╥)`

2. 开启`@EnableJwtSecurity`注解：
> * localhost:8080/localhost:8080/auth/login  `可访问`
> * localhost:8080/user/info  `不可访问（401）`

3. 删除`@RequireAuthority("account_users_create")`注解，user账户登录：
> * localhost:8080/user/info   `可访问`
> * localhost:8080/admin/create   `可访问`

4. 开启`@RequireAuthority("account_users_create")`注解，user账户登录：
> * localhost:8080/user/info   `可访问`
> * localhost:8080/admin/create   `不可访问`

5. admin账户登录：
> * localhost:8080/user/info   `可访问`
> * localhost:8080/admin/create   `可访问，并可成功添加用户`

6. 时不时点击一下右上角的`个人中心`：
> * `发现1分钟后仍处于登录状态`

7. 不操作，1分钟后（设置的token失效时间）：
> * `发现任意资源不可访问，说明已自动退出登录`

8. 登录状态下，再退出登录：
> * `发现任意资源不可访问`