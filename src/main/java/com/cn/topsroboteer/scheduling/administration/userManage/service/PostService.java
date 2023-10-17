package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Post;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

public interface PostService {
    PageDataResult list(Post post, Integer pageNum, Integer pageSize);

    int addPost(Post post);

    int upPost(Post post);

    int delPost(Post post);
}
