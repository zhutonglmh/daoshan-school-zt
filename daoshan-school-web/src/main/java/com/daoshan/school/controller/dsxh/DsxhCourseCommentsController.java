package com.daoshan.school.controller.dsxh;


import com.alibaba.fastjson.JSON;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhCourseComments;
import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.service.dsxh.DsxhCourseCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dsxh/comments")
public class DsxhCourseCommentsController {

    @Autowired
    private DsxhCourseCommentsService dsxhCourseCommentsService;

    @PostMapping("/addComments")
    public MessageBody getAddComments(@RequestBody DsxhCourseComments dsxhCourseComments){

        Map<String,Object> map = new HashMap<String,Object>();
        int result = dsxhCourseCommentsService.addDsxhCourseComments(dsxhCourseComments);


        if(dsxhCourseComments.getParentId() != null){
            String parentId = dsxhCourseComments.getParentId();
            DsxhCourseComments comments = new DsxhCourseComments();
            comments.setParentId(parentId);
            List<DsxhCourseComments> list = dsxhCourseCommentsService.getCourseCommentsByParentId(comments);
            map.put("data2",list);
        }
        if(result > 0){
            map.put("status","success");
        }else {
            map.put("status","failure");
        }
        map.put("data",dsxhCourseComments);
        return MessageBody.getMessageBody(true,map);
    }

    @PostMapping("/updateComments")
    public MessageBody updateComments(@RequestBody DsxhCourseComments dsxhCourseComments){

        Map<String,Object> map = new HashMap<String,Object>();
        int result = dsxhCourseCommentsService.updateComments(dsxhCourseComments);
        if(result > 0){
            map.put("status","success");
        }else {
            map.put("status","failure");
        }
        map.put("data",dsxhCourseComments);
        return MessageBody.getMessageBody(true,map);
    }
}
