package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.DailyMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Daily;
import com.cn.topsroboteer.scheduling.administration.userManage.service.DailyService;
import com.cn.topsroboteer.scheduling.utils.DateUtil;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DailyServiceImpl implements DailyService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public PageDataResult list(Daily daily,Integer pageNum,Integer pageSize) {
        PageDataResult pageDataResult=new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<Daily> list = dailyMapper.list(daily);
        if (list.size()>0){
            PageInfo<Daily> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    public List<Daily> selDaily(Daily daily) {
        return null;
    }

    @Override
    @Transactional
    public int add(List<Daily> daily) {
        int i=0;
        for (Daily daily1 : daily) {
            String s = DateUtil.currentDateTime();
            try {
                Date parse = sdf.parse(s);
                daily1.setDailyDate(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            daily1.setId(IdUtils.getSeqId().toString());
            dailyMapper.add(daily1);
            i++;
        }
        if (i==daily.size()){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int update(List<Daily> daily) {
        int i =0;
        for (Daily daily1 : daily) {
             dailyMapper.update(daily1);
             i++;
        }
        if (i==daily.size()){
            return 1;
        }else {
        return 0;
        }
    }

    @Override
    @Transactional
    public int delete(Daily daily) {
        int i = dailyMapper.delete(daily);
        if (i>0){
            return 1;
        }else {
            return 0;
        }

    }
}
