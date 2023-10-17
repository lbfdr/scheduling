package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Post;

import java.util.List;

public interface PostMapper {

    List<Post> list(Post post);

    int addPost(Post post);

    int upPost(Post post);

    int delPost(Post post);
}
