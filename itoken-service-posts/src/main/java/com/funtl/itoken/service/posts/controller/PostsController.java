package com.funtl.itoken.service.posts.controller;

import com.funtl.itoken.common.domain.TbPostsPost;
import com.funtl.itoken.common.domain.TbSysUser;
import com.funtl.itoken.common.dto.BaseResult;
import com.funtl.itoken.common.utils.MapperUtils;
import com.funtl.itoken.service.posts.service.PostsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * User: Swang
 * Date: 2019-01-30
 * Time: 16:11
 */
@RestController
@RequestMapping(value = "v1/posts")
public class PostsController {

    @Autowired
    private PostsService<TbPostsPost> postsService;

    /**
     * 根据ID获取文章
     *
     * @param postGuid
     * @return
     */
    @RequestMapping(value = "{postGuid}", method = RequestMethod.GET)
    public BaseResult get(@PathVariable(value = "postGuid") String postGuid) {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost obj = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(obj);
    }

    /**
     * 保存文章
     *
     * @param tbPostsPostJson
     * @param optsBy
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam(required = true) String tbPostsPostJson,
            @RequestParam(required = true) String optsBy
    ) {
        int result = 0;

        TbPostsPost tbPostsPost = null;
        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tbPostsPost != null) {
            //主键为空，表示新增
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())) {
                tbPostsPost.setPostGuid(UUID.randomUUID().toString());
                result = postsService.insert(tbPostsPost, optsBy);
            }
            //编辑
            else {
                result = postsService.update(tbPostsPost, optsBy);
            }

            if (result > 0) {
                return BaseResult.ok("保存文章");
            }
        }


        return BaseResult.ok("保存文章失败");
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @ApiOperation("管理员分页查询")
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbPostsPostJson
    ) throws Exception {
        TbPostsPost tbPostsPost = null;

        if (tbPostsPostJson != null) {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        }

        PageInfo pageInfo = postsService.page(pageNum, pageSize, tbPostsPost);

        //分页后的结果集
        List<TbSysUser> list = pageInfo.getList();

        //封装Cursor对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());
        return BaseResult.ok(list, cursor);
    }
}
