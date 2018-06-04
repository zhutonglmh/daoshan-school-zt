package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCollection;
import com.daoshan.school.utils.constans.ConStants;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dsxh/collect")
public class DsxhCollectionController {

    @Autowired
    private DsxhCollectionService dsxhCollectionService;


    @PostMapping("add")
    @ResponseBody
    public MessageBody add(@RequestBody DsxhCollection dsxhCollection) {
        int result = dsxhCollectionService.add(dsxhCollection);
        String data = result > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;
        return MessageBody.getMessageBody(true, data);
    }

    @PostMapping("delete")
    @ResponseBody
    public MessageBody delete(@RequestBody DsxhCollection dsxhCollection) {
        int result = dsxhCollectionService.deleteCollect(dsxhCollection);
        String data = result > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;
        return MessageBody.getMessageBody(true, data);
    }
}
