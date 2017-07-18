package com.pbs.ams.common.util;

import com.pbs.ams.web.model.AmsProductUser;
import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.UpmsCompanyUser;
import com.pbs.ams.web.service.impl.AmsProductUserServiceImpl;
import com.pbs.ams.web.service.impl.AmsTradeAccountServiceImpl;
import com.pbs.ams.web.service.impl.UpmsCompanyUserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 检查是否可以删除工具类
 * User : zpf
 * Date : 2017/7/18
 */
public class CheckIsDeleteUtil {

    private static final AmsTradeAccountServiceImpl amsTradeAccountService = SpringContextUtil.getBean("amsTradeAccountServiceImpl", AmsTradeAccountServiceImpl.class);
    private static final UpmsCompanyUserServiceImpl upmsCompanyUserService = SpringContextUtil.getBean("upmsCompanyUserServiceImpl", UpmsCompanyUserServiceImpl.class);
    private static final AmsProductUserServiceImpl amsProductUserService = SpringContextUtil.getBean("amsProductUserServiceImpl", AmsProductUserServiceImpl.class);

    /**
     * according to params estimate this data isdelete.
     * @param params
     * @return
     */
    public static boolean isDelete(Map<String, Long> params){
        boolean flag = true;
        String[] categories = {"companyId", "productId", "accountId"};//匹配传入的参数列表
        if (params != null && params.size() > 0) {
            int count = 0;//计数器，用于判断第几个参数。
            for (String key : categories) {
                count ++;
                Long id = params.get(key);
                if (id != null && count == 1) {//companyId
                    List<Long> ids = new ArrayList<Long>();
                    ids.add(id);
                    List<UpmsCompanyUser> upmsCompanyUsers = upmsCompanyUserService.getUsersByCompanyId(ids);
                    if (upmsCompanyUsers != null && upmsCompanyUsers.size() > 0) {
                        flag = false;
                        break;
                    }
                } else if (id != null && count == 2) {//productId
                    AmsProductUser amsProductUser = new AmsProductUser();
                    amsProductUser.setProductId(id);
                    List<AmsProductUser> amsProductUsers = amsProductUserService.select(amsProductUser);
                    if (amsProductUsers != null && amsProductUsers.size() > 0) {
                        flag = false;
                        break;
                    }
                } else if (id != null && count == 3) {//accountId
                    AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
                    if (amsTradeAccount.getCompanyId() != null) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
