package com.daoshan.service.dsxh;

import com.baomidou.mybatisplus.plugins.Page;
import com.daoshan.bean.dsxh.entity.DsxhUser;

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
}
