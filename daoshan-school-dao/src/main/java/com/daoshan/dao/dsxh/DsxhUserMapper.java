package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.daoshan.bean.dsxh.entity.DsxhUser;

import java.util.List;

/**
 * 用户信息处理
 */
public interface DsxhUserMapper extends BaseMapper<DsxhUser>{

    List<DsxhUser> selectByZt(Pagination page, DsxhUser dsxhUser);

    int updateByUser(DsxhUser dsxhUser) throws Exception;

    int updateMoneyByUser(DsxhUser dsxhUser) throws Exception;
}
