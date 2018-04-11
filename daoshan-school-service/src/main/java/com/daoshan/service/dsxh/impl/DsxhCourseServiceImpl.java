package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.daoshan.bean.dsxh.entity.DsxhCourse;
import com.daoshan.bean.dsxh.entity.DsxhCourseChild;
import com.daoshan.bean.dsxh.entity.DsxhCourseDetail;
import com.daoshan.dao.dsxh.DsxhCourseChildMapper;
import com.daoshan.dao.dsxh.DsxhCourseDetailMapper;
import com.daoshan.dao.dsxh.DsxhCourseMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.service.dsxh.DsxhCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DsxhCourseServiceImpl implements DsxhCourseService{


    @Resource
    private DsxhCourseChildMapper dsxhCourseChildMapper;

    @Resource
    private DsxhCourseDetailMapper dsxhCourseDetailMapper;

    @Resource
    private DsxhCourseMapper dsxhCourseMapper;
    /**
     * 获取课程信息
     * @param dsxhCourse
     * @return
     * @throws Exception
     */
    public DsxhCourse getCourseInfo(DsxhCourse dsxhCourse){

        if(!AirUtils.hv(dsxhCourse) || !AirUtils.hv(dsxhCourse.getId())){
            return null;
        }
        //查询
        DsxhCourse dsxhCourse1 = dsxhCourseMapper.selectOne(dsxhCourse);
        DsxhCourseDetail dsxhCourseDetail = new DsxhCourseDetail();
        dsxhCourseDetail.setCourseId(dsxhCourse.getId());
        DsxhCourseDetail dsxhCourseDetail1 = dsxhCourseDetailMapper.selectOne(dsxhCourseDetail);
        DsxhCourseChild dsxhCourseChild = new DsxhCourseChild();
        dsxhCourseChild.setCourseId(dsxhCourse.getId());
        Wrapper<DsxhCourseChild> dsxhCourseChildWrapper = new EntityWrapper<>(dsxhCourseChild);
        List<DsxhCourseChild> dsxhCourseChildren = dsxhCourseChildMapper.selectList(dsxhCourseChildWrapper);

        dsxhCourse1.setDsxhCourseDetail(dsxhCourseDetail1);
        dsxhCourse1.setDsxhCourseChildren(dsxhCourseChildren);

        return dsxhCourse1;
    }

}
