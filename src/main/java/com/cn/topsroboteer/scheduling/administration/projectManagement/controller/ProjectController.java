package com.cn.topsroboteer.scheduling.administration.projectManagement.controller;


import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.projectManagement.service.ProjectService;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import com.cn.topsroboteer.scheduling.utils.result.Constants;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
@RestController
@RequestMapping("/projectManagement/project/")
@Api(tags ="项目")
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @GetMapping("/pageAsc")
    @ApiOperation("分页查询列表(顺序)")
    public PageDataResult page(@RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize") Integer pageSize,
                               Project project) {

        PageInfo<Project> pageInfo = projectService.getProjectsAsc(project, pageNum, pageSize);
        return new PageDataResult(((int) pageInfo.getTotal()),pageInfo.getList());
    }
    @GetMapping("/pageDesc")
    @ApiOperation("分页查询列表(倒序)")
    public PageDataResult pageOrdered(@RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize") Integer pageSize,
                               Project project) {

        PageInfo<Project> pageInfo = projectService.getProjectsDesc(project, pageNum, pageSize);
        return new PageDataResult(((int) pageInfo.getTotal()),pageInfo.getList());
    }
    @PostMapping("/save")
    @ApiOperation("保存记录")
    public ReturnModel save(@RequestBody Project project) {
        try {
            if (projectService.save(project)) {
                return new ReturnModel("添加成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("添加失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/edit")
    @ApiOperation("修改记录")
    public ReturnModel edit(@RequestBody Project project) {
        try {
            if (projectService.updateById(project)) {
                return new ReturnModel("修改成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/remove")
    @ApiOperation("删除记录")
    public ReturnModel remove(@RequestBody Project project) {
        try {
            if (projectService.removeById(project)) {
                return new ReturnModel("删除成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("删除失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("删除失败",Constants.STATE_CODE_FAIL);
        }
    }

}
