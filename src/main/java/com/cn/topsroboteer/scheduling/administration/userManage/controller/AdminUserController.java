package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.AdminUserDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDataDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AdminUserService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * @Author zhang
 * @Date 2022/5/17 16:41
 */
@Api(tags = "人员管理")
@Controller
@RequestMapping("/projectManagement/userManage/adminUser/")
@CrossOrigin
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation("人员列表")
    @ResponseBody
    @GetMapping("list")
    public PageDataResult list(AdminUserDTO adminUserDTO,Integer pageNum,Integer pageSize){

        AdminUser adminUser = adminUserDTO.convertToAdminUser();
        PageDataResult pageDataResult = adminUserService.list(adminUser,pageNum,pageSize);

        return pageDataResult;

    }


    @ApiOperation("添加人员")
    @PostMapping("/add")
    @ResponseBody
    public ReturnModel add(@RequestBody AdminUserDTO adminUserDTO){

        ReturnModel returnModel = new ReturnModel();
        AdminUser adminUser = adminUserDTO.convertToAdminUser();
        int i = adminUserService.add(adminUser);

        if (i==1){
            returnModel.setData(i);
            returnModel.setMsg("添加成功！");
            returnModel.setState(Constant.STATE_SUCCESS);
        }else{
            returnModel.setData(i);
            returnModel.setMsg("添加失败！");
            returnModel.setState(Constant.STATE_FAILURE);
        }

        return returnModel;

    }

    @ApiOperation("编辑人员")
    @PostMapping("/edit")
    @ResponseBody
    public ReturnModel edit(@RequestBody AdminUserDTO adminUserDTO){

        ReturnModel returnModel = new ReturnModel();
        AdminUser adminUser = adminUserDTO.convertToAdminUser();
        int i = adminUserService.edit(adminUser);

        if (i==1){
            returnModel.setData(i);
            returnModel.setMsg("修改成功！");
            returnModel.setState(Constant.STATE_SUCCESS);
        }else{
            returnModel.setData(i);
            returnModel.setMsg("修改失败！");
            returnModel.setState(Constant.STATE_FAILURE);
        }

        return returnModel;

    }

    @ApiOperation("删除人员")
    @PostMapping("/del")
    @ResponseBody
    public ReturnModel del(BaseDataDTO  dataDTO){

        String id = dataDTO.getId();
        ReturnModel returnModel = new ReturnModel();
        int i = adminUserService.del(id);

        if (i>0){
            returnModel.setData(i);
            returnModel.setMsg("删除成功！");
            returnModel.setState(Constant.STATE_SUCCESS);
        }else{
            returnModel.setData(i);
            returnModel.setMsg("修改失败！");
            returnModel.setState(Constant.STATE_FAILURE);
        }
        return returnModel;
    }








}
