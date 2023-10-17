package com.cn.topsroboteer.scheduling.administration.userManage.controller;


import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import com.cn.topsroboteer.scheduling.administration.userManage.service.GroupMemberService;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import com.cn.topsroboteer.scheduling.utils.result.Constants;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
@RestController
@RequestMapping("/projectManagement/userManage/groupMember")
@Api(tags = "人员")
public class GroupMemberController {
    @Autowired
    private GroupMemberService groupMemberService;

    @PostMapping("/save")
    @ApiOperation("添加人员")
    public ReturnModel save(@RequestBody GroupMember groupMember) {
        try {
            if (groupMemberService.save(groupMember)) {
                return new ReturnModel("添加成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("添加失败", Constants.STATE_CODE_FAIL);
        }
    }

    @ApiOperation("人员列表")
    @GetMapping("/page")
    public PageDataResult page(@RequestParam("pageNum") Integer pageNum,
                               @RequestParam("pageSize") Integer pageSize,
                               GroupMember member) {
        PageInfo<GroupMember> pageInfo = groupMemberService.queryGroupMemberList(member, pageNum, pageSize);
        return new PageDataResult(((int) pageInfo.getTotal()),pageInfo.getList());
    }
    @PostMapping("/edit")
    @ApiOperation("修改人员")
    public ReturnModel edit(@RequestBody GroupMember groupMember) {
        try {
            if (groupMemberService.updateById(groupMember)) {
                return new ReturnModel("修改成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("修改失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("修改失败", Constants.STATE_CODE_FAIL);
        }
    }
    @PostMapping("/remove")
    @ApiOperation("删除人员")
    public ReturnModel remove(@RequestBody GroupMember groupMember) {
        try {
            if (groupMemberService.removeById(groupMember)) {
                return new ReturnModel("删除成功",Constants.STATE_CODE_SUCCESS);
            }
            return new ReturnModel("删除失败", Constants.STATE_CODE_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnModel("删除失败", Constants.STATE_CODE_FAIL);
        }
    }
}
