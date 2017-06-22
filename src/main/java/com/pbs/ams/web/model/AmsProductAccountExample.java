package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AmsProductAccountExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsProductAccountExample() {
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

        public Criteria andProductAccountIdIsNull() {
            addCriterion("product_account_id is null");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdIsNotNull() {
            addCriterion("product_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdEqualTo(Integer value) {
            addCriterion("product_account_id =", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdNotEqualTo(Integer value) {
            addCriterion("product_account_id <>", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdGreaterThan(Integer value) {
            addCriterion("product_account_id >", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_account_id >=", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdLessThan(Integer value) {
            addCriterion("product_account_id <", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_account_id <=", value, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdIn(List<Integer> values) {
            addCriterion("product_account_id in", values, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdNotIn(List<Integer> values) {
            addCriterion("product_account_id not in", values, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("product_account_id between", value1, value2, "productAccountId");
            return (Criteria) this;
        }

        public Criteria andProductAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_account_id not between", value1, value2, "productAccountId");
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

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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