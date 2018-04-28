package com.daoshan.school.controller.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("dsxh/common")
public class DsxhCommonController {

    @Autowired
    private DsxhCommonService dsxhCommonService;
    /**
     * 发送邮件验证码
     * @param dsxhUserDetail
     * @return
     */
    @PostMapping("sendEmail")
    public MessageBody sendEmail(@RequestBody DsxhUserDetail dsxhUserDetail){

        Map<String,Object> map = new HashMap<>();
        try {
            dsxhCommonService.sendEmail(dsxhUserDetail);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result","发送失败，请检查邮箱账号是否存在！");
            return  MessageBody.getMessageBody(true,map);
        }
        map.put("result","success");
        return  MessageBody.getMessageBody(true,map);
    }

    /**
     * 发送手机验证码
     * @param dsxhUserDetail
     * @return
     */
    @PostMapping("sendIphone")
    public MessageBody sendIphone(@RequestBody DsxhUserDetail dsxhUserDetail){

        Map<String,Object> map = new HashMap<>();
        try {
            String result = dsxhCommonService.sendIphoneCode(dsxhUserDetail);
            if("success".equals(result)){
                map.put("result","success");
                return MessageBody.getMessageBody(true,map);
            }
            map.put("result","发送失败，请检查手机号码是否存在！");
            return  MessageBody.getMessageBody(true,map);
        } catch (Exception e) {
            map.put("result","发送失败，请检查手机号码是否存在！");
            return  MessageBody.getMessageBody(true,map);
        }
    }
}
