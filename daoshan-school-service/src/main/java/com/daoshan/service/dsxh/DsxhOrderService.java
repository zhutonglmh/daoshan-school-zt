package com.daoshan.service.dsxh;


import com.daoshan.bean.dsxh.entity.DsxhOrder;

import java.util.List;
import java.util.Map;

/**
 * 课程购买订单
 */
public interface DsxhOrderService {

    /**
     * 新增订单
     * @return
     */
    public DsxhOrder addOrder(DsxhOrder dsxhOrder) throws Exception;


    /**
     * 查询订单
     * @return
     */
    public int selectOrder(DsxhOrder dsxhOrder) throws Exception;

    /**
     * 根据条件查询订单
     * @return
     */
    public Map<String,List<DsxhOrder>> findDataForPage(DsxhOrder dsxhOrder) throws Exception;

}
