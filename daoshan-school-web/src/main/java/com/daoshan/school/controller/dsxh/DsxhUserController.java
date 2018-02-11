package com.daoshan.school.controller.dsxh;

import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("dsxh/user")
public class DsxhUserController {

    @Autowired
    private DsxhUserService dsxhUserService;

    /**
     * 新增
     * @param dsxhUser
     * @return
     */
    @PostMapping("/insert")
    public MessageBody insertUser(@RequestBody DsxhUser dsxhUser){

        Map<String,Object> map = new HashMap<String,Object>();

        String result = dsxhUserService.insertUser(dsxhUser);

        map.put("data",result);

        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 分页查询
     * @param dsxhUser
     * @return
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
}
