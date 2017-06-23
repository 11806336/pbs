package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.UpmsCompanyMapper;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyExample;
import com.pbs.ams.web.model.UpmsCompanySnaps;
import com.pbs.ams.web.service.UpmsCompanyService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
* UpmsCompanyService实现
* Created by ams on 2017/6/20.
*/
@Service
@Transactional
@BaseService
public class UpmsCompanyServiceImpl extends BaseServiceImpl<UpmsCompany, UpmsCompanyExample> implements UpmsCompanyService {

    private static Logger _log = LoggerFactory.getLogger(UpmsCompanyServiceImpl.class);

    @Autowired
    private UpmsCompanyMapper upmsCompanyMapper;

    @Override
    public Object getMapper() { return upmsCompanyMapper; }

    /**
     * 删除操作
     * @param ids 主键id
     * @return
     */
    @Override
    public int deleteByPrimaryKeys(String ids) {
        try {
            if (StringUtils.isBlank(ids)) {
                return 0;
            }
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            String[] idArray = ids.split("-");
            int count = 0;
            for (String idStr : idArray) {
                if (StringUtils.isBlank(idStr)) {
                    continue;
                }
                Integer id = Integer.parseInt(idStr);
                //先查询本条记录
                Method selectByPrimaryKey =  getMapper().getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
                UpmsCompany upmsCompany = (UpmsCompany) selectByPrimaryKey.invoke( getMapper(), id);
                //将本条记录放在快照表中
                if (upmsCompany != null) {//查到数据后再做新增和删除操作
                    UpmsCompanySnaps snaps = new UpmsCompanySnaps();
                    PropertyUtils.copyProperties(snaps, upmsCompany);
                    snaps.setSnapsTime(System.currentTimeMillis());
//                    Method insertSelective =  getMapper().getClass().getDeclaredMethod("insertSelective", snaps.getClass());
//                    Object t = insertSelective.invoke( getMapper(), snaps);
                    int insertResult = upmsCompanyMapper.insertSnapshotSelective(snaps);
                    if (insertResult == 0) {
                        new RuntimeException();
                    }
                    Method deleteByPrimaryKey =  getMapper().getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
                    Object result = deleteByPrimaryKey.invoke( getMapper(), id);
                    count += Integer.parseInt(String.valueOf(result));
                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    /**
     * 修改公司
     * @param upmsCompany
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(UpmsCompany upmsCompany) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            int result = 0;
            //先查询本条记录
            Integer id = upmsCompany.getCompanyId();
            Method selectByPrimaryKey =  getMapper().getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
            UpmsCompany companyOld = (UpmsCompany) selectByPrimaryKey.invoke( getMapper(), id);
            //将本条记录放在快照表中
            if (companyOld != null) {//查到数据后再做新增和删除操作
                UpmsCompanySnaps snaps = new UpmsCompanySnaps();
                PropertyUtils.copyProperties(snaps, companyOld);
                snaps.setSnapsTime(System.currentTimeMillis());
                int insertResult = upmsCompanyMapper.insertSnapshotSelective(snaps);
                if (insertResult == 0) {
                    new RuntimeException();
                }
//                Method updateByPrimaryKeySelective =  getMapper().getClass().getDeclaredMethod("updateByPrimaryKeySelective", upmsCompany.getClass());
//                result = Integer.parseInt(String.valueOf(updateByPrimaryKeySelective.invoke( getMapper(), upmsCompany)));
                result = upmsCompanyMapper.updateByPrimaryKeySelective(upmsCompany);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }
}