package com.daoshan.school.controller.dsxh;

import com.alibaba.fastjson.JSON;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dsxh/course")
public class DaxhCourseController {

    @Autowired
    private DsxhCourseService dsxhCourseService;


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
        System.out.println(JSON.toJSONString(dsxhCourse));
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
}
