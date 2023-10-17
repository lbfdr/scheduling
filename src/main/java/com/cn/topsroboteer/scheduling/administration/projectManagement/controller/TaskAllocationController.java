package com.cn.topsroboteer.scheduling.administration.projectManagement.controller;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.TaskAllocation;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.dto.ProjectDTO;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.dto.TaskAllocationDTO;
import com.cn.topsroboteer.scheduling.administration.projectManagement.service.TaskAllocationService;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDataDTO;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhang
 * @Date 2023/8/2 13:43
 */
@Api(tags = "任务分配表")
@Controller
@RequestMapping("/projectManagement/TaskAllocation/")
@CrossOrigin
public class TaskAllocationController {

    @Autowired
    TaskAllocationService taskAllocationService;

    @ApiOperation("任务分配列表")
    @ResponseBody
    @GetMapping("list")
    public PageDataResult list(TaskAllocationDTO taskAllocationDTO,
                               @RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize")Integer pageSize){

        TaskAllocation taskAllocation = taskAllocationDTO.convertToTaskAllocation();
        PageDataResult pageDataResult = taskAllocationService.list(taskAllocation,pageNum,pageSize);
        return pageDataResult;

    }

    @ApiOperation("排序列表(逆序)")
    @ResponseBody
    @GetMapping("/sortList")
    public PageDataResult sortList(
                               @RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize")Integer pageSize){

        return taskAllocationService.sortList(pageNum,pageSize);
    }
    @ApiOperation("排序列表(顺序)")
    @ResponseBody
    @GetMapping("/sortListAsc")
    public PageDataResult sortListAsc(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize")Integer pageSize){

        return taskAllocationService.sortListAsc(pageNum,pageSize);
    }
    @ApiOperation("添加人员任务")
    @PostMapping("/add")
    @ResponseBody
    public ReturnModel add(@RequestBody TaskAllocationDTO taskAllocationDTO){

        ReturnModel returnModel = new ReturnModel();

        TaskAllocation taskAllocation = taskAllocationDTO.convertToTaskAllocation();
        int i = taskAllocationService.add(taskAllocation);
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



    @ApiOperation("修改人员任务")
    @PostMapping("/edit")
    @ResponseBody
    public ReturnModel edit(@RequestBody TaskAllocationDTO taskAllocationDTO){

        ReturnModel returnModel = new ReturnModel();
        TaskAllocation taskAllocation = taskAllocationDTO.convertToTaskAllocation();
        int i = taskAllocationService.edit(taskAllocation);

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
    @ApiOperation("删除人员任务记录")
    @PostMapping("/del")
    @ResponseBody
    public ReturnModel del(@RequestBody BaseDataDTO baseDataDTO){

        ReturnModel returnModel = new ReturnModel();
        String id = baseDataDTO.getId();
        int i = taskAllocationService.del(id);

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
