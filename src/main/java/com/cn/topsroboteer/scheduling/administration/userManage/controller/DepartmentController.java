package com.cn.topsroboteer.scheduling.administration.userManage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Department;
import com.cn.topsroboteer.scheduling.administration.userManage.service.DepartmentService;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import com.cn.topsroboteer.scheduling.utils.result.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
@RestController
@RequestMapping("/projectManagement/userManage/department")
@Api(tags ="部门")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public PageDataResult page(@RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize") Integer pageSize,
                               Department department){
        IPage<Department> page =new Page<>(pageNum,pageSize);
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.orderByDesc("create_time");
        qw.like(StringUtils.hasText(department.getDepartmentName()),"department_name",department.getDepartmentName());
        page = departmentService.page(page, qw);
        return new PageDataResult(((int) page.getTotal()),page.getRecords());
    }
    @ApiOperation("添加记录")
    @PostMapping("/add")
    public ReturnModel add(@RequestBody Department department){
        department.setCreateTime(LocalDateTime.now());
        try {
            if (departmentService.save(department)) {
                return new ReturnModel("添加成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("添加失败",Constants.STATE_CODE_FAIL);
        }
    }
    @ApiOperation("修改记录")
    @PostMapping("/edit")
    public ReturnModel edit(@RequestBody Department department){
        department.setUpdateTime(LocalDateTime.now());
        try {
            if (departmentService.updateById(department)) {
                return new ReturnModel("修改成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        }
    }
    @ApiOperation("删除记录")
    @PostMapping("/remove")
    public ReturnModel remove(@RequestBody Department department){
        try {
            if (departmentService.removeById(department)) {
                return new ReturnModel("删除成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("删除失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("删除失败",Constants.STATE_CODE_FAIL);
        }
    }
}
