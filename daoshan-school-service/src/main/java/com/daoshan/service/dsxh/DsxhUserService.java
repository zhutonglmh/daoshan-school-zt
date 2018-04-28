package com.daoshan.service.dsxh;

import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhUser;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface DsxhUserService {

    public String sessionDemo();


    /*-------------------------------------------------------------------------------------------------------*/
    //以上代码仅供测试框架使用      正式环境可以删除
    /*--------------------------------------------------------------------------------------------------------*/

    /**
     * 新增
     * @param dsxhUser
     * @return
     */
    String insertUser(DsxhUser dsxhUser);

    /**
     * 修改
     * @param dsxhUser
     * @return
     */
    String updateUser(DsxhUser dsxhUser);

    /**
     * 删除
     * @param dsxhUser
     * @return
     */
    String deleteUser(DsxhUser dsxhUser);

    /**
     * 精确查询
     * @param dsxhUser
     * @return
     */
    DsxhUser queryUser(DsxhUser dsxhUser);


    /**
     * 条件查询
     * @param dsxhUser
     * @return
     */
    List<DsxhUser> queryUserList(DsxhUser dsxhUser);

    /**
     * 分页查询
     * @param page
     * @param dsxhUser
     * @return
     */
    public Page<DsxhUser> findDataForPage(Page<DsxhUser> page, DsxhUser dsxhUser);


    /**
     * 校验用户登录
     * @param dsxhUser
     * @return
     */
    HashMap<String,Object> userLogin(DsxhUser dsxhUser);

    /**
     * 用户登出
     * @return
     */
    String userLoginOut();

    /**
     * 获取当前session
     * @return
     */
    HttpSession getSession();

    /**
     * 获取当前登录用户信息
     * @return
     */
    DsxhUser getUserInfo();


    /**
     * 修改用户信息
     * @param dsxhUser
     * @return
     */
    int updateUserInfo(DsxhUser dsxhUser);

}
