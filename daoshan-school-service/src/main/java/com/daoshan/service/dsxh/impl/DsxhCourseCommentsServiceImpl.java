package com.daoshan.service.dsxh.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.daoshan.bean.dsxh.entity.DsxhCourseComments;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhCourseCommentsMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.common.TimeUtils;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.dsxh.DsxhCourseCommentsService;
import com.daoshan.service.dsxh.DsxhUserDetailService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DsxhCourseCommentsServiceImpl implements DsxhCourseCommentsService {

    @Resource
    private DsxhCourseCommentsMapper dsxhCourseCommentsMapper;

    @Autowired
    private DsxhUserService dsxhUserService;

    @Autowired
    private DsxhUserDetailService dsxhUserDetailService;


    /**
     * 获取课程评论
     *
     * @param dsxhCourseComments
     * @return
     */
    @Override
    public List<DsxhCourseComments> getCourseComments(DsxhCourseComments dsxhCourseComments) throws Exception{

        List<DsxhCourseComments> list = dsxhCourseCommentsMapper.selectList2(dsxhCourseComments);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        List<DsxhCourseComments> comments = new ArrayList<>();
        Map<String, List<DsxhCourseComments>> map = new HashMap<>();
        for (DsxhCourseComments dsxhCourseComments1 : list) {
            dsxhCourseComments1.setCreateTimeStr(TimeUtils.timeStamp2Date(dsxhCourseComments1.getCreateTime().getTime()));
            if (AirUtils.hv(dsxhCourseComments1)) {
                String key = dsxhCourseComments1.getParentId();
                DsxhUser dsxhUser1 = new DsxhUser();
                dsxhUser1.setId(dsxhCourseComments1.getCreateUser());
                DsxhUser dsxhUser = dsxhUserDetailService.getDsxhUserById(dsxhUser1);
                if (AirUtils.hv(dsxhUser.getDsxhUserDetail().getHeadImageAddress())){
                    dsxhCourseComments1.setAddress(dsxhUser.getDsxhUserDetail().getHeadImageAddress());
                }else {
                    dsxhCourseComments1.setAddress("head");
                }
                if (AirUtils.hv(key)) {
                    if (map.containsKey(key)) {
                        List<DsxhCourseComments> commentsList = map.get(key);
                        commentsList.add(dsxhCourseComments1);
                    } else {
                        List<DsxhCourseComments> commentsList = new ArrayList<>();
                        commentsList.add(dsxhCourseComments1);
                        map.put(key, commentsList);
                    }
                } else {
                    comments.add(dsxhCourseComments1);
                }
            }
        }

        if (CollectionUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }
        for (DsxhCourseComments courseComments : comments) {

            String key = courseComments.getId();
            List<DsxhCourseComments> commentsList = map.get(key);
            if (!CollectionUtils.isEmpty(commentsList)) {
                courseComments.setCommentsList(commentsList);
            } else {
                courseComments.setCommentsList(new ArrayList<DsxhCourseComments>());
            }
        }
        return comments;
    }

    /**
     * 新增评论
     *
     * @param dsxhCourseComments
     */
    @Override
    @Transactional
    public int addDsxhCourseComments(DsxhCourseComments dsxhCourseComments) {

        DsxhUser dsxhUser = dsxhUserService.getUserInfo();
        dsxhCourseComments.setCreateTime(new Date());
        dsxhCourseComments.setCreateUser(dsxhUser.getId());
        dsxhCourseComments.setCreateUserName(dsxhUser.getUserName());
        dsxhCourseComments.setId(UUIDUtils.getUUID());
        int result = dsxhCourseCommentsMapper.insert(dsxhCourseComments);
        return result;
    }

    /**
     * 修改
     *
     * @param dsxhCourseComments
     * @return
     */
    @Override
    @Transactional
    public int updateComments(DsxhCourseComments dsxhCourseComments) {
        int result = dsxhCourseCommentsMapper.updateById(dsxhCourseComments);
        return result;
    }

    /**
     * 获取某一评论的所有子评论
     *
     * @param dsxhCourseComments
     * @return
     */
    @Override
    public List<DsxhCourseComments> getCourseCommentsByParentId(DsxhCourseComments dsxhCourseComments) {
        Wrapper<DsxhCourseComments> commentsWrapper = new EntityWrapper<>(dsxhCourseComments);
        List<DsxhCourseComments> list = dsxhCourseCommentsMapper.selectList(commentsWrapper);
        for(DsxhCourseComments dsxhCourseComments1 : list){
            DsxhUser dsxhUser1 = new DsxhUser();
            dsxhUser1.setId(dsxhCourseComments1.getCreateUser());
            DsxhUser dsxhUser = dsxhUserDetailService.getDsxhUserById(dsxhUser1);
            if (AirUtils.hv(dsxhUser.getDsxhUserDetail().getHeadImageAddress())){
                dsxhCourseComments1.setAddress(dsxhUser.getDsxhUserDetail().getHeadImageAddress());
            }else {
                dsxhCourseComments1.setAddress("head");
            }
        }
        return list;
    }
}
