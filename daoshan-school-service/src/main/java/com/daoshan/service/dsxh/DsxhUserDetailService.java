package com.daoshan.service.dsxh;

import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.bean.dsxh.entity.DsxhUserDetail;

public interface DsxhUserDetailService {

    /**
     * 新增
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    String addDsxhUserDetail(DsxhUserDetail dsxhUserDetail) throws Exception;

    /**
     * 删除
     * @param dsxhUserDetail
     * @return
     * @throws Exception
     */
    String delDsxhUserDetail(DsxhUserDetail dsxhUserDetail) throws Exception;


    /**
     * 查看
     * @return
     * @throws Exception
     */
    DsxhUser getUserInfo() throws Exception;
}
