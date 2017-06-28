package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmsProductDetailExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AmsProductDetailExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andProductNetValueIsNull() {
            addCriterion("product_net_value is null");
            return (Criteria) this;
        }

        public Criteria andProductNetValueIsNotNull() {
            addCriterion("product_net_value is not null");
            return (Criteria) this;
        }

        public Criteria andProductNetValueEqualTo(BigDecimal value) {
            addCriterion("product_net_value =", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueNotEqualTo(BigDecimal value) {
            addCriterion("product_net_value <>", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueGreaterThan(BigDecimal value) {
            addCriterion("product_net_value >", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_net_value >=", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueLessThan(BigDecimal value) {
            addCriterion("product_net_value <", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_net_value <=", value, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueIn(List<BigDecimal> values) {
            addCriterion("product_net_value in", values, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueNotIn(List<BigDecimal> values) {
            addCriterion("product_net_value not in", values, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_net_value between", value1, value2, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andProductNetValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_net_value not between", value1, value2, "productNetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueIsNull() {
            addCriterion("net_asset_value is null");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueIsNotNull() {
            addCriterion("net_asset_value is not null");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueEqualTo(BigDecimal value) {
            addCriterion("net_asset_value =", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueNotEqualTo(BigDecimal value) {
            addCriterion("net_asset_value <>", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueGreaterThan(BigDecimal value) {
            addCriterion("net_asset_value >", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_asset_value >=", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueLessThan(BigDecimal value) {
            addCriterion("net_asset_value <", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_asset_value <=", value, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueIn(List<BigDecimal> values) {
            addCriterion("net_asset_value in", values, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueNotIn(List<BigDecimal> values) {
            addCriterion("net_asset_value not in", values, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_asset_value between", value1, value2, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andNetAssetValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_asset_value not between", value1, value2, "netAssetValue");
            return (Criteria) this;
        }

        public Criteria andProductSharesIsNull() {
            addCriterion("product_shares is null");
            return (Criteria) this;
        }

        public Criteria andProductSharesIsNotNull() {
            addCriterion("product_shares is not null");
            return (Criteria) this;
        }

        public Criteria andProductSharesEqualTo(Integer value) {
            addCriterion("product_shares =", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesNotEqualTo(Integer value) {
            addCriterion("product_shares <>", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesGreaterThan(Integer value) {
            addCriterion("product_shares >", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_shares >=", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesLessThan(Integer value) {
            addCriterion("product_shares <", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesLessThanOrEqualTo(Integer value) {
            addCriterion("product_shares <=", value, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesIn(List<Integer> values) {
            addCriterion("product_shares in", values, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesNotIn(List<Integer> values) {
            addCriterion("product_shares not in", values, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesBetween(Integer value1, Integer value2) {
            addCriterion("product_shares between", value1, value2, "productShares");
            return (Criteria) this;
        }

        public Criteria andProductSharesNotBetween(Integer value1, Integer value2) {
            addCriterion("product_shares not between", value1, value2, "productShares");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsIsNull() {
            addCriterion("stock_total_assets is null");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsIsNotNull() {
            addCriterion("stock_total_assets is not null");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsEqualTo(BigDecimal value) {
            addCriterion("stock_total_assets =", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsNotEqualTo(BigDecimal value) {
            addCriterion("stock_total_assets <>", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsGreaterThan(BigDecimal value) {
            addCriterion("stock_total_assets >", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_total_assets >=", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsLessThan(BigDecimal value) {
            addCriterion("stock_total_assets <", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_total_assets <=", value, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsIn(List<BigDecimal> values) {
            addCriterion("stock_total_assets in", values, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsNotIn(List<BigDecimal> values) {
            addCriterion("stock_total_assets not in", values, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_total_assets between", value1, value2, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andStockTotalAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_total_assets not between", value1, value2, "stockTotalAssets");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueIsNull() {
            addCriterion("security_total_value is null");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueIsNotNull() {
            addCriterion("security_total_value is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueEqualTo(BigDecimal value) {
            addCriterion("security_total_value =", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueNotEqualTo(BigDecimal value) {
            addCriterion("security_total_value <>", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueGreaterThan(BigDecimal value) {
            addCriterion("security_total_value >", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("security_total_value >=", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueLessThan(BigDecimal value) {
            addCriterion("security_total_value <", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("security_total_value <=", value, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueIn(List<BigDecimal> values) {
            addCriterion("security_total_value in", values, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueNotIn(List<BigDecimal> values) {
            addCriterion("security_total_value not in", values, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("security_total_value between", value1, value2, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andSecurityTotalValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("security_total_value not between", value1, value2, "securityTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueIsNull() {
            addCriterion("stock_total_value is null");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueIsNotNull() {
            addCriterion("stock_total_value is not null");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueEqualTo(BigDecimal value) {
            addCriterion("stock_total_value =", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueNotEqualTo(BigDecimal value) {
            addCriterion("stock_total_value <>", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueGreaterThan(BigDecimal value) {
            addCriterion("stock_total_value >", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_total_value >=", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueLessThan(BigDecimal value) {
            addCriterion("stock_total_value <", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_total_value <=", value, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueIn(List<BigDecimal> values) {
            addCriterion("stock_total_value in", values, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueNotIn(List<BigDecimal> values) {
            addCriterion("stock_total_value not in", values, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_total_value between", value1, value2, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andStockTotalValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_total_value not between", value1, value2, "stockTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueIsNull() {
            addCriterion("short_total_value is null");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueIsNotNull() {
            addCriterion("short_total_value is not null");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueEqualTo(BigDecimal value) {
            addCriterion("short_total_value =", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueNotEqualTo(BigDecimal value) {
            addCriterion("short_total_value <>", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueGreaterThan(BigDecimal value) {
            addCriterion("short_total_value >", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("short_total_value >=", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueLessThan(BigDecimal value) {
            addCriterion("short_total_value <", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("short_total_value <=", value, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueIn(List<BigDecimal> values) {
            addCriterion("short_total_value in", values, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueNotIn(List<BigDecimal> values) {
            addCriterion("short_total_value not in", values, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("short_total_value between", value1, value2, "shortTotalValue");
            return (Criteria) this;
        }

        public Criteria andShortTotalValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("short_total_value not between", value1, value2, "shortTotalValue");
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

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
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