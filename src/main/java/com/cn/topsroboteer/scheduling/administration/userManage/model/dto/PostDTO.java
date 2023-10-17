package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Post;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class PostDTO extends BaseDTO {



    private String postId;

    private String postName;

    private String sort;

    private Date createTime;

    private Date updateTime;

    private String isDel;

    public Post convertToAllocation(){
        PostConvert postConvert = new PostConvert();
        return postConvert.doForward(this);
    }

    private static class PostConvert extends BaseDtoConvert<PostDTO, Post>{
        @Override
        protected Post doForward(PostDTO postDTO) {
            Post post = new Post();
            BeanUtils.copyProperties(postDTO, post);
            return post;
        }

        @Override
        protected PostDTO doBackward(Post post) {
            return null;
        }
    }



}
