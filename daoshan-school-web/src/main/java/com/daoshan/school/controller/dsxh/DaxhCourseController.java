package com.daoshan.school.controller.dsxh;

import com.alibaba.fastjson.JSON;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCourseService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dsxh/course")
public class DaxhCourseController {

    @Autowired
    private DsxhCourseService dsxhCourseService;

    @Autowired
    private DsxhUserService dsxhUserService;


    @PostMapping("/getCourseInfo")
    public MessageBody getCourseInfo(@RequestBody DsxhCourse dsxhCourse){

        Map<String,Object> map = new HashMap<String,Object>();
        try {
            dsxhCourse = dsxhCourseService.getCourseInfo(dsxhCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageBody.getMessageBody(true,map);
        }
        map.put("data",dsxhCourse);
        return MessageBody.getMessageBody(true,map);
    }


    @PostMapping("/addCourseInfo")
    public MessageBody addCourse(@RequestBody DsxhCourse dsxhCourse){

        Map<String,Object> map = new HashMap<String,Object>();
        dsxhCourse = dsxhCourseService.addCourse(dsxhCourse);
        map.put("data",dsxhCourse);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 条件搜索
     * @param dsxhCourse
     * @return
     */
    @PostMapping("/courseSearch")
    public MessageBody courseSearch(@RequestBody DsxhCourse dsxhCourse){

        Map<String,Object> map = new HashMap<String,Object>();
        List<DsxhCourse> list = dsxhCourseService.courseSearch(dsxhCourse);
        map.put("data",list);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 类别搜索
     * @param dsxhCourse
     * @return
     */
    @PostMapping("/courseSearchByType")
    public MessageBody courseSearchByType(@RequestBody DsxhCourse dsxhCourse){

        Map<String,Object> map = new HashMap<String,Object>();
        List<DsxhCourse> list = dsxhCourseService.courseSearchByType(dsxhCourse);
        map.put("data",list);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 分页搜索
     * @param dsxhCourse
     * @return
     */
    @PostMapping("/findDataForPage")
    public MessageBody findDateForPage(@RequestBody DsxhCourse dsxhCourse){

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        Map<String,Object> map = new HashMap<String,Object>();
        List<DsxhCourse> list = dsxhCourseService.courseSearchByType(dsxhCourse);
        map.put("data",list);
        return MessageBody.getMessageBody(true,map);
    }

    /**
     * 删除
     * @param dsxhCourse
     * @return
     */
    @PostMapping("/delete")
    public MessageBody delete(@RequestBody DsxhCourse dsxhCourse){

        Map<String,Object> map = new HashMap<String,Object>();
        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        if(1 != dsxhUser.getVip()){
            map.put("data","login");
            return MessageBody.getMessageBody(true,map);
        }

        int result = dsxhCourseService.delete(dsxhCourse);
        if(result > 0){
            map.put("data","success");
        }else {
            map.put("data","false");
        }
        return MessageBody.getMessageBody(true,map);
    }
}
