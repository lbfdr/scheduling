/*
package com.cn.topsroboteer.scheduling.administration;

import com.alibaba.fastjson.JSONObject;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuths;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AuthorityService;
import com.cn.topsroboteer.scheduling.exception.InformationErrorException;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.JsonUtils;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

*/
/**
 * @Author zhang
 * @Date 2022/5/19 9:43
 *//*

@Api(tags = "登录")
@RestController
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private AuthorityService authorityService;


    */
/**
     * 用户登录
     *
     * @param params 包含username password
     * @return result
     *//*

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ReturnModel adminLogin(@RequestBody @NotNull String params) {
        ReturnModel dataModel = new ReturnModel();

//        String decode = AES.decode(params);
        JSONObject jsonObject = JSONObject.parseObject(params);
        if (Objects.isNull(jsonObject.getString("username")) || Objects.isNull(jsonObject.getString("password"))) {
            dataModel.setData("");
            dataModel.setMsg("用户名或者密码为空!");
            dataModel.setState(Constant.STATE_FAILURE);
            dataModel.setType(Constant.STATE_FAILURE);
            String model = JsonUtils.toString(dataModel);
//            return AES.encode(model);
            return dataModel;
        }
        AdminUser adminUser = authorityService.login(jsonObject.getString("username"), jsonObject.getString("password"));
        AdminUser result = new AdminUser();
        BeanUtils.copyProperties(adminUser, result);
        dataModel.setData(adminUser);
        dataModel.setMsg("登录成功");
        dataModel.setState(Constant.STATE_SUCCESS);
        dataModel.setType(Constant.STATE_SUCCESS);
        String model = JsonUtils.toString(dataModel);
        return  dataModel;
//        return AES.encode(model);
    }

    */
/**
     *任务管理系统左侧导航
     *
     * @param id 包含管理员id
     * @return result
     *//*

    @ApiOperation("左侧导航")
    @GetMapping("/nav")
    public ReturnModel navigationAuth(@RequestParam("id") String id) {

        ReturnModel returnModel = new ReturnModel();


        if (Objects.isNull(id) || "0".equals(id)  ) {
            //throw new InformationErrorException("请求数据错误");
            throw new InformationErrorException("请求数据有误");
        }
        List<AdminAuths> list = authorityService.navigationAuth(id);

        returnModel.setData(list);

        return returnModel;
    }





}
*/
