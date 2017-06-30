package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsBroker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * AmsBrokerService接口
 * Created by ams on 2017/6/22.
 */
public interface AmsBrokerService{

    int insertToSnaps();

    /**
     *
     * @param amsBroker  新增券商
     * @return
     */
    @Autowired
    public int insertSelective(AmsBroker amsBroker);

    /**
     *
     * @param params  券商列表
     * @return
     */
    @Autowired
    public List<AmsBroker> selectByExample(Map<String, Object> params);


    public AmsBroker selectByPrimaryKey(Long id);

    /**
     *
     * @param amsBroker    券商数量
     * @return
     */
    @Autowired
    public long countByExample(AmsBroker amsBroker);

    /**
     *
     * @param amsBroker    编辑券商
     * @return
     */

    @Autowired
    public int updateByPrimaryKeySelective(AmsBroker amsBroker);


    /**
     *
     * @param ids        删除券商
     * @return
     */
    public int deleteByPrimaryKeys(String ids);

}