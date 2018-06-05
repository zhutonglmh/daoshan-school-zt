package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhMoney;

import java.util.List;

public interface DsxhMoneyService {

    /**
     * 新增
     * @param dsxhMoney
     * @return
     */
    int add(DsxhMoney dsxhMoney);

    /**
     * 查询
     * @param dsxhMoney
     * @return
     */
    List<DsxhMoney> findDataForPage(DsxhMoney dsxhMoney);
}
