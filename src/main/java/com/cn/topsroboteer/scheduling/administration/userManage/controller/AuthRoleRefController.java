package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AuthRoleRef;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.AuthRoleRefDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AuthRoleRefService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色菜单")
@Controller
@RequestMapping("/projectManagement/userManage/AuthRoleRef")
@CrossOrigin
public class AuthRoleRefController {

    @Autowired
    private AuthRoleRefService authRoleRefService;

    @ApiOperation("修改")
    @PostMapping("/upAuthRoleRef")
    @ResponseBody
    public ReturnModel upAuthRoleRef(@RequestBody AuthRoleRefDTO authRoleRefDTO){//根据menuId和userRoleId修改
        ReturnModel returnModel=new ReturnModel();
        AuthRoleRef authRoleRef = authRoleRefDTO.convertToAllocation();
        int i = authRoleRefService.upAuthRoleRef(authRoleRef);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("修改成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else{
            returnModel.setData("");
            returnModel.setMsg("修改失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }
}
