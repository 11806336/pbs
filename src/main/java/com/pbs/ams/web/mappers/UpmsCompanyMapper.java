package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基金公司mapper
 */
public interface UpmsCompanyMapper {

    /**
     * 根据id删除批量公司
     * @param ids 公司id
     * @return
     */
    int deleteCompany(List<Long> ids);

    /**
     * 根据id删除公司
     * @param id 公司id
     * @return
     */
    int deleteCompanyById(long id);

    /**
     * 新增公司
     * @param company 公司实体
     * @return
     */
    int insertCompany(UpmsCompany company);

    /**
     * 根据id查询单条记录
     * @param id 公司id
     * @return
     */
    UpmsCompany getCompany(Long id);

    /**
     *更新公司
     * @param company
     * @return
     */
    int updateCompany(UpmsCompany company);

    /**
     * 根据条件获取公司列表
     * @return
     */
    List<UpmsCompany> listCompanies(Map<String, Object> params);

    /**
     * 向快照表中插入数据
     * @return
     */
    int insertSnapshot(UpmsCompanySnapshot snapshot);

    /**
     * 根据条件获取公司总数
     * @param params
     * @return
     */
    int countCompany(Map<String, Object> params);

    /**
     * select company permissions for current users
     * @param userId
     * @return List<UpmsCompany>
     * @author TiAmo.
     */
    List<UpmsCompany> selectCompanyByUserId(Long userId);
}