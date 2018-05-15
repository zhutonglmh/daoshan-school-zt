package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhOrder;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhOrderService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新增购买单  购买记录
 */
@RestController
@RequestMapping("dsxh/order")
public class DsxhOrderController  {

    @Autowired
    private DsxhOrderService dsxhOrderService;

    @PostMapping("addOrder")
    public MessageBody addOrder(@RequestBody DsxhOrder dsxhOrder){

        Map<String,Object> map = new HashMap<>();
        try {
            dsxhOrder = dsxhOrderService.addOrder(dsxhOrder);
            map.put("data",dsxhOrder);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data","false");
            return MessageBody.getMessageBody(true,map);
        }
        map.put("data",dsxhOrder);
        return MessageBody.getMessageBody(true,map);
    }


    @PostMapping("findDataForPage")
    public MessageBody findDataForPage(@RequestBody DsxhOrder dsxhOrder){

        Map<String,List<DsxhOrder>> map = new HashMap<>();
        try {
            map = dsxhOrderService.findDataForPage(dsxhOrder);
            return MessageBody.getMessageBody(true,map);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageBody.getMessageBody(true,map);
        }

    }

    @PostMapping("updateOrder")
    public MessageBody updateOrder(@RequestBody DsxhOrder dsxhOrder){

        Map<String,List<DsxhOrder>> map = new HashMap<>();
        try {
            String result = dsxhOrderService.updateOrder(dsxhOrder);
            return MessageBody.getMessageBody(true,result);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageBody.getMessageBody(true,"false");
        }
    }
}
