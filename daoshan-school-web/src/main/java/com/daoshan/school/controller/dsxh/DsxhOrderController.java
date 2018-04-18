package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhOrder;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dsxh/order")
public class DsxhOrderController  {

    @Autowired
    private DsxhOrderService dsxhOrderService;

    @PostMapping("addOrder")
    public MessageBody addOrder(@RequestBody DsxhOrder dsxhOrder){

        return null;
    }
}
