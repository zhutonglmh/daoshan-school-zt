package com.daoshan.service.dsxh.impl;

import com.daoshan.bean.dsxh.entity.DsxhOrder;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhOrderMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhOrderService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class DsxhOrderServiceImpl implements DsxhOrderService {


    @Resource
    private DsxhOrderMapper dsxhOrderMapper;

    @Autowired
    private DsxhUserService dsxhUserService;


    /**
     * 新增订单
     *
     * @return
     */
    @Override
    public DsxhOrder addOrder(DsxhOrder dsxhOrder) {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();

        //新增订单
        dsxhOrder.setId(UUIDUtils.getUUID());
        dsxhOrder.setCreateUser(dsxhUser.getId());
        dsxhOrder.setUserName(dsxhUser.getUserName());
        dsxhOrder.setCreateTime(new Date());

        dsxhOrderMapper.insertAllColumn(dsxhOrder);

        BigDecimal spendMoney = dsxhOrder.getPrice();
        BigDecimal AcountMoney = BigDecimal.valueOf(dsxhUser.getMoney());

        dsxhUser.setMoney(spendMoney.subtract(AcountMoney).doubleValue());
        dsxhUserService.updateUserInfo(dsxhUser);
        return dsxhOrder;
    }
}
