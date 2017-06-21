package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmsStockHoldingExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsStockHoldingExample() {
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

        public Criteria andStockHoldingIdIsNull() {
            addCriterion("stock_holding_id is null");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdIsNotNull() {
            addCriterion("stock_holding_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdEqualTo(Integer value) {
            addCriterion("stock_holding_id =", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdNotEqualTo(Integer value) {
            addCriterion("stock_holding_id <>", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdGreaterThan(Integer value) {
            addCriterion("stock_holding_id >", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_holding_id >=", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdLessThan(Integer value) {
            addCriterion("stock_holding_id <", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdLessThanOrEqualTo(Integer value) {
            addCriterion("stock_holding_id <=", value, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdIn(List<Integer> values) {
            addCriterion("stock_holding_id in", values, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdNotIn(List<Integer> values) {
            addCriterion("stock_holding_id not in", values, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdBetween(Integer value1, Integer value2) {
            addCriterion("stock_holding_id between", value1, value2, "stockHoldingId");
            return (Criteria) this;
        }

        public Criteria andStockHoldingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_holding_id not between", value1, value2, "stockHoldingId");
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

        public Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdEqualTo(Integer value) {
            addCriterion("broker_id =", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotEqualTo(Integer value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThan(Integer value) {
            addCriterion("broker_id >", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThan(Integer value) {
            addCriterion("broker_id <", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThanOrEqualTo(Integer value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIn(List<Integer> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotIn(List<Integer> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdBetween(Integer value1, Integer value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (Criteria) this;
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

        public Criteria andMarketIdIsNull() {
            addCriterion("market_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketIdIsNotNull() {
            addCriterion("market_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketIdEqualTo(Integer value) {
            addCriterion("market_id =", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotEqualTo(Integer value) {
            addCriterion("market_id <>", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThan(Integer value) {
            addCriterion("market_id >", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("market_id >=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThan(Integer value) {
            addCriterion("market_id <", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Integer value) {
            addCriterion("market_id <=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdIn(List<Integer> values) {
            addCriterion("market_id in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotIn(List<Integer> values) {
            addCriterion("market_id not in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdBetween(Integer value1, Integer value2) {
            addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNull() {
            addCriterion("stock_id is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(Integer value) {
            addCriterion("stock_id =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(Integer value) {
            addCriterion("stock_id <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(Integer value) {
            addCriterion("stock_id >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_id >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(Integer value) {
            addCriterion("stock_id <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(Integer value) {
            addCriterion("stock_id <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Integer> values) {
            addCriterion("stock_id in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Integer> values) {
            addCriterion("stock_id not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(Integer value1, Integer value2) {
            addCriterion("stock_id between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_id not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIsNull() {
            addCriterion("market_code is null");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIsNotNull() {
            addCriterion("market_code is not null");
            return (Criteria) this;
        }

        public Criteria andMarketCodeEqualTo(String value) {
            addCriterion("market_code =", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotEqualTo(String value) {
            addCriterion("market_code <>", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeGreaterThan(String value) {
            addCriterion("market_code >", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("market_code >=", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLessThan(String value) {
            addCriterion("market_code <", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLessThanOrEqualTo(String value) {
            addCriterion("market_code <=", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeLike(String value) {
            addCriterion("market_code like", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotLike(String value) {
            addCriterion("market_code not like", value, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeIn(List<String> values) {
            addCriterion("market_code in", values, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotIn(List<String> values) {
            addCriterion("market_code not in", values, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeBetween(String value1, String value2) {
            addCriterion("market_code between", value1, value2, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketCodeNotBetween(String value1, String value2) {
            addCriterion("market_code not between", value1, value2, "marketCode");
            return (Criteria) this;
        }

        public Criteria andMarketNameIsNull() {
            addCriterion("market_name is null");
            return (Criteria) this;
        }

        public Criteria andMarketNameIsNotNull() {
            addCriterion("market_name is not null");
            return (Criteria) this;
        }

        public Criteria andMarketNameEqualTo(String value) {
            addCriterion("market_name =", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            addCriterion("market_name <>", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameGreaterThan(String value) {
            addCriterion("market_name >", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            addCriterion("market_name >=", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameLessThan(String value) {
            addCriterion("market_name <", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            addCriterion("market_name <=", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameLike(String value) {
            addCriterion("market_name like", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameNotLike(String value) {
            addCriterion("market_name not like", value, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameIn(List<String> values) {
            addCriterion("market_name in", values, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            addCriterion("market_name not in", values, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            addCriterion("market_name between", value1, value2, "marketName");
            return (Criteria) this;
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            addCriterion("market_name not between", value1, value2, "marketName");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNull() {
            addCriterion("stock_name is null");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNotNull() {
            addCriterion("stock_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameEqualTo(String value) {
            addCriterion("stock_name =", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotEqualTo(String value) {
            addCriterion("stock_name <>", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThan(String value) {
            addCriterion("stock_name >", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name >=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThan(String value) {
            addCriterion("stock_name <", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThanOrEqualTo(String value) {
            addCriterion("stock_name <=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLike(String value) {
            addCriterion("stock_name like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotLike(String value) {
            addCriterion("stock_name not like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameIn(List<String> values) {
            addCriterion("stock_name in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotIn(List<String> values) {
            addCriterion("stock_name not in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameBetween(String value1, String value2) {
            addCriterion("stock_name between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotBetween(String value1, String value2) {
            addCriterion("stock_name not between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingIsNull() {
            addCriterion("current_stock_holding is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingIsNotNull() {
            addCriterion("current_stock_holding is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingEqualTo(Integer value) {
            addCriterion("current_stock_holding =", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingNotEqualTo(Integer value) {
            addCriterion("current_stock_holding <>", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingGreaterThan(Integer value) {
            addCriterion("current_stock_holding >", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_stock_holding >=", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingLessThan(Integer value) {
            addCriterion("current_stock_holding <", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingLessThanOrEqualTo(Integer value) {
            addCriterion("current_stock_holding <=", value, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingIn(List<Integer> values) {
            addCriterion("current_stock_holding in", values, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingNotIn(List<Integer> values) {
            addCriterion("current_stock_holding not in", values, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingBetween(Integer value1, Integer value2) {
            addCriterion("current_stock_holding between", value1, value2, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andCurrentStockHoldingNotBetween(Integer value1, Integer value2) {
            addCriterion("current_stock_holding not between", value1, value2, "currentStockHolding");
            return (Criteria) this;
        }

        public Criteria andPositionDateIsNull() {
            addCriterion("position_date is null");
            return (Criteria) this;
        }

        public Criteria andPositionDateIsNotNull() {
            addCriterion("position_date is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDateEqualTo(Long value) {
            addCriterion("position_date =", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotEqualTo(Long value) {
            addCriterion("position_date <>", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateGreaterThan(Long value) {
            addCriterion("position_date >", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateGreaterThanOrEqualTo(Long value) {
            addCriterion("position_date >=", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateLessThan(Long value) {
            addCriterion("position_date <", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateLessThanOrEqualTo(Long value) {
            addCriterion("position_date <=", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateIn(List<Long> values) {
            addCriterion("position_date in", values, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotIn(List<Long> values) {
            addCriterion("position_date not in", values, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateBetween(Long value1, Long value2) {
            addCriterion("position_date between", value1, value2, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotBetween(Long value1, Long value2) {
            addCriterion("position_date not between", value1, value2, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionCostIsNull() {
            addCriterion("position_cost is null");
            return (Criteria) this;
        }

        public Criteria andPositionCostIsNotNull() {
            addCriterion("position_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCostEqualTo(BigDecimal value) {
            addCriterion("position_cost =", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostNotEqualTo(BigDecimal value) {
            addCriterion("position_cost <>", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostGreaterThan(BigDecimal value) {
            addCriterion("position_cost >", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("position_cost >=", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostLessThan(BigDecimal value) {
            addCriterion("position_cost <", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("position_cost <=", value, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostIn(List<BigDecimal> values) {
            addCriterion("position_cost in", values, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostNotIn(List<BigDecimal> values) {
            addCriterion("position_cost not in", values, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_cost between", value1, value2, "positionCost");
            return (Criteria) this;
        }

        public Criteria andPositionCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_cost not between", value1, value2, "positionCost");
            return (Criteria) this;
        }

        public Criteria andCostValueIsNull() {
            addCriterion("cost_value is null");
            return (Criteria) this;
        }

        public Criteria andCostValueIsNotNull() {
            addCriterion("cost_value is not null");
            return (Criteria) this;
        }

        public Criteria andCostValueEqualTo(BigDecimal value) {
            addCriterion("cost_value =", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueNotEqualTo(BigDecimal value) {
            addCriterion("cost_value <>", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueGreaterThan(BigDecimal value) {
            addCriterion("cost_value >", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_value >=", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueLessThan(BigDecimal value) {
            addCriterion("cost_value <", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_value <=", value, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueIn(List<BigDecimal> values) {
            addCriterion("cost_value in", values, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueNotIn(List<BigDecimal> values) {
            addCriterion("cost_value not in", values, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_value between", value1, value2, "costValue");
            return (Criteria) this;
        }

        public Criteria andCostValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_value not between", value1, value2, "costValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueIsNull() {
            addCriterion("single_cost_value is null");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueIsNotNull() {
            addCriterion("single_cost_value is not null");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueEqualTo(BigDecimal value) {
            addCriterion("single_cost_value =", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueNotEqualTo(BigDecimal value) {
            addCriterion("single_cost_value <>", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueGreaterThan(BigDecimal value) {
            addCriterion("single_cost_value >", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("single_cost_value >=", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueLessThan(BigDecimal value) {
            addCriterion("single_cost_value <", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("single_cost_value <=", value, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueIn(List<BigDecimal> values) {
            addCriterion("single_cost_value in", values, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueNotIn(List<BigDecimal> values) {
            addCriterion("single_cost_value not in", values, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_cost_value between", value1, value2, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andSingleCostValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_cost_value not between", value1, value2, "singleCostValue");
            return (Criteria) this;
        }

        public Criteria andProfitLossIsNull() {
            addCriterion("profit_loss is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossIsNotNull() {
            addCriterion("profit_loss is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossEqualTo(String value) {
            addCriterion("profit_loss =", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossNotEqualTo(String value) {
            addCriterion("profit_loss <>", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossGreaterThan(String value) {
            addCriterion("profit_loss >", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossGreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss >=", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossLessThan(String value) {
            addCriterion("profit_loss <", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossLessThanOrEqualTo(String value) {
            addCriterion("profit_loss <=", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossLike(String value) {
            addCriterion("profit_loss like", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossNotLike(String value) {
            addCriterion("profit_loss not like", value, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossIn(List<String> values) {
            addCriterion("profit_loss in", values, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossNotIn(List<String> values) {
            addCriterion("profit_loss not in", values, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossBetween(String value1, String value2) {
            addCriterion("profit_loss between", value1, value2, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andProfitLossNotBetween(String value1, String value2) {
            addCriterion("profit_loss not between", value1, value2, "profitLoss");
            return (Criteria) this;
        }

        public Criteria andMarketValueIsNull() {
            addCriterion("market_value is null");
            return (Criteria) this;
        }

        public Criteria andMarketValueIsNotNull() {
            addCriterion("market_value is not null");
            return (Criteria) this;
        }

        public Criteria andMarketValueEqualTo(BigDecimal value) {
            addCriterion("market_value =", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueNotEqualTo(BigDecimal value) {
            addCriterion("market_value <>", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueGreaterThan(BigDecimal value) {
            addCriterion("market_value >", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_value >=", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueLessThan(BigDecimal value) {
            addCriterion("market_value <", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_value <=", value, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueIn(List<BigDecimal> values) {
            addCriterion("market_value in", values, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueNotIn(List<BigDecimal> values) {
            addCriterion("market_value not in", values, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_value between", value1, value2, "marketValue");
            return (Criteria) this;
        }

        public Criteria andMarketValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_value not between", value1, value2, "marketValue");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountIsNull() {
            addCriterion("stockholder_account is null");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountIsNotNull() {
            addCriterion("stockholder_account is not null");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountEqualTo(String value) {
            addCriterion("stockholder_account =", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountNotEqualTo(String value) {
            addCriterion("stockholder_account <>", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountGreaterThan(String value) {
            addCriterion("stockholder_account >", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountGreaterThanOrEqualTo(String value) {
            addCriterion("stockholder_account >=", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountLessThan(String value) {
            addCriterion("stockholder_account <", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountLessThanOrEqualTo(String value) {
            addCriterion("stockholder_account <=", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountLike(String value) {
            addCriterion("stockholder_account like", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountNotLike(String value) {
            addCriterion("stockholder_account not like", value, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountIn(List<String> values) {
            addCriterion("stockholder_account in", values, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountNotIn(List<String> values) {
            addCriterion("stockholder_account not in", values, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountBetween(String value1, String value2) {
            addCriterion("stockholder_account between", value1, value2, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andStockholderAccountNotBetween(String value1, String value2) {
            addCriterion("stockholder_account not between", value1, value2, "stockholderAccount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIsNull() {
            addCriterion("frozen_amount is null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIsNotNull() {
            addCriterion("frozen_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountEqualTo(Integer value) {
            addCriterion("frozen_amount =", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotEqualTo(Integer value) {
            addCriterion("frozen_amount <>", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThan(Integer value) {
            addCriterion("frozen_amount >", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("frozen_amount >=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThan(Integer value) {
            addCriterion("frozen_amount <", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThanOrEqualTo(Integer value) {
            addCriterion("frozen_amount <=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIn(List<Integer> values) {
            addCriterion("frozen_amount in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotIn(List<Integer> values) {
            addCriterion("frozen_amount not in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountBetween(Integer value1, Integer value2) {
            addCriterion("frozen_amount between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("frozen_amount not between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andRemainingIsNull() {
            addCriterion("remaining is null");
            return (Criteria) this;
        }

        public Criteria andRemainingIsNotNull() {
            addCriterion("remaining is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingEqualTo(BigDecimal value) {
            addCriterion("remaining =", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotEqualTo(BigDecimal value) {
            addCriterion("remaining <>", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingGreaterThan(BigDecimal value) {
            addCriterion("remaining >", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining >=", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingLessThan(BigDecimal value) {
            addCriterion("remaining <", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining <=", value, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingIn(List<BigDecimal> values) {
            addCriterion("remaining in", values, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotIn(List<BigDecimal> values) {
            addCriterion("remaining not in", values, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining between", value1, value2, "remaining");
            return (Criteria) this;
        }

        public Criteria andRemainingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining not between", value1, value2, "remaining");
            return (Criteria) this;
        }

        public Criteria andTransitSharesIsNull() {
            addCriterion("transit_shares is null");
            return (Criteria) this;
        }

        public Criteria andTransitSharesIsNotNull() {
            addCriterion("transit_shares is not null");
            return (Criteria) this;
        }

        public Criteria andTransitSharesEqualTo(Integer value) {
            addCriterion("transit_shares =", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesNotEqualTo(Integer value) {
            addCriterion("transit_shares <>", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesGreaterThan(Integer value) {
            addCriterion("transit_shares >", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesGreaterThanOrEqualTo(Integer value) {
            addCriterion("transit_shares >=", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesLessThan(Integer value) {
            addCriterion("transit_shares <", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesLessThanOrEqualTo(Integer value) {
            addCriterion("transit_shares <=", value, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesIn(List<Integer> values) {
            addCriterion("transit_shares in", values, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesNotIn(List<Integer> values) {
            addCriterion("transit_shares not in", values, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesBetween(Integer value1, Integer value2) {
            addCriterion("transit_shares between", value1, value2, "transitShares");
            return (Criteria) this;
        }

        public Criteria andTransitSharesNotBetween(Integer value1, Integer value2) {
            addCriterion("transit_shares not between", value1, value2, "transitShares");
            return (Criteria) this;
        }

        public Criteria andShareRemainingIsNull() {
            addCriterion("share_remaining is null");
            return (Criteria) this;
        }

        public Criteria andShareRemainingIsNotNull() {
            addCriterion("share_remaining is not null");
            return (Criteria) this;
        }

        public Criteria andShareRemainingEqualTo(BigDecimal value) {
            addCriterion("share_remaining =", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingNotEqualTo(BigDecimal value) {
            addCriterion("share_remaining <>", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingGreaterThan(BigDecimal value) {
            addCriterion("share_remaining >", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_remaining >=", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingLessThan(BigDecimal value) {
            addCriterion("share_remaining <", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_remaining <=", value, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingIn(List<BigDecimal> values) {
            addCriterion("share_remaining in", values, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingNotIn(List<BigDecimal> values) {
            addCriterion("share_remaining not in", values, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_remaining between", value1, value2, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andShareRemainingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_remaining not between", value1, value2, "shareRemaining");
            return (Criteria) this;
        }

        public Criteria andLatestPriceIsNull() {
            addCriterion("latest_price is null");
            return (Criteria) this;
        }

        public Criteria andLatestPriceIsNotNull() {
            addCriterion("latest_price is not null");
            return (Criteria) this;
        }

        public Criteria andLatestPriceEqualTo(BigDecimal value) {
            addCriterion("latest_price =", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceNotEqualTo(BigDecimal value) {
            addCriterion("latest_price <>", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceGreaterThan(BigDecimal value) {
            addCriterion("latest_price >", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latest_price >=", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceLessThan(BigDecimal value) {
            addCriterion("latest_price <", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latest_price <=", value, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceIn(List<BigDecimal> values) {
            addCriterion("latest_price in", values, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceNotIn(List<BigDecimal> values) {
            addCriterion("latest_price not in", values, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latest_price between", value1, value2, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andLatestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latest_price not between", value1, value2, "latestPrice");
            return (Criteria) this;
        }

        public Criteria andProfitRateIsNull() {
            addCriterion("profit_rate is null");
            return (Criteria) this;
        }

        public Criteria andProfitRateIsNotNull() {
            addCriterion("profit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andProfitRateEqualTo(String value) {
            addCriterion("profit_rate =", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotEqualTo(String value) {
            addCriterion("profit_rate <>", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateGreaterThan(String value) {
            addCriterion("profit_rate >", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateGreaterThanOrEqualTo(String value) {
            addCriterion("profit_rate >=", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateLessThan(String value) {
            addCriterion("profit_rate <", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateLessThanOrEqualTo(String value) {
            addCriterion("profit_rate <=", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateLike(String value) {
            addCriterion("profit_rate like", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotLike(String value) {
            addCriterion("profit_rate not like", value, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateIn(List<String> values) {
            addCriterion("profit_rate in", values, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotIn(List<String> values) {
            addCriterion("profit_rate not in", values, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateBetween(String value1, String value2) {
            addCriterion("profit_rate between", value1, value2, "profitRate");
            return (Criteria) this;
        }

        public Criteria andProfitRateNotBetween(String value1, String value2) {
            addCriterion("profit_rate not between", value1, value2, "profitRate");
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