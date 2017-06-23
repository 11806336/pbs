package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public class AmsBrokerPlatformExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<AmsBrokerPlatformExample.Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsBrokerPlatformExample() {
        oredCriteria = new ArrayList<AmsBrokerPlatformExample.Criteria>();
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

    public List<AmsBrokerPlatformExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AmsBrokerPlatformExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public AmsBrokerPlatformExample.Criteria or() {
        AmsBrokerPlatformExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AmsBrokerPlatformExample.Criteria createCriteria() {
        AmsBrokerPlatformExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AmsBrokerPlatformExample.Criteria createCriteriaInternal() {
        AmsBrokerPlatformExample.Criteria criteria = new AmsBrokerPlatformExample.Criteria();
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
        protected List<AmsBrokerPlatformExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<AmsBrokerPlatformExample.Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AmsBrokerPlatformExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<AmsBrokerPlatformExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AmsBrokerPlatformExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new AmsBrokerPlatformExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new AmsBrokerPlatformExample.Criterion(condition, value1, value2));
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdEqualTo(Integer value) {
            addCriterion("broker_id =", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdNotEqualTo(Integer value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdGreaterThan(Integer value) {
            addCriterion("broker_id >", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdLessThan(Integer value) {
            addCriterion("broker_id <", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdLessThanOrEqualTo(Integer value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdIn(List<Integer> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdNotIn(List<Integer> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdBetween(Integer value1, Integer value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeIsNull() {
            addCriterion("broker_type is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeIsNotNull() {
            addCriterion("broker_type is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeEqualTo(Integer value) {
            addCriterion("broker_type =", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeNotEqualTo(Integer value) {
            addCriterion("broker_type <>", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeGreaterThan(Integer value) {
            addCriterion("broker_type >", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_type >=", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeLessThan(Integer value) {
            addCriterion("broker_type <", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("broker_type <=", value, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeIn(List<Integer> values) {
            addCriterion("broker_type in", values, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeNotIn(List<Integer> values) {
            addCriterion("broker_type not in", values, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeBetween(Integer value1, Integer value2) {
            addCriterion("broker_type between", value1, value2, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_type not between", value1, value2, "brokerType");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdEqualTo(Integer value) {
            addCriterion("platform_id =", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdNotEqualTo(Integer value) {
            addCriterion("platform_id <>", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdGreaterThan(Integer value) {
            addCriterion("platform_id >", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_id >=", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdLessThan(Integer value) {
            addCriterion("platform_id <", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdLessThanOrEqualTo(Integer value) {
            addCriterion("platform_id <=", value, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdIn(List<Integer> values) {
            addCriterion("platform_id in", values, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdNotIn(List<Integer> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdBetween(Integer value1, Integer value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andPlatformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameIsNull() {
            addCriterion("broker_abbr_name is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameIsNotNull() {
            addCriterion("broker_abbr_name is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameEqualTo(String value) {
            addCriterion("broker_abbr_name =", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameNotEqualTo(String value) {
            addCriterion("broker_abbr_name <>", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameGreaterThan(String value) {
            addCriterion("broker_abbr_name >", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_abbr_name >=", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameLessThan(String value) {
            addCriterion("broker_abbr_name <", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameLessThanOrEqualTo(String value) {
            addCriterion("broker_abbr_name <=", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameLike(String value) {
            addCriterion("broker_abbr_name like", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameNotLike(String value) {
            addCriterion("broker_abbr_name not like", value, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameIn(List<String> values) {
            addCriterion("broker_abbr_name in", values, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameNotIn(List<String> values) {
            addCriterion("broker_abbr_name not in", values, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameBetween(String value1, String value2) {
            addCriterion("broker_abbr_name between", value1, value2, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerAbbrNameNotBetween(String value1, String value2) {
            addCriterion("broker_abbr_name not between", value1, value2, "brokerAbbrName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoIsNull() {
            addCriterion("broker_logo is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoIsNotNull() {
            addCriterion("broker_logo is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoEqualTo(String value) {
            addCriterion("broker_logo =", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoNotEqualTo(String value) {
            addCriterion("broker_logo <>", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoGreaterThan(String value) {
            addCriterion("broker_logo >", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoGreaterThanOrEqualTo(String value) {
            addCriterion("broker_logo >=", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoLessThan(String value) {
            addCriterion("broker_logo <", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoLessThanOrEqualTo(String value) {
            addCriterion("broker_logo <=", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoLike(String value) {
            addCriterion("broker_logo like", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoNotLike(String value) {
            addCriterion("broker_logo not like", value, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoIn(List<String> values) {
            addCriterion("broker_logo in", values, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoNotIn(List<String> values) {
            addCriterion("broker_logo not in", values, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoBetween(String value1, String value2) {
            addCriterion("broker_logo between", value1, value2, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerLogoNotBetween(String value1, String value2) {
            addCriterion("broker_logo not between", value1, value2, "brokerLogo");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameIsNull() {
            addCriterion("broker_name is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameIsNotNull() {
            addCriterion("broker_name is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameEqualTo(String value) {
            addCriterion("broker_name =", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameNotEqualTo(String value) {
            addCriterion("broker_name <>", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameGreaterThan(String value) {
            addCriterion("broker_name >", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_name >=", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameLessThan(String value) {
            addCriterion("broker_name <", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameLessThanOrEqualTo(String value) {
            addCriterion("broker_name <=", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameLike(String value) {
            addCriterion("broker_name like", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameNotLike(String value) {
            addCriterion("broker_name not like", value, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameIn(List<String> values) {
            addCriterion("broker_name in", values, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameNotIn(List<String> values) {
            addCriterion("broker_name not in", values, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameBetween(String value1, String value2) {
            addCriterion("broker_name between", value1, value2, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andBrokerNameNotBetween(String value1, String value2) {
            addCriterion("broker_name not between", value1, value2, "brokerName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableIsNull() {
            addCriterion("creditable is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableIsNotNull() {
            addCriterion("creditable is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableEqualTo(Boolean value) {
            addCriterion("creditable =", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableNotEqualTo(Boolean value) {
            addCriterion("creditable <>", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableGreaterThan(Boolean value) {
            addCriterion("creditable >", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("creditable >=", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableLessThan(Boolean value) {
            addCriterion("creditable <", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableLessThanOrEqualTo(Boolean value) {
            addCriterion("creditable <=", value, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableIn(List<Boolean> values) {
            addCriterion("creditable in", values, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableNotIn(List<Boolean> values) {
            addCriterion("creditable not in", values, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableBetween(Boolean value1, Boolean value2) {
            addCriterion("creditable between", value1, value2, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreditableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("creditable not between", value1, value2, "creditable");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginIsNull() {
            addCriterion("day_begin is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginIsNotNull() {
            addCriterion("day_begin is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginEqualTo(Long value) {
            addCriterion("day_begin =", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginNotEqualTo(Long value) {
            addCriterion("day_begin <>", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginGreaterThan(Long value) {
            addCriterion("day_begin >", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginGreaterThanOrEqualTo(Long value) {
            addCriterion("day_begin >=", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginLessThan(Long value) {
            addCriterion("day_begin <", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginLessThanOrEqualTo(Long value) {
            addCriterion("day_begin <=", value, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginIn(List<Long> values) {
            addCriterion("day_begin in", values, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginNotIn(List<Long> values) {
            addCriterion("day_begin not in", values, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginBetween(Long value1, Long value2) {
            addCriterion("day_begin between", value1, value2, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayBeginNotBetween(Long value1, Long value2) {
            addCriterion("day_begin not between", value1, value2, "dayBegin");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndIsNull() {
            addCriterion("day_end is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndIsNotNull() {
            addCriterion("day_end is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndEqualTo(Long value) {
            addCriterion("day_end =", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndNotEqualTo(Long value) {
            addCriterion("day_end <>", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndGreaterThan(Long value) {
            addCriterion("day_end >", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndGreaterThanOrEqualTo(Long value) {
            addCriterion("day_end >=", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndLessThan(Long value) {
            addCriterion("day_end <", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndLessThanOrEqualTo(Long value) {
            addCriterion("day_end <=", value, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndIn(List<Long> values) {
            addCriterion("day_end in", values, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndNotIn(List<Long> values) {
            addCriterion("day_end not in", values, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndBetween(Long value1, Long value2) {
            addCriterion("day_end between", value1, value2, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andDayEndNotBetween(Long value1, Long value2) {
            addCriterion("day_end not between", value1, value2, "dayEnd");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameIsNull() {
            addCriterion("operator_id is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (AmsBrokerPlatformExample.Criteria) this;
        }





        public AmsBrokerPlatformExample.Criteria andOperatorIdIsNull() {
            addCriterion("platform_name is null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameEqualTo(Integer value) {
            addCriterion("platform_name =", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameNotEqualTo(Integer value) {
            addCriterion("platform_name <>", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameGreaterThan(Integer value) {
            addCriterion("platform_name >", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_name >=", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameLessThan(Integer value) {
            addCriterion("platform_name <", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameLessThanOrEqualTo(Integer value) {
            addCriterion("platform_name <=", value, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameIn(List<Integer> values) {
            addCriterion("platform_name in", values, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameNotIn(List<Integer> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameBetween(Integer value1, Integer value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }

        public AmsBrokerPlatformExample.Criteria andplatformNameNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (AmsBrokerPlatformExample.Criteria) this;
        }
    }

    public static class Criteria extends AmsBrokerPlatformExample.GeneratedCriteria implements Serializable {

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
