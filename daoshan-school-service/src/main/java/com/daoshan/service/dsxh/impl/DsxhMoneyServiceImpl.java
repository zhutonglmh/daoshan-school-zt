package com.daoshan.service.dsxh.impl;

import com.daoshan.bean.dsxh.entity.DsxhMoney;
import com.daoshan.dao.dsxh.DsxhMoneyMapper;
import com.daoshan.service.dsxh.DsxhMoneyService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DsxhMoneyServiceImpl implements DsxhMoneyService {

    @Resource
    private DsxhMoneyMapper dsxhMoneyMapper;

    @Autowired
    private DsxhUserService dsxhUserService;

    @Override
    @Transactional
    public int add(DsxhMoney dsxhMoney) {

        dsxhMoney.setCreateTime(new Date());
        dsxhMoney.setCreateUser(dsxhUserService.getUserInfo().getId());
        return dsxhMoneyMapper.insert(dsxhMoney);
    }

    @Override
    public List<DsxhMoney> findDataForPage(DsxhMoney dsxhMoney) {

        dsxhMoney.setCreateUser(dsxhUserService.getUserInfo().getId());

        List<DsxhMoney> list = dsxhMoneyMapper.findDataForPage(dsxhMoney);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        for(DsxhMoney dsxhMoney1 : list){

            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String time = sdf.format(dsxhMoney1.getCreateTime());
            dsxhMoney1.setTime(time);
            dsxhMoney1.setCreateUser(dsxhUserService.getUserInfo().getUserName());
        }
        return list;
    }


}
