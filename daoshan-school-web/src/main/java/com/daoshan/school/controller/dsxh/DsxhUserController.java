package com.daoshan.school.controller.dsxh;

import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.bean.dsxh.entity.DsxhUserDetail;
import com.daoshan.school.aop.annotation.AccessControl;
import com.daoshan.school.utils.constans.ConStants;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhUserDetailService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("dsxh/user")
public class DsxhUserController {

    @Autowired
    private DsxhUserService dsxhUserService;

    @Autowired
    private DsxhUserDetailService dsxhUserDetailService;

    /**
     * 新增
     * @param dsxhUser 用户信息
     * @return 结果
     */
    @PostMapping("/insert")
    public MessageBody insertUser(@RequestBody DsxhUser dsxhUser){

        Map<String,Object> map = new HashMap<String,Object>();
        String result = dsxhUserService.insertUser(dsxhUser);
        map.put("data",result);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 修改用户资料
     * @param dsxhUserDetail 用户信息
     * @return 结果
     */
    @PostMapping("/updateUser")
    public MessageBody updateUser(@RequestBody DsxhUserDetail dsxhUserDetail){

        Map<String,Object> map = new HashMap<String,Object>();
        //String result = dsxhUserService.updateUser(dsxhUserDetail);
        //map.put("data",result);
        return MessageBody.getMessageBody(true,map);
    }
























    /**
     * 删除
     * @param dsxhUser
     * @return
     */
    @PostMapping("/delete")
    public MessageBody deleteUser(@RequestBody DsxhUser dsxhUser){

        Map<String,Object> map = new HashMap<String,Object>();
        String result = dsxhUserService.deleteUser(dsxhUser);
        map.put("data",result);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 分页查询
     * @param dsxhUser
     * @return ss
     */
    @PostMapping("/findDataForPage")
    public MessageBody findDataForPage(@RequestBody DsxhUser dsxhUser){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<DsxhUser> page = new Page<DsxhUser>();
        page.setCurrent(1);
        page.setSize(3);
        page = dsxhUserService.findDataForPage(page,dsxhUser);
        map.put("data",page);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 用户登录
     * @param dsxhUser
     * @return
     */
    @AccessControl
    @PostMapping("/userLogin")
    public MessageBody userLogin(@RequestBody DsxhUser dsxhUser){
        Map<String,Object> map = new HashMap<String,Object>();
        HashMap<String,Object> result = dsxhUserService.userLogin(dsxhUser);
        map.put("data",result);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    @PostMapping("/getUserLoginInfo")
    public MessageBody isUserLogin(){
        Map<String,Object> map = new HashMap<String,Object>();
        DsxhUser dsxhUser = null;
        try {
            dsxhUser = dsxhUserDetailService.getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null != dsxhUser){
            map.put("data",dsxhUser);
        }else {
            map.put("data", ConStants.DSXH_FAILUER);
        }
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @PostMapping("/loginOut")
    public MessageBody loginOut(){

        HttpSession session = dsxhUserService.getSession();
        session.removeAttribute("id");
        if(session.getAttribute("id") != null){
            session.invalidate();
        }
        return MessageBody.getMessageBody(true,"success");
    }
}
