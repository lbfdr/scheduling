package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Post;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.PostDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.PostService;
import com.cn.topsroboteer.scheduling.utils.Constant;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "岗位")
@Controller
@RequestMapping("/projectManagement/userManage/Post")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("查询")
    @GetMapping("/list")
    @ResponseBody
    public PageDataResult list( PostDTO postDTO, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        Post post = postDTO.convertToAllocation();
        return postService.list(post, pageNum, pageSize);
    }

    @ApiOperation("新增")
    @PostMapping("/addPost")
    @ResponseBody
    public ReturnModel addPost(@RequestBody PostDTO postDTO){
        ReturnModel returnModel=new ReturnModel();
        Post post = postDTO.convertToAllocation();
        int i = postService.addPost(post);
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
    @PostMapping("/upPost")
    @ResponseBody
    public ReturnModel upPost(@RequestBody PostDTO postDTO){
        Post post = postDTO.convertToAllocation();
        ReturnModel returnModel=new ReturnModel();
        int i = postService.upPost(post);
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
    @PostMapping("/delPost")
    @ResponseBody
    public ReturnModel delPost(@RequestBody PostDTO postDTO){
        Post post = postDTO.convertToAllocation();
        ReturnModel returnModel=new ReturnModel();
        int i = postService.delPost(post);
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
