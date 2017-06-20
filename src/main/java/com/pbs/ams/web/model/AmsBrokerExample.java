package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AmsBrokerExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsBrokerExample() {
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

        public Criteria andBrokerTypeIsNull() {
            addCriterion("broker_type is null");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeIsNotNull() {
            addCriterion("broker_type is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeEqualTo(Integer value) {
            addCriterion("broker_type =", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeNotEqualTo(Integer value) {
            addCriterion("broker_type <>", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeGreaterThan(Integer value) {
            addCriterion("broker_type >", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_type >=", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeLessThan(Integer value) {
            addCriterion("broker_type <", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("broker_type <=", value, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeIn(List<Integer> values) {
            addCriterion("broker_type in", values, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeNotIn(List<Integer> values) {
            addCriterion("broker_type not in", values, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeBetween(Integer value1, Integer value2) {
            addCriterion("broker_type between", value1, value2, "brokerType");
            return (Criteria) this;
        }

        public Criteria andBrokerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_type not between", value1, value2, "brokerType");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdEqualTo(Integer value) {
            addCriterion("platform_id =", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotEqualTo(Integer value) {
            addCriterion("platform_id <>", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThan(Integer value) {
            addCriterion("platform_id >", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_id >=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThan(Integer value) {
            addCriterion("platform_id <", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThanOrEqualTo(Integer value) {
            addCriterion("platform_id <=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIn(List<Integer> values) {
            addCriterion("platform_id in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotIn(List<Integer> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdBetween(Integer value1, Integer value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameIsNull() {
            addCriterion("broker_abbr_name is null");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameIsNotNull() {
            addCriterion("broker_abbr_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameEqualTo(String value) {
            addCriterion("broker_abbr_name =", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameNotEqualTo(String value) {
            addCriterion("broker_abbr_name <>", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameGreaterThan(String value) {
            addCriterion("broker_abbr_name >", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_abbr_name >=", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameLessThan(String value) {
            addCriterion("broker_abbr_name <", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameLessThanOrEqualTo(String value) {
            addCriterion("broker_abbr_name <=", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameLike(String value) {
            addCriterion("broker_abbr_name like", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameNotLike(String value) {
            addCriterion("broker_abbr_name not like", value, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameIn(List<String> values) {
            addCriterion("broker_abbr_name in", values, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameNotIn(List<String> values) {
            addCriterion("broker_abbr_name not in", values, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameBetween(String value1, String value2) {
            addCriterion("broker_abbr_name between", value1, value2, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerAbbrNameNotBetween(String value1, String value2) {
            addCriterion("broker_abbr_name not between", value1, value2, "brokerAbbrName");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoIsNull() {
            addCriterion("broker_logo is null");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoIsNotNull() {
            addCriterion("broker_logo is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoEqualTo(String value) {
            addCriterion("broker_logo =", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoNotEqualTo(String value) {
            addCriterion("broker_logo <>", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoGreaterThan(String value) {
            addCriterion("broker_logo >", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoGreaterThanOrEqualTo(String value) {
            addCriterion("broker_logo >=", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoLessThan(String value) {
            addCriterion("broker_logo <", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoLessThanOrEqualTo(String value) {
            addCriterion("broker_logo <=", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoLike(String value) {
            addCriterion("broker_logo like", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoNotLike(String value) {
            addCriterion("broker_logo not like", value, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoIn(List<String> values) {
            addCriterion("broker_logo in", values, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoNotIn(List<String> values) {
            addCriterion("broker_logo not in", values, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoBetween(String value1, String value2) {
            addCriterion("broker_logo between", value1, value2, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerLogoNotBetween(String value1, String value2) {
            addCriterion("broker_logo not between", value1, value2, "brokerLogo");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIsNull() {
            addCriterion("broker_name is null");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIsNotNull() {
            addCriterion("broker_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerNameEqualTo(String value) {
            addCriterion("broker_name =", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotEqualTo(String value) {
            addCriterion("broker_name <>", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThan(String value) {
            addCriterion("broker_name >", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_name >=", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThan(String value) {
            addCriterion("broker_name <", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThanOrEqualTo(String value) {
            addCriterion("broker_name <=", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLike(String value) {
            addCriterion("broker_name like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotLike(String value) {
            addCriterion("broker_name not like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIn(List<String> values) {
            addCriterion("broker_name in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotIn(List<String> values) {
            addCriterion("broker_name not in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameBetween(String value1, String value2) {
            addCriterion("broker_name between", value1, value2, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotBetween(String value1, String value2) {
            addCriterion("broker_name not between", value1, value2, "brokerName");
            return (Criteria) this;
        }

        public Criteria andCreditableIsNull() {
            addCriterion("creditable is null");
            return (Criteria) this;
        }

        public Criteria andCreditableIsNotNull() {
            addCriterion("creditable is not null");
            return (Criteria) this;
        }

        public Criteria andCreditableEqualTo(Boolean value) {
            addCriterion("creditable =", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableNotEqualTo(Boolean value) {
            addCriterion("creditable <>", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableGreaterThan(Boolean value) {
            addCriterion("creditable >", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("creditable >=", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableLessThan(Boolean value) {
            addCriterion("creditable <", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableLessThanOrEqualTo(Boolean value) {
            addCriterion("creditable <=", value, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableIn(List<Boolean> values) {
            addCriterion("creditable in", values, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableNotIn(List<Boolean> values) {
            addCriterion("creditable not in", values, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableBetween(Boolean value1, Boolean value2) {
            addCriterion("creditable between", value1, value2, "creditable");
            return (Criteria) this;
        }

        public Criteria andCreditableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("creditable not between", value1, value2, "creditable");
            return (Criteria) this;
        }

        public Criteria andDayBeginIsNull() {
            addCriterion("day_begin is null");
            return (Criteria) this;
        }

        public Criteria andDayBeginIsNotNull() {
            addCriterion("day_begin is not null");
            return (Criteria) this;
        }

        public Criteria andDayBeginEqualTo(Long value) {
            addCriterion("day_begin =", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginNotEqualTo(Long value) {
            addCriterion("day_begin <>", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginGreaterThan(Long value) {
            addCriterion("day_begin >", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginGreaterThanOrEqualTo(Long value) {
            addCriterion("day_begin >=", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginLessThan(Long value) {
            addCriterion("day_begin <", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginLessThanOrEqualTo(Long value) {
            addCriterion("day_begin <=", value, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginIn(List<Long> values) {
            addCriterion("day_begin in", values, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginNotIn(List<Long> values) {
            addCriterion("day_begin not in", values, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginBetween(Long value1, Long value2) {
            addCriterion("day_begin between", value1, value2, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayBeginNotBetween(Long value1, Long value2) {
            addCriterion("day_begin not between", value1, value2, "dayBegin");
            return (Criteria) this;
        }

        public Criteria andDayEndIsNull() {
            addCriterion("day_end is null");
            return (Criteria) this;
        }

        public Criteria andDayEndIsNotNull() {
            addCriterion("day_end is not null");
            return (Criteria) this;
        }

        public Criteria andDayEndEqualTo(Long value) {
            addCriterion("day_end =", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndNotEqualTo(Long value) {
            addCriterion("day_end <>", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndGreaterThan(Long value) {
            addCriterion("day_end >", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndGreaterThanOrEqualTo(Long value) {
            addCriterion("day_end >=", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndLessThan(Long value) {
            addCriterion("day_end <", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndLessThanOrEqualTo(Long value) {
            addCriterion("day_end <=", value, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndIn(List<Long> values) {
            addCriterion("day_end in", values, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndNotIn(List<Long> values) {
            addCriterion("day_end not in", values, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndBetween(Long value1, Long value2) {
            addCriterion("day_end between", value1, value2, "dayEnd");
            return (Criteria) this;
        }

        public Criteria andDayEndNotBetween(Long value1, Long value2) {
            addCriterion("day_end not between", value1, value2, "dayEnd");
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