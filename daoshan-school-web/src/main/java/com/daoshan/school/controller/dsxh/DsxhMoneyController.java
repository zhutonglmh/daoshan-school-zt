package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhMoney;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("dsxh/money")
@RestController
public class DsxhMoneyController {

    @Autowired
    private DsxhMoneyService dsxhMoneyService;

    @PostMapping("findDataForPage")
    public MessageBody findDateForPage(@RequestBody DsxhMoney dsxhMoney){

        Map<String,Object> map = new HashMap<>();
        List<DsxhMoney> list = dsxhMoneyService.findDataForPage(dsxhMoney);
        map.put("data",list);
        return MessageBody.getMessageBody(true,map);

    }
}
