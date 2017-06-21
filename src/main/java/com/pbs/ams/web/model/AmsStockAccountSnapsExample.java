package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AmsStockAccountSnapsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsStockAccountSnapsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStockAccountIdIsNull() {
            addCriterion("stock_account_id is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdIsNotNull() {
            addCriterion("stock_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdEqualTo(Integer value) {
            addCriterion("stock_account_id =", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdNotEqualTo(Integer value) {
            addCriterion("stock_account_id <>", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdGreaterThan(Integer value) {
            addCriterion("stock_account_id >", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_account_id >=", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdLessThan(Integer value) {
            addCriterion("stock_account_id <", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("stock_account_id <=", value, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdIn(List<Integer> values) {
            addCriterion("stock_account_id in", values, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdNotIn(List<Integer> values) {
            addCriterion("stock_account_id not in", values, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("stock_account_id between", value1, value2, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andStockAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_account_id not between", value1, value2, "stockAccountId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeIsNull() {
            addCriterion("stock_account_type is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeIsNotNull() {
            addCriterion("stock_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeEqualTo(Integer value) {
            addCriterion("stock_account_type =", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeNotEqualTo(Integer value) {
            addCriterion("stock_account_type <>", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeGreaterThan(Integer value) {
            addCriterion("stock_account_type >", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_account_type >=", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeLessThan(Integer value) {
            addCriterion("stock_account_type <", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stock_account_type <=", value, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeIn(List<Integer> values) {
            addCriterion("stock_account_type in", values, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeNotIn(List<Integer> values) {
            addCriterion("stock_account_type not in", values, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("stock_account_type between", value1, value2, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_account_type not between", value1, value2, "stockAccountType");
            return (Criteria) this;
        }

        public Criteria andStockAccountIsNull() {
            addCriterion("stock_account is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountIsNotNull() {
            addCriterion("stock_account is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountEqualTo(Integer value) {
            addCriterion("stock_account =", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountNotEqualTo(Integer value) {
            addCriterion("stock_account <>", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountGreaterThan(Integer value) {
            addCriterion("stock_account >", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_account >=", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountLessThan(Integer value) {
            addCriterion("stock_account <", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountLessThanOrEqualTo(Integer value) {
            addCriterion("stock_account <=", value, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountIn(List<Integer> values) {
            addCriterion("stock_account in", values, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountNotIn(List<Integer> values) {
            addCriterion("stock_account not in", values, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountBetween(Integer value1, Integer value2) {
            addCriterion("stock_account between", value1, value2, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_account not between", value1, value2, "stockAccount");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameIsNull() {
            addCriterion("stock_account_name is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameIsNotNull() {
            addCriterion("stock_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameEqualTo(String value) {
            addCriterion("stock_account_name =", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameNotEqualTo(String value) {
            addCriterion("stock_account_name <>", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameGreaterThan(String value) {
            addCriterion("stock_account_name >", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_account_name >=", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameLessThan(String value) {
            addCriterion("stock_account_name <", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameLessThanOrEqualTo(String value) {
            addCriterion("stock_account_name <=", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameLike(String value) {
            addCriterion("stock_account_name like", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameNotLike(String value) {
            addCriterion("stock_account_name not like", value, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameIn(List<String> values) {
            addCriterion("stock_account_name in", values, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameNotIn(List<String> values) {
            addCriterion("stock_account_name not in", values, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameBetween(String value1, String value2) {
            addCriterion("stock_account_name between", value1, value2, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountNameNotBetween(String value1, String value2) {
            addCriterion("stock_account_name not between", value1, value2, "stockAccountName");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordIsNull() {
            addCriterion("stock_account_password is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordIsNotNull() {
            addCriterion("stock_account_password is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordEqualTo(String value) {
            addCriterion("stock_account_password =", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordNotEqualTo(String value) {
            addCriterion("stock_account_password <>", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordGreaterThan(String value) {
            addCriterion("stock_account_password >", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("stock_account_password >=", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordLessThan(String value) {
            addCriterion("stock_account_password <", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordLessThanOrEqualTo(String value) {
            addCriterion("stock_account_password <=", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordLike(String value) {
            addCriterion("stock_account_password like", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordNotLike(String value) {
            addCriterion("stock_account_password not like", value, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordIn(List<String> values) {
            addCriterion("stock_account_password in", values, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordNotIn(List<String> values) {
            addCriterion("stock_account_password not in", values, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordBetween(String value1, String value2) {
            addCriterion("stock_account_password between", value1, value2, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andStockAccountPasswordNotBetween(String value1, String value2) {
            addCriterion("stock_account_password not between", value1, value2, "stockAccountPassword");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdEqualTo(String value) {
            addCriterion("broker_id =", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotEqualTo(String value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThan(String value) {
            addCriterion("broker_id >", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThanOrEqualTo(String value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThan(String value) {
            addCriterion("broker_id <", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThanOrEqualTo(String value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLike(String value) {
            addCriterion("broker_id like", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotLike(String value) {
            addCriterion("broker_id not like", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIn(List<String> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotIn(List<String> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdBetween(String value1, String value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotBetween(String value1, String value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusIsNull() {
            addCriterion("stock_account_status is null");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusIsNotNull() {
            addCriterion("stock_account_status is not null");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusEqualTo(String value) {
            addCriterion("stock_account_status =", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusNotEqualTo(String value) {
            addCriterion("stock_account_status <>", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusGreaterThan(String value) {
            addCriterion("stock_account_status >", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("stock_account_status >=", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusLessThan(String value) {
            addCriterion("stock_account_status <", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusLessThanOrEqualTo(String value) {
            addCriterion("stock_account_status <=", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusLike(String value) {
            addCriterion("stock_account_status like", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusNotLike(String value) {
            addCriterion("stock_account_status not like", value, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusIn(List<String> values) {
            addCriterion("stock_account_status in", values, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusNotIn(List<String> values) {
            addCriterion("stock_account_status not in", values, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusBetween(String value1, String value2) {
            addCriterion("stock_account_status between", value1, value2, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andStockAccountStatusNotBetween(String value1, String value2) {
            addCriterion("stock_account_status not between", value1, value2, "stockAccountStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeIsNull() {
            addCriterion("snaps_time is null");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeIsNotNull() {
            addCriterion("snaps_time is not null");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeEqualTo(Long value) {
            addCriterion("snaps_time =", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeNotEqualTo(Long value) {
            addCriterion("snaps_time <>", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeGreaterThan(Long value) {
            addCriterion("snaps_time >", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("snaps_time >=", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeLessThan(Long value) {
            addCriterion("snaps_time <", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeLessThanOrEqualTo(Long value) {
            addCriterion("snaps_time <=", value, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeIn(List<Long> values) {
            addCriterion("snaps_time in", values, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeNotIn(List<Long> values) {
            addCriterion("snaps_time not in", values, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeBetween(Long value1, Long value2) {
            addCriterion("snaps_time between", value1, value2, "snapsTime");
            return (Criteria) this;
        }

        public Criteria andSnapsTimeNotBetween(Long value1, Long value2) {
            addCriterion("snaps_time not between", value1, value2, "snapsTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}