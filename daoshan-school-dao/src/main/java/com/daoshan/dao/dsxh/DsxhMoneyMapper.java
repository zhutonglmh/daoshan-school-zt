package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhMoney;

import java.util.List;

public interface DsxhMoneyMapper extends BaseMapper<DsxhMoney> {

    List<DsxhMoney> findDataForPage(DsxhMoney dsxhMoney);
}
