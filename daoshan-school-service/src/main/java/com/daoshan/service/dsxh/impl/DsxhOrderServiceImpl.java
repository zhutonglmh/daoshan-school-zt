package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.daoshan.bean.dsxh.entity.DsxhOrder;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhOrderMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhOrderService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public DsxhOrder addOrder(DsxhOrder dsxhOrder) throws Exception{

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();

        //新增订单
        dsxhOrder.setId(UUIDUtils.getUUID());
        dsxhOrder.setCreateUser(dsxhUser.getId());
        dsxhOrder.setUserName(dsxhUser.getUserName());
        dsxhOrder.setCreateTime(new Date());
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String reTime = format.format(new Date());
        String billNo = "GM"+reTime;
        dsxhOrder.setBillNo(billNo);
        dsxhOrder.setPriceAmt(dsxhOrder.getPrice());
        dsxhOrderMapper.insertAllColumn(dsxhOrder);

        BigDecimal spendMoney = dsxhOrder.getPrice();
        BigDecimal acountMoney = BigDecimal.valueOf(dsxhUser.getMoney());

        dsxhUser.setMoney(acountMoney.subtract(spendMoney).doubleValue());
        dsxhUserService.updateUser2(dsxhUser);
        return dsxhOrder;
    }

    /**
     * 查询订单
     *
     * @param dsxhOrder
     * @return
     */
    @Override
    public int selectOrder(DsxhOrder dsxhOrder) throws Exception {

        Wrapper<DsxhOrder> orderWrapper = new EntityWrapper(dsxhOrder);
        List<DsxhOrder> list = dsxhOrderMapper.selectList(orderWrapper);
        if(CollectionUtils.isEmpty(list)){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * 根据条件查询订单
     *
     * @param dsxhOrder
     * @return
     */
    @Override
    public Map<String,List<DsxhOrder>> findDataForPage(DsxhOrder dsxhOrder) throws Exception {

        Map<String,List<DsxhOrder>> map = new HashMap<>();

        List<DsxhOrder> one = new ArrayList<>();
        List<DsxhOrder> two = new ArrayList<>();
        List<DsxhOrder> three = new ArrayList<>();
        List<DsxhOrder> zero = new ArrayList<>();
        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if(AirUtils.hv(dsxhUser)){
            dsxhOrder.setCreateUser(dsxhUser.getId());
        }
        Wrapper<DsxhOrder> orderWrapper = new EntityWrapper(dsxhOrder);
        List<DsxhOrder> list = dsxhOrderMapper.selectList(orderWrapper);
        if (CollectionUtils.isEmpty(list)) return null;
        for (DsxhOrder dsxhOrder1 : list){
            if(dsxhOrder1.getStatus().equals(0)){
                zero.add(dsxhOrder1);
            }
            if(dsxhOrder1.getStatus().equals(1)){
                one.add(dsxhOrder1);
            }
            if(dsxhOrder1.getStatus().equals(2)){
                two.add(dsxhOrder1);
            }
            if(dsxhOrder1.getStatus().equals(3)){
                three.add(dsxhOrder1);
            }
        }
        map.put("zero",zero);
        map.put("one",one);
        map.put("two",two);
        map.put("three",three);
        map.put("all",list);
        return map;
    }
}
