package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import org.springframework.stereotype.Service;


public interface DsxhCommonService {

    /**
     * 发送邮件
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    public String sendEmail(DsxhUserDetail dsxhUserDetail) throws Exception;


    /**
     * 发送短信验证码
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    public String sendIphoneCode(DsxhUserDetail dsxhUserDetail) throws Exception;

    /**
     * 验证手机验证码
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    String checkIphone(DsxhUserDetail dsxhUserDetail) throws Exception;


    /**
     * 验证邮箱验证码
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    String checkEmail(DsxhUserDetail dsxhUserDetail) throws Exception;
}
