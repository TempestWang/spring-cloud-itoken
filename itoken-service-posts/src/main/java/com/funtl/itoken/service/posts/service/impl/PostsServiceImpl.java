package com.funtl.itoken.service.posts.service.impl;

import com.funtl.itoken.common.domain.TbPostsPost;
import com.funtl.itoken.common.mapper.TbPostsPostMapper;
import com.funtl.itoken.common.service.impl.BaseServiceImpl;
import com.funtl.itoken.service.posts.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Swang
 * Date: 2019-01-30
 * Time: 16:06
 */
@Service
@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService<TbPostsPost> {

}
