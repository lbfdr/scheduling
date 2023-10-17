package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.AllocationDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AllocationService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "处理人")
@Controller
@RequestMapping("/projectManagement/userManage/Allocation")
@CrossOrigin
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @ApiOperation("查询")
    @GetMapping("/list")
    @ResponseBody
    public PageDataResult list( AllocationDTO allocationDTO, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        Allocation allocation = allocationDTO.convertToAllocation();
        return allocationService.list(allocation, pageNum, pageSize);
    }

    @ApiOperation("新增")
    @PostMapping("addAllocation")
    @ResponseBody
    public ReturnModel addAllocation(@RequestBody List<Allocation> list){
        ReturnModel returnModel=new ReturnModel();
        int i = allocationService.addAllocation(list);
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
    @PostMapping("upAllocation")
    @ResponseBody
    public ReturnModel upAllocation(@RequestBody AllocationDTO allocationDTO){
        ReturnModel returnModel=new ReturnModel();
        Allocation allocation = allocationDTO.convertToAllocation();
        int i = allocationService.upAllocation(allocation);
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
    @PostMapping("delAllocation")
    @ResponseBody
    public ReturnModel delAllocation(@RequestBody AllocationDTO allocationDTO){
        ReturnModel returnModel=new ReturnModel();
        Allocation allocation = allocationDTO.convertToAllocation();
        int i = allocationService.delAllocation(allocation);
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
