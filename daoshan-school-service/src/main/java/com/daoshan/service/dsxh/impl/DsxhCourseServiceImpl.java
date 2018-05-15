package com.daoshan.service.dsxh.impl;

import com.daoshan.bean.dsxh.entity.*;
import com.daoshan.dao.dsxh.DsxhCourseChildMapper;
import com.daoshan.dao.dsxh.DsxhCourseDetailMapper;
import com.daoshan.dao.dsxh.DsxhCourseMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhCourseCommentsService;
import com.daoshan.service.dsxh.DsxhCourseService;
import com.daoshan.service.dsxh.DsxhOrderService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DsxhCourseServiceImpl implements DsxhCourseService{


    @Resource
    private DsxhCourseChildMapper dsxhCourseChildMapper;

    @Resource
    private DsxhCourseDetailMapper dsxhCourseDetailMapper;

    @Resource
    private DsxhCourseMapper dsxhCourseMapper;

    @Autowired
    private DsxhOrderService dsxhOrderService;

    @Autowired
    private DsxhCourseCommentsService dsxhCourseCommentsService;

    @Autowired
    private DsxhUserService dsxhUserService;
    /**
     * 获取课程信息
     * @param dsxhCourse
     * @return
     * @throws Exception
     */
    public DsxhCourse getCourseInfo(DsxhCourse dsxhCourse) throws Exception{

        if(!AirUtils.hv(dsxhCourse) || !AirUtils.hv(dsxhCourse.getId())){
            return null;
        }
        //查询
        DsxhCourse dsxhCourse1 = dsxhCourseMapper.selectOne(dsxhCourse);
        if(!AirUtils.hv(dsxhCourse1)){
            return null;
        }
        Double price = dsxhCourse1.getCoursePrice();
        dsxhCourse1.setCoursePrice(price);
        DsxhCourseDetail dsxhCourseDetail = new DsxhCourseDetail();
        dsxhCourseDetail.setCourseId(dsxhCourse.getId());
        DsxhCourseDetail dsxhCourseDetail1 = dsxhCourseDetailMapper.selectOne(dsxhCourseDetail);
        DsxhCourseChild dsxhCourseChild = new DsxhCourseChild();
        dsxhCourseChild.setCourseId(dsxhCourse.getId());
        //Wrapper<DsxhCourseChild> dsxhCourseChildWrapper = new EntityWrapper<>(dsxhCourseChild);
        List<DsxhCourseChild> dsxhCourseChildren = dsxhCourseChildMapper.getChildren(dsxhCourseChild);
        dsxhCourse1.setVedioAddress(dsxhCourseChildren.get(0).getAddress());
        DsxhCourseComments dsxhCourseComments = new DsxhCourseComments();
        dsxhCourseComments.setCourseId(dsxhCourse.getId());
        List<DsxhCourseComments> commentsList = dsxhCourseCommentsService.getCourseComments(dsxhCourseComments);
        dsxhCourse1.setCommentsList(commentsList);
        dsxhCourse1.setDsxhCourseDetail(dsxhCourseDetail1);
        dsxhCourse1.setDsxhCourseChildren(dsxhCourseChildren);

        DsxhOrder dsxhOrder = new DsxhOrder();
        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        dsxhOrder.setCreateUser(dsxhUser.getId());
        dsxhOrder.setCourseId(dsxhCourse.getId());
        //TODO 查看当前用户是否购买
        int flag = dsxhOrderService.getUsedOrder(dsxhOrder);
        dsxhCourse1.setIsBuy(flag);
        return dsxhCourse1;
    }

    @Override
    public DsxhCourse addCourse(DsxhCourse dsxhCourse) {
        String id =UUIDUtils.getUUID();
        dsxhCourse.setId(id);
        Date date = new Date();
        dsxhCourse.setCreateUser("朱同");
        dsxhCourse.setCreateTime(date);
        dsxhCourseMapper.insert(dsxhCourse);

        DsxhCourseDetail dsxhCourseDetail = new DsxhCourseDetail();
        dsxhCourseDetail.setCourseId(id);
        dsxhCourseDetail.setId(UUIDUtils.getUUID());
        dsxhCourseDetail.setCreateUser("朱同");
        dsxhCourseDetail.setCreateTime(date);
        dsxhCourseDetail.setCourseMessage(dsxhCourse.getCourseMessage());
        dsxhCourseDetailMapper.insert(dsxhCourseDetail);

        List<DsxhCourseChild> list = dsxhCourse.getDsxhCourseChildren();
        for(DsxhCourseChild dsxhCourseChild : list){
            dsxhCourseChild.setCourseId(id);
            dsxhCourseChild.setCourseName(dsxhCourse.getCourseName());
            dsxhCourseChild.setId(UUIDUtils.getUUID());
            dsxhCourseChild.setCreateTime(date);
            dsxhCourseChild.setCreateUser("朱同");
            dsxhCourseChildMapper.insert(dsxhCourseChild);
        }
        return dsxhCourse;
    }

    /**
     * 条件搜索
     *
     * @param dsxhCourse
     * @return
     */
    @Override
    public List<DsxhCourse> courseSearch(DsxhCourse dsxhCourse) {

        return dsxhCourseMapper.courseSearch(dsxhCourse);
    }

}
