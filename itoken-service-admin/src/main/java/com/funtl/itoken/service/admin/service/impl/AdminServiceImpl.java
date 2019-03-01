package com.funtl.itoken.service.admin.service.impl;

import com.funtl.itoken.common.domain.TbSysUser;
import com.funtl.itoken.common.mapper.TbSysUserMapper;
import com.funtl.itoken.common.service.impl.BaseServiceImpl;
import com.funtl.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Swang
 * Date: 2019-01-25
 * Time: 11:53
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService<TbSysUser> {


}
