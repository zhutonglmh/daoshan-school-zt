package com.daoshan.service.dsxh.impl;

import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhMoney;
import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.dao.dsxh.DsxhUserMapper;
import com.daoshan.school.utils.common.AirUtils;
import com.daoshan.school.utils.constans.ConStants;
import com.daoshan.school.utils.md5.Md5;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.daoshan.service.AliSms.AliSmsUntils;
import com.daoshan.service.dsxh.DsxhMoneyService;
import com.daoshan.service.dsxh.DsxhUserDetailService;
import com.daoshan.service.dsxh.DsxhUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("dsxhUserService")
public class DsxhUserServiceImpl implements DsxhUserService {


    @Resource
    private DsxhUserMapper dsxhUserMapper;

    @Autowired
    private DsxhUserDetailService dsxhUserDetailService;
    @Autowired
    private DsxhMoneyService dsxhMoneyService;

    @Override
    public DsxhUser findUser(DsxhUser dsxhUser) {

        DsxhUser dsxhUser1 = dsxhUserMapper.findUser(dsxhUser);
        if(!AirUtils.hv(dsxhUser1)){
            return null;
        }
        dsxhUser1 = dsxhUserDetailService.getDsxhUserById(dsxhUser1);
        if(AirUtils.hv(dsxhUser1.getDsxhUserDetail())){

            String iphone = dsxhUser1.getDsxhUserDetail().getUserIphone();
            if(AirUtils.hv(iphone)){
                int card = AirUtils.card();
                try {
                    String result = AliSmsUntils.sms(iphone, String.valueOf(card));
                    if ("success".equals(result)) {
                        HttpSession session = this.getSession();
                        session.setAttribute(iphone, card);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                }
            }
        }
        return dsxhUser1;
    }

    /**
     * 新增
     *
     * @param dsxhUser
     * @return
     */
    @Override
    @Transactional
    public String insertUser(DsxhUser dsxhUser) {

        //MD5加密
        String password = dsxhUser.getPwd();
        dsxhUser.setPwd(Md5.getMd5ByParams(password));
        //获取uuid
        String userId = UUIDUtils.getUUID();
        dsxhUser.setId(userId);
        //获取当前用户
        //dsxhUser.setCreateUser(sessionDemo());
        //获取当前时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        dsxhUser.setCreateTime(timestamp);
        int insertResult = dsxhUserMapper.insert(dsxhUser);
        String result = insertResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;
        if (insertResult > 0) {
            HttpSession session = getSession();
            session.setAttribute("id", dsxhUser.getId());
        }
        //增加消费信息
        DsxhMoney dsxhMoney = new DsxhMoney();
        dsxhMoney.setId(UUIDUtils.getUUID());
        dsxhMoney.setType(2);
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String reTime = format.format(new Date());
        String billNo = "GM" + reTime;
        dsxhMoney.setBillNo(billNo);
        dsxhMoney.setCause("系统赠送");
        dsxhMoney.setMoney(10000.00);
        dsxhMoneyService.add(dsxhMoney);
        return result;
    }

    @Override
    public String checkUser(DsxhUser dsxhUser) {

        Wrapper<DsxhUser> wrapper = new EntityWrapper<>(dsxhUser);
        List<DsxhUser> list = dsxhUserMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)){
            return ConStants.DSXH_SUCCESS;
        }
        return ConStants.DSXH_FAILUER;
    }

    /**
     * 修改
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public String updateUser(DsxhUser dsxhUser) {

        if (null != dsxhUser.getPwd()) {
            //MD5加密
            String password = dsxhUser.getPwd();
            dsxhUser.setPwd(Md5.getMd5ByParams(password));
        } else {
            return ConStants.DSXH_FAILUER;
        }
        //获取当前用户
        //dsxhUser.setCreateUser(sessionDemo());
        //获取当前时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        dsxhUser.setUpdateTime(timestamp);

        int updateResult = dsxhUserMapper.updateById(dsxhUser);


        String result = updateResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;

        return result;
    }


    /**
     * 删除
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public String deleteUser(DsxhUser dsxhUser) {

        int deleteResult = dsxhUserMapper.deleteById(dsxhUser);

        String result = deleteResult > 0 ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;

        return result;
    }

    /**
     * 精确查询
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public DsxhUser queryUser(DsxhUser dsxhUser) {

        dsxhUser = dsxhUserMapper.selectById(dsxhUser);

        return dsxhUser;
    }

    /**
     * 条件查询
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public List<DsxhUser> queryUserList(DsxhUser dsxhUser) {

        return dsxhUserMapper.selectList2(dsxhUser);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param dsxhUser
     * @return
     */
    public Page<DsxhUser> findDataForPage(Page<DsxhUser> page, DsxhUser dsxhUser) {

        List<DsxhUser> list = dsxhUserMapper.selectByZt(page, dsxhUser);
        page.setRecords(list);
        return page;
    }

    /**
     * 校验用户登录
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public HashMap<String, Object> userLogin(DsxhUser dsxhUser) {

        HashMap map = new HashMap();
        String name = dsxhUser.getName();
        String password = dsxhUser.getPwd();
        if (null != dsxhUser.getName() && null != dsxhUser.getPwd() && !"".equals(name) && !"".equals(password)) {

            DsxhUser user = new DsxhUser();
            user.setName(dsxhUser.getName());
            List<DsxhUser> list = this.queryUserList(user);

            if (CollectionUtils.isEmpty(list)) {
                map.put("result", ConStants.DSXH_FAILUER);
                return map;
            }
            DsxhUser dsxhUser1 = list.get(0);
            if (null != dsxhUser1) {
                String passwordMd5 = Md5.getMd5ByParams(password);
                String result = passwordMd5.equals(dsxhUser1.getPwd()) ? ConStants.DSXH_SUCCESS : ConStants.DSXH_FAILUER;
                //放置session
                if (ConStants.DSXH_SUCCESS.equals(result)) {
                    HttpSession session = getSession();
                    session.setAttribute("id", dsxhUser1.getId());
                }
                map.put("result", result);
                map.put("data", dsxhUser1);
                return map;
            } else {
                map.put("result", ConStants.DSXH_FAILUER);
                return map;
            }
        } else {
            map.put("result", ConStants.DSXH_FAILUER);
            return map;
        }
    }

    /**
     * 用户登出
     *
     * @return
     */
    @Override
    public String userLoginOut() {

        HttpSession session = getSession();
        session.removeAttribute("id");
        return ConStants.DSXH_SUCCESS;
    }

    /**
     * 获取当前进程session
     *
     * @return
     */
    @Override
    public HttpSession getSession() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        return session;
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @Override
    public DsxhUser getUserInfo() {

        DsxhUser dsxhUser = null;
        HttpSession session = getSession();
        Object id = session.getAttribute("id");
        if (!"".equals(id) && null != id) {
            String userId = id.toString();
            dsxhUser = dsxhUserMapper.selectById(userId);
        }
        return dsxhUser;
    }

    /**
     * 修改用户信息
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public int updateUserInfo(DsxhUser dsxhUser) throws Exception {
        return dsxhUserMapper.updateByUser(dsxhUser);
    }

    /**
     * 修改用户信息
     *
     * @param dsxhUser
     * @return
     */
    @Override
    public int updateUser2(DsxhUser dsxhUser) throws Exception {
        return dsxhUserMapper.updateMoneyByUser(dsxhUser);
    }

    @Override
    public String updateUser3(DsxhUser dsxhUser) {

        String pwd = Md5.getMd5ByParams(dsxhUser.getPwd());
        dsxhUser.setPwd(pwd);
        if( dsxhUserMapper.updateMoneyByUser2(dsxhUser) > 0){
            return "success";
        }
        return "false";
    }

}
