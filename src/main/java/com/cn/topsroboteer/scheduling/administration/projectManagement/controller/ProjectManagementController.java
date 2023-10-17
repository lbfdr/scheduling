/*
package com.cn.topsroboteer.scheduling.administration.projectManagement.controller;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.dto.ProjectDTO;

import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDataDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @Author zhang
 * @Date 2022/5/17 10:07
 *//*

@Api(tags = "项目管理")
@Controller
@RequestMapping("/projectManagement/project/")
@CrossOrigin
public class ProjectManagementController {

    @Autowired
    private ProjectManagementService projectManagementService;


    @ApiOperation("项目列表")
    @ResponseBody
    @GetMapping("list")
    public PageDataResult list(ProjectDTO projectsDTO, Integer pageNum, Integer pageSize){

        Project projects = projectsDTO.convertToAdminUser();
        PageDataResult pageDataResult = projectManagementService.list(projects,pageNum,pageSize);

       return pageDataResult;

    }

    @ApiOperation("添加项目")
    @PostMapping("/add")
    @ResponseBody
    public ReturnModel add(@RequestBody ProjectDTO projectsDTO){

        ReturnModel returnModel = new ReturnModel();

        Project projects = projectsDTO.convertToAdminUser();
        int i = projectManagementService.add(projects);

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

    @ApiOperation("修改项目")
    @PostMapping("/edit")
    @ResponseBody
    public ReturnModel edit(@RequestBody ProjectDTO projectsDTO){

        ReturnModel returnModel = new ReturnModel();
        Project projects = projectsDTO.convertToAdminUser();
        int i = projectManagementService.edit(projects);

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
    @ApiOperation("删除项目")
    @PostMapping("/del")
    @ResponseBody
    public ReturnModel del(BaseDataDTO baseDataDTO){

        ReturnModel returnModel = new ReturnModel();
        String id = baseDataDTO.getId();
        int i = projectManagementService.del(id);

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

    @ApiOperation("导出项目")
    @GetMapping(value = "/projectExcel")
    public void  projectExcel(HttpServletResponse response, ProjectDTO projectDTO) throws Exception {
        List<Project> projectExcel = null;
        Map<String,String> search = new HashMap<>();
        Project project = projectDTO.convertToAdminUser();
        projectExcel = projectManagementService.projectExcel(project);
        String dateTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmm");
        //     FileUtil.exportExcel(FileUtil.getWorkbook("封顶价格", "封顶价格", SysScenicSpotCapPriceLog.class, scenicSpotCapPriceLogByExample),"封顶价格"+ dateTime +".xls",response);
        FileUtil.exportExcel(FileUtil.getWorkbook("项目","项目",Project.class,projectExcel),"项目"+ dateTime +".xls",response);
    }



}
*/
