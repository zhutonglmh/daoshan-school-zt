package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.daoshan.bean.dsxh.entity.DsxhMoney;
import com.daoshan.bean.dsxh.entity.DsxhOrder;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhMoneyMapper;
import com.daoshan.dao.dsxh.DsxhOrderMapper;
import com.daoshan.dao.dsxh.DsxhUserMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhMoneyService;
import com.daoshan.service.dsxh.DsxhOrderService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DsxhOrderServiceImpl implements DsxhOrderService {


    @Resource
    private DsxhMoneyMapper dsxhMoneyMapper;
    @Resource
    private DsxhOrderMapper dsxhOrderMapper;

    @Resource
    private DsxhUserMapper dsxhUserMapper;

    @Autowired
    private DsxhUserService dsxhUserService;

    @Autowired
    private DsxhMoneyService dsxhMoneyService;


    /**
     * 新增订单
     *
     * @return
     */
    @Override
    @Transactional
    public DsxhOrder addOrder(DsxhOrder dsxhOrder) throws Exception {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();

        //新增订单
        dsxhOrder.setId(UUIDUtils.getUUID());
        dsxhOrder.setCreateUser(dsxhUser.getId());
        dsxhOrder.setUserName(dsxhUser.getUserName());
        dsxhOrder.setCreateTime(new Date());
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String reTime = format.format(new Date());
        String billNo = "GM" + reTime;
        dsxhOrder.setBillNo(billNo);
        dsxhOrder.setPriceAmt(dsxhOrder.getPrice());

        DsxhOrder dsxhOrder1 = new DsxhOrder();
        dsxhOrder1.setCreateUser(dsxhOrder.getCreateUser());
        dsxhOrder1.setCourseId(dsxhOrder.getCourseId());
        Wrapper<DsxhOrder> wrapper = new EntityWrapper<>(dsxhOrder1);
        dsxhOrderMapper.delete(wrapper);
        dsxhOrderMapper.insertAllColumn(dsxhOrder);
        BigDecimal spendMoney = dsxhOrder.getPrice();
        BigDecimal acountMoney = BigDecimal.valueOf(dsxhUser.getMoney());
        if(dsxhOrder.getStatus().equals(1)){
            dsxhUser.setMoney(acountMoney.subtract(spendMoney).doubleValue());
            dsxhUserService.updateUser2(dsxhUser);

            DsxhMoney dsxhMoney = new DsxhMoney();
            dsxhMoney.setId(UUIDUtils.getUUID());
            dsxhMoney.setType(1);
            dsxhMoney.setCause("购买课程《"+dsxhOrder.getCourseName()+"》");
            dsxhMoney.setMoney(dsxhOrder.getPrice().doubleValue());
            dsxhMoney.setBillNo(dsxhOrder.getBillNo());
            dsxhMoneyService.add(dsxhMoney);
        }
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
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        } else {
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
    public Map<String, List<DsxhOrder>> findDataForPage(DsxhOrder dsxhOrder) throws Exception {

        Map<String, List<DsxhOrder>> map = new HashMap<>();
        List<DsxhOrder> one = new ArrayList<>();
        List<DsxhOrder> two = new ArrayList<>();
        List<DsxhOrder> three = new ArrayList<>();
        List<DsxhOrder> zero = new ArrayList<>();
        List<DsxhOrder> four = new ArrayList<>();
        List<DsxhOrder> five = new ArrayList<>();
        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if (AirUtils.hv(dsxhUser)) {
            dsxhOrder.setCreateUser(dsxhUser.getId());
        }
        Wrapper<DsxhOrder> orderWrapper = new EntityWrapper(dsxhOrder);
        List<DsxhOrder> list = dsxhOrderMapper.selectList(orderWrapper);
        if (CollectionUtils.isEmpty(list)) return null;
        for (DsxhOrder dsxhOrder1 : list) {
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String time = sdf.format(dsxhOrder1.getCreateTime());
            dsxhOrder1.setTimeStr(time);
            if (dsxhOrder1.getStatus().equals(0)) {
                zero.add(dsxhOrder1);
            }
            if (dsxhOrder1.getStatus().equals(1)) {
                one.add(dsxhOrder1);
            }
            if (dsxhOrder1.getStatus().equals(2)) {
                two.add(dsxhOrder1);
            }
            if (dsxhOrder1.getStatus().equals(3)) {
                three.add(dsxhOrder1);
            }
            if (dsxhOrder1.getStatus().equals(4)) {
                four.add(dsxhOrder1);
            }
            if (dsxhOrder1.getStatus().equals(5)) {
                five.add(dsxhOrder1);
            }
        }
        map.put("zero", zero);
        map.put("one", one);
        map.put("two", two);
        map.put("three", three);
        map.put("four", four);
        map.put("five", five);
        map.put("all", list);
        if(dsxhUser.getVip() == 1){

            List<DsxhOrder> list1 = dsxhOrderMapper.findDataForPage2(new DsxhOrder());
           for(DsxhOrder dsxhOrder1 : list1) {
                String format = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                String time = sdf.format(dsxhOrder1.getCreateTime());
                dsxhOrder1.setTimeStr(time);
            }
            List<DsxhOrder> list2= dsxhOrderMapper.findDataForPage3(new DsxhOrder());
            for(DsxhOrder dsxhOrder1 : list2) {
                String format = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                String time = sdf.format(dsxhOrder1.getCreateTime());
                dsxhOrder1.setTimeStr(time);
            }
            map.put("two", list1);
            map.put("five", list2);
        }
        return map;
    }

    @Override
    public List<DsxhOrder> findDataForPage2(DsxhOrder dsxhOrder) throws Exception {

        return dsxhOrderMapper.findDataForPage2(dsxhOrder);
    }

    /**
     * 修改订单状态
     *
     * @param dsxhOrder
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public String updateOrder(DsxhOrder dsxhOrder) throws Exception {


        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if(dsxhUser.getVip() == 1 && dsxhOrder.getStatus() == 1){
            dsxhOrder.setStatus(4);
        }
        int result = dsxhOrderMapper.update3(dsxhOrder);
        //已支付状态
        if(dsxhOrder.getStatus().equals(1)){


            BigDecimal spendMoney = dsxhOrder.getPrice();
            BigDecimal acountMoney = BigDecimal.valueOf(dsxhUser.getMoney());
            if(dsxhOrder.getStatus().equals(1)){
                dsxhUser.setMoney(acountMoney.subtract(spendMoney).doubleValue());
                dsxhUserService.updateUser2(dsxhUser);
            }
        }
        //已退款状态
        if(dsxhOrder.getStatus().equals(4)){

            DsxhOrder dsxhOrder1 = dsxhOrderMapper.selectById(dsxhOrder.getId());
            DsxhUser dsxhUser1 = dsxhUserMapper.selectById(dsxhOrder1.getCreateUser());
            BigDecimal spendMoney = dsxhOrder.getPrice();
            BigDecimal acountMoney = BigDecimal.valueOf(dsxhUser1.getMoney());
            if(dsxhOrder.getStatus().equals(1)){
                dsxhUser1.setMoney(acountMoney.add(spendMoney).doubleValue());
                dsxhUserService.updateUser2(dsxhUser1);
                DsxhMoney dsxhMoney =new DsxhMoney();
                dsxhMoney.setId(UUIDUtils.getUUID());
                dsxhMoney.setMoney(spendMoney.doubleValue());
                dsxhMoney.setCause("课程退款");
                dsxhMoney.setType(2);
                DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
                String reTime = format.format(new Date());
                String billNo = "GM" + reTime;
                dsxhMoney.setBillNo(billNo);
                dsxhMoney.setCreateUser(dsxhUser1.getId());
                dsxhMoney.setCreateTime(new Date());
                dsxhMoneyMapper.insert(dsxhMoney);
            }
        }
        if (result > 0) {
            return "success";
        } else return "false";
    }

    /**
     * 根据条件查询课程是否被购买
     *
     * @param dsxhOrder
     * @return
     */
    @Override
    public int getUsedOrder(DsxhOrder dsxhOrder) throws Exception {

        dsxhOrder.setCreateUser(dsxhUserService.getUserInfo().getId());
        List<DsxhOrder> list = dsxhOrderMapper.getUsedOrder(dsxhOrder);
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        } else {
            return 1;
        }
    }
}
