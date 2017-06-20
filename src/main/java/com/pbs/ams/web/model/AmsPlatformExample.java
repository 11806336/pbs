package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AmsPlatformExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsPlatformExample() {
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

        public Criteria andPlatformLogoIsNull() {
            addCriterion("platform_logo is null");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoIsNotNull() {
            addCriterion("platform_logo is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoEqualTo(String value) {
            addCriterion("platform_logo =", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoNotEqualTo(String value) {
            addCriterion("platform_logo <>", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoGreaterThan(String value) {
            addCriterion("platform_logo >", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoGreaterThanOrEqualTo(String value) {
            addCriterion("platform_logo >=", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoLessThan(String value) {
            addCriterion("platform_logo <", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoLessThanOrEqualTo(String value) {
            addCriterion("platform_logo <=", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoLike(String value) {
            addCriterion("platform_logo like", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoNotLike(String value) {
            addCriterion("platform_logo not like", value, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoIn(List<String> values) {
            addCriterion("platform_logo in", values, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoNotIn(List<String> values) {
            addCriterion("platform_logo not in", values, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoBetween(String value1, String value2) {
            addCriterion("platform_logo between", value1, value2, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformLogoNotBetween(String value1, String value2) {
            addCriterion("platform_logo not between", value1, value2, "platformLogo");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameIsNull() {
            addCriterion("platform_abbr_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameIsNotNull() {
            addCriterion("platform_abbr_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameEqualTo(String value) {
            addCriterion("platform_abbr_name =", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameNotEqualTo(String value) {
            addCriterion("platform_abbr_name <>", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameGreaterThan(String value) {
            addCriterion("platform_abbr_name >", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_abbr_name >=", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameLessThan(String value) {
            addCriterion("platform_abbr_name <", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameLessThanOrEqualTo(String value) {
            addCriterion("platform_abbr_name <=", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameLike(String value) {
            addCriterion("platform_abbr_name like", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameNotLike(String value) {
            addCriterion("platform_abbr_name not like", value, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameIn(List<String> values) {
            addCriterion("platform_abbr_name in", values, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameNotIn(List<String> values) {
            addCriterion("platform_abbr_name not in", values, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameBetween(String value1, String value2) {
            addCriterion("platform_abbr_name between", value1, value2, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformAbbrNameNotBetween(String value1, String value2) {
            addCriterion("platform_abbr_name not between", value1, value2, "platformAbbrName");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platform_type is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platform_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeEqualTo(Integer value) {
            addCriterion("platform_type =", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotEqualTo(Integer value) {
            addCriterion("platform_type <>", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThan(Integer value) {
            addCriterion("platform_type >", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_type >=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThan(Integer value) {
            addCriterion("platform_type <", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThanOrEqualTo(Integer value) {
            addCriterion("platform_type <=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIn(List<Integer> values) {
            addCriterion("platform_type in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotIn(List<Integer> values) {
            addCriterion("platform_type not in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeBetween(Integer value1, Integer value2) {
            addCriterion("platform_type between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_type not between", value1, value2, "platformType");
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