package com.cn.topsroboteer.scheduling.administration.userManage.controller;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Daily;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.DailyDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.service.DailyService;
import com.cn.topsroboteer.scheduling.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "日报")
@Controller
@RequestMapping("/projectManagement/userManage/Daily")
@CrossOrigin
public class DailyController {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");

    @Autowired
    private DailyService dailyService;

    @ApiOperation("查询")
    @GetMapping("list")
    @ResponseBody
    public PageDataResult list( DailyDTO dailyDTO, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        Daily daily = dailyDTO.convertToAllocation();

        String s = DateUtil.crutDate();
        String s1 = DateUtil.dateAdd(s, 1);
        Date start=null ,end=null;
        try {
            start=sdf.parse(s);
            end=sdf.parse(s1);
        } catch (ParseException e) {
            e.printStackTrace();//Unparseable date: "2023-08-31"
        }
        if (ToolUtil.isEmpty(daily.getStartDate())&&ToolUtil.isEmpty(daily.getEndDate())){
            daily.setStartDate(start);
            daily.setEndDate(end);
        }else if (daily.getStartDate().equals(daily.getEndDate())){
            daily.setStartDate(start);
            daily.setEndDate(end);
        }
        return dailyService.list(daily, pageNum, pageSize);
    }

    @ApiOperation("新增")
    @RequestMapping("/add")
    @ResponseBody
    public ReturnModel add(@RequestBody List<Daily> dailies){
        int i=0;
        Daily daily = dailies.get(0);
        String s = DateUtil.crutDate();
        String s1 = DateUtil.dateAdd(s, 1);
        Date start=null ,end=null;
        try {
            start=sdf.parse(s);
            end=sdf.parse(s1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        daily.setStartDate(start);
        daily.setEndDate(end);
        List<Daily> dailies1 = dailyService.selDaily(daily);
        if (ToolUtil.isEmpty(dailies1)){
            i=dailyService.add(dailies);
        }else {
            i=dailyService.update(dailies);
        }
        ReturnModel returnModel=new ReturnModel();
        if (i>0){
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
    @RequestMapping("/update")
    @ResponseBody
    public ReturnModel update(@RequestBody List<Daily> dailie){
        int add = dailyService.update(dailie);
        ReturnModel returnModel=new ReturnModel();
        if (add>0){
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
    @RequestMapping("/delete")
    @ResponseBody
    public ReturnModel delete(@RequestBody DailyDTO dailyDTO){
        Daily daily = dailyDTO.convertToAllocation();
        int add = dailyService.delete(daily);
        ReturnModel returnModel=new ReturnModel();
        if (add>0){
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


}
