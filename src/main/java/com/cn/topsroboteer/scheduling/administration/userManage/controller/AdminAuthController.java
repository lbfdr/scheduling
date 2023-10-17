package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.AdminAuthDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AdminAuthService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "菜单")
@Controller
@RequestMapping("/projectManagement/userManage/AdminAuth")
@CrossOrigin
public class AdminAuthController {

    @Autowired
    private AdminAuthService adminAuthService;

    @ApiOperation("查询")
    @GetMapping("/list")
    @ResponseBody
    private PageDataResult list( AdminAuthDTO adminAuthDTO, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){

        AdminAuth adminAuth = adminAuthDTO.convertToAdminAuth();

        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        return adminAuthService.list(adminAuth, pageNum, pageSize);
    }

    @ApiOperation("新增")
    @PostMapping("/addAdminAuth")
    @ResponseBody
    public ReturnModel addAdminAuth(@RequestBody AdminAuthDTO adminAuthDTO){
        ReturnModel returnModel=new ReturnModel();
        AdminAuth adminAuth = adminAuthDTO.convertToAdminAuth();
        int i = adminAuthService.addAdminAuth(adminAuth);
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
    @PostMapping("/upAdminAuth")
    @ResponseBody
    public ReturnModel upAdminAuth(@RequestBody AdminAuthDTO adminAuthDTO){
        ReturnModel returnModel=new ReturnModel();
        AdminAuth adminAuth = adminAuthDTO.convertToAdminAuth();
        int i = adminAuthService.upAdminAuth(adminAuth);
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
    @PostMapping("/delAdminAuth")
    @ResponseBody
    public ReturnModel delAdminAuth(@RequestBody AdminAuthDTO adminAuthDTO){
        ReturnModel returnModel=new ReturnModel();
        AdminAuth adminAuth = adminAuthDTO.convertToAdminAuth();
        int i = adminAuthService.delAdminAuth(adminAuth);
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
