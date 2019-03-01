package com.funtl.itoken.common.service;

import com.funtl.itoken.common.domain.BaseDomain;
import com.github.pagehelper.PageInfo;

/**
 * User: Swang
 * Date: 2019-01-29
 * Time: 16:59
 */
public interface BaseService<T extends BaseDomain> {

    int insert(T t, String createBy);

    int delete(T t);

    int update(T t, String updateBy);

    int selectCount(T t);

    T selectOne(T t);

    PageInfo<T> page(int pageNum, int pageSize, T t);

}
