package com.daoshan.service.dsxh.impl;

import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.service.AliSms.AliSmsUntils;
import com.daoshan.service.AliSms.EmailSend;
import com.daoshan.service.dsxh.DsxhCommonService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class DsxhCommonServiceImpl implements DsxhCommonService {

    @Autowired
    private DsxhUserService dsxhUserService;

    /**
     * 发送邮件
     *
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    public String sendEmail(DsxhUserDetail dsxhUserDetail) throws Exception {

        String emailAddress = dsxhUserDetail.getUserEmail();
        int card = AirUtils.card();
        EmailSend.send_mail(emailAddress, (String.valueOf(card)));

        HttpSession session = dsxhUserService.getSession();
        session.setAttribute(emailAddress,card);
        return "success";
    }

    /**
     * 发送手机验证码
     *
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    public String sendIphoneCode(DsxhUserDetail dsxhUserDetail) throws Exception {

        String iphoneNumber = dsxhUserDetail.getUserIphone();
        int card = AirUtils.card();
        String result = AliSmsUntils.sms(iphoneNumber,String.valueOf(card));
        if("success".equals(result)){
            HttpSession session = dsxhUserService.getSession();
            session.setAttribute(iphoneNumber,card);
            return "success";
        }else {
            return "false";
        }
    }

    /**
     * 验证手机验证码
     *
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    public String checkIphone(DsxhUserDetail dsxhUserDetail) throws Exception {

        String userCard = dsxhUserDetail.getCard();
        String iphoneNumber = dsxhUserDetail.getUserIphone();

        HttpSession session = dsxhUserService.getSession();
        Object code = session.getAttribute(iphoneNumber);
        if (!AirUtils.hv(code)) return "false";
        if(userCard.equals(code.toString())){
            return "success";
        }else {
            return "false";
        }

    }

    /**
     * 验证邮箱验证码
     *
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    @Override
    public String checkEmail(DsxhUserDetail dsxhUserDetail) throws Exception {

        String userCard = dsxhUserDetail.getCard();
        String iphoneNumber = dsxhUserDetail.getUserEmail();

        HttpSession session = dsxhUserService.getSession();
        Object card = session.getAttribute(iphoneNumber);
        if (!AirUtils.hv(card)) return "false";
        if(userCard.equals(card.toString())){
            return "success";
        }else {
            return "false";
        }
    }
}
