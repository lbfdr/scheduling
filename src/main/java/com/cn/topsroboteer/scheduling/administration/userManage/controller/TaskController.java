package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.TaskDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.TaskService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.FileUtil;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Api(tags = "任务")
@Controller
@RequestMapping("/projectManagement/userManage/Task")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @ApiOperation("查询")
    @GetMapping("/list")
    @ResponseBody
    public PageDataResult list( TaskDTO taskDTO, @RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        Task task = taskDTO.convertToAllocation();
        return taskService.list(task, pageNum, pageSize);

    }

    @ApiOperation("新增")
    @PostMapping("/addTask")
    @ResponseBody
    public ReturnModel addTask(@RequestBody TaskDTO taskDTO){
        ReturnModel returnModel=new ReturnModel();
        Task task = taskDTO.convertToAllocation();
        int i = taskService.addTask(task);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("新增成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else {
            returnModel.setData("");
            returnModel.setMsg("新增失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }

    @ApiOperation("修改")
    @PostMapping("/upTask")
    @ResponseBody
    public ReturnModel upTask(@RequestBody TaskDTO taskDTO){
        ReturnModel returnModel=new ReturnModel();
        Task task = taskDTO.convertToAllocation();
        int i = taskService.upTask(task);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("修改成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else {
            returnModel.setData("");
            returnModel.setMsg("修改失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }

    @ApiOperation("删除")
    @PostMapping("/delTask")//未完成
    @ResponseBody
    public ReturnModel delTask(@RequestBody TaskDTO taskDTO){
        Task task = taskDTO.convertToAllocation();
        ReturnModel returnModel=new ReturnModel();
        int i = taskService.delTask(task);
        if (i==1){
            returnModel.setData("");
            returnModel.setMsg("删除成功");
            returnModel.setState(Constant.STATE_SUCCESS);
            return returnModel;
        }else {
            returnModel.setData("");
            returnModel.setMsg("删除失败！");
            returnModel.setState(Constant.STATE_FAILURE);
            return returnModel;
        }
    }


    @ApiOperation("/导出")
    @GetMapping("/download")
    public void downLoad(HttpServletResponse response,@RequestBody TaskDTO taskDTO){
        Task task = taskDTO.convertToAllocation();
        PageDataResult list = taskService.list(task, 0, 0);
        List<Task> list1 = (List<Task>) list.getList();
        String dateTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmm");
        FileUtil.exportExcel(FileUtil.getWorkbook("任务","任务", Task.class,list1),"项目"+ dateTime +".xls",response);

    }

}
