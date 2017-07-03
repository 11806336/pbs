package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.UpmsCompanyMapper;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanySnapshot;
import com.pbs.ams.web.service.UpmsCompanyService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 基金公司服务实现类
* Created by ams on 2017/6/20.
*/
@Service
@Transactional
public class UpmsCompanyServiceImpl implements UpmsCompanyService {

    private static Logger log = LoggerFactory.getLogger(UpmsCompanyServiceImpl.class);

    @Autowired
    private UpmsCompanyMapper upmsCompanyMapper;


    @Override
    public int deleteCompany(List<Long> ids) {
        if (null != ids && ids.size() >0) {
            int count = 0;
            for (long id : ids) {
                //先做查询再去删除原表数据和插入快照
                UpmsCompany company = upmsCompanyMapper.getCompany(id);
                if (company != null) {
                    UpmsCompanySnapshot snapshot = new UpmsCompanySnapshot();
                    try {
                        PropertyUtils.copyProperties(snapshot, company);
                        //向快照表插入数据
                        int snapshotResult = upmsCompanyMapper.insertSnapshot(snapshot);
                        count += upmsCompanyMapper.deleteCompanyById(id);
                    } catch (IllegalAccessException e) {//checkException
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            return count;
        }
        return 0;
    }

    @Override
    public int insertCompany(UpmsCompany company) {
        return upmsCompanyMapper.insertCompany(company);
    }

    @Override
    public UpmsCompany getCompany(Long id) {
        return upmsCompanyMapper.getCompany(id);
    }

    @Override
    public int updateCompany(UpmsCompany company) {
        if (null != company) {
            //先做查询再去更新原表数据和插入快照
            UpmsCompany oldCompany = upmsCompanyMapper.getCompany(company.getCompanyId());
            if (null != oldCompany) {
                UpmsCompanySnapshot snapshot = new UpmsCompanySnapshot();
                try {
                    PropertyUtils.copyProperties(snapshot, oldCompany);
                    //向快照表插入数据
                    int snapshotResult = upmsCompanyMapper.insertSnapshot(snapshot);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        return upmsCompanyMapper.updateCompany(company);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public List<UpmsCompany> listCompanies(Map<String, Object> params) {
        return upmsCompanyMapper.listCompanies(params);
    }

    @Override
    public int insertSnapshot(UpmsCompanySnapshot snapshot) {
        return upmsCompanyMapper.insertSnapshot(snapshot);
    }

    @Override
    public int countCompany(Map<String, Object> params) {
        return upmsCompanyMapper.countCompany(params);
    }

    @Override
    public List<UpmsCompany> selectCompanyByUserId(Long userId) {
        return upmsCompanyMapper.selectCompanyByUserId(userId);
    }
}