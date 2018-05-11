package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dsxh/userDetail")
public class DsxhUserDetailController {

    @Autowired
    private DsxhUserDetailService dsxhUserDetailService;



    @PostMapping("updUserInfo")
    public MessageBody updUserInfo(@RequestBody DsxhUserDetail dsxhUserDetail){

        String result = "";
        try {
            result = dsxhUserDetailService.addDsxhUserDetail(dsxhUserDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MessageBody.getMessageBody(true,result);
    }


    @PostMapping("getUserInfo")
    public MessageBody getUserInfo(){

        DsxhUser dsxhUser = null;
        try {
           dsxhUser = dsxhUserDetailService.getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MessageBody.getMessageBody(true,dsxhUser);
    }
}
