package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.PostMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Post;
import com.cn.topsroboteer.scheduling.administration.userManage.service.PostService;
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
public class PostServiceImpl implements PostService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private PostMapper postMapper;


    @Override
    @Transactional
    public PageDataResult list(Post post, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult=new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<Post> list = postMapper.list(post);
        if (list.size()>0){
            PageInfo<Post> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    @Transactional
    public int addPost(Post post) {
        post.setPostId(IdUtils.getSeqId().toString());
        String s = DateUtil.currentDateTime();
        try {
            Date parse = sdf.parse(s);
            post.setCreateTime(parse);
            int i = postMapper.addPost(post);
            if (i>0){
                return 1;
            }else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public int upPost(Post post) {
        String s = DateUtil.currentDateTime();
        try {
            Date parse = sdf.parse(s);
            post.setUpdateTime(parse);
            int i = postMapper.upPost(post);
            if (i>0){
                return 1;
            }else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public int delPost(Post post) {
        int i = postMapper.delPost(post);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
