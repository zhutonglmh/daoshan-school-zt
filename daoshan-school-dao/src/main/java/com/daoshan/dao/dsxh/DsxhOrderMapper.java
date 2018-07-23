package com.daoshan.dao.dsxh;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.daoshan.bean.dsxh.entity.DsxhOrder;

import java.util.List;

public interface DsxhOrderMapper extends BaseMapper<DsxhOrder> {

    /**
     * 查询订单是否有
     * @param dsxhOrder
     * @return
     * @throws Exception
     */
    List<DsxhOrder> getUsedOrder(DsxhOrder dsxhOrder) throws Exception;

    List<DsxhOrder> findDataForPage(DsxhOrder dsxhOrder) throws Exception;
    List<DsxhOrder> findDataForPage2(DsxhOrder dsxhOrder);

    List<DsxhOrder> findDataForPage3(DsxhOrder dsxhOrder);
    int update3(DsxhOrder dsxhOrder) throws Exception;
}