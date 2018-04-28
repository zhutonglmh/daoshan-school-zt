package com.daoshan.service.dsxh;


import com.daoshan.bean.dsxh.entity.DsxhOrder;

/**
 * 课程购买订单
 */
public interface DsxhOrderService {

    /**
     * 新增订单
     * @return
     */
    public DsxhOrder addOrder(DsxhOrder dsxhOrder);

}
