package com.cn.topsroboteer.scheduling.administration.userManage.controller;


import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Group;
import com.cn.topsroboteer.scheduling.administration.userManage.service.GroupService;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import com.cn.topsroboteer.scheduling.utils.result.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
@RestController
@RequestMapping("/projectManagement/userManage/group")
@Api(tags = "小组")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/listDetail")
    @ApiOperation("小组详情列表")
    public PageDataResult listDetail(Group group,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize) {

        return groupService.getGroups(group,pageNum,pageSize);
    }

    @PostMapping("/save")
    @ApiOperation("添加小组")
    public ReturnModel save(@RequestBody Group group) {
        try {
            if (groupService.save(group)) {
                return new ReturnModel("添加成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("添加失败",Constants.STATE_CODE_FAIL);
        }

    }
    @PostMapping("/saveProjectToGroup")
    @ApiOperation("添加项目到小组")
    public ReturnModel saveProjectToGroup(@RequestBody Group group) {
        try {
            if (groupService.saveProjectToGroup(group)) {
                return new ReturnModel("添加成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/edit")
    @ApiOperation("修改小组")
    public ReturnModel edit(@RequestBody Group group) {
        try {
            if (groupService.updateById(group)) {
                return new ReturnModel("修改成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("修改失败",Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/editProjectOfGroup")
    @ApiOperation("修改小组的项目")
    public ReturnModel editProjectOfGroup(@RequestBody Group group) {
        try {
            if (groupService.editProjectOfGroup(group)) {
                return new ReturnModel("修改成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("修改失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("修改失败", Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/remove")
    @ApiOperation("删除小组")
    public ReturnModel remove(@RequestBody Group group) {
        try {
            if (groupService.removeById(group)) {
                return new ReturnModel("删除成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("删除失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("删除失败",Constants.STATE_CODE_FAIL);
        }
    }
}
