package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.UserRole;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.UserRoleDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.UserRoleService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "权限")
@Controller
@RequestMapping("/projectManagement/userManage/userRole")
@CrossOrigin
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("查询")
    @GetMapping("/list")
    @ResponseBody
    public PageDataResult list( UserRoleDTO userRoleDTO, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        UserRole userRole = userRoleDTO.convertToAllocation();
        return userRoleService.list(userRole,pageNum,pageSize);
    }

    @ApiOperation("新增")
    @PostMapping("/addUserRole")
    @ResponseBody
    public ReturnModel addUserRole(@RequestBody UserRoleDTO userRoleDTO){
        ReturnModel returnModel=new ReturnModel();
        UserRole userRole = userRoleDTO.convertToAllocation();
        int i = userRoleService.addUserRole(userRole);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("新增成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else{
            returnModel.setData("");
            returnModel.setMsg("新增失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }

    @ApiOperation("修改")
    @PostMapping("/upUserRole")
    @ResponseBody
    public ReturnModel upUserRole(@RequestBody UserRoleDTO userRoleDTO){
        ReturnModel returnModel=new ReturnModel();
        UserRole userRole = userRoleDTO.convertToAllocation();
        int i = userRoleService.upUserRole(userRole);
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

    @ApiOperation("删除")
    @PostMapping("/delUserRole")
    @ResponseBody
    public ReturnModel delUserRole(@RequestBody UserRoleDTO userRoleDTO){
        ReturnModel returnModel=new ReturnModel();
        UserRole userRole = userRoleDTO.convertToAllocation();
        int i = userRoleService.delUserRole(userRole);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("删除成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else{
            returnModel.setData("");
            returnModel.setMsg("删除失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }
}
