package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhCollection;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.constans.ConStants;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCollectionService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dsxh/collect")
public class DsxhCollectionController {

    @Autowired
    private DsxhCollectionService dsxhCollectionService;

    @Autowired
    private DsxhUserService dsxhUserService;

    @PostMapping("getCollect")
    @ResponseBody
    public MessageBody getCollect() {

        Map<String,Object> map = new HashMap<String,Object>();
        DsxhUser dsxhUser  = dsxhUserService.getUserInfo();
        if (!AirUtils.hv(dsxhUser)){
            return null;
        }
        List<DsxhCourse> list = dsxhCollectionService.getCollectByUser(dsxhUser);
        map.put("data",list);
        return MessageBody.getMessageBody(true,map);
    }

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
