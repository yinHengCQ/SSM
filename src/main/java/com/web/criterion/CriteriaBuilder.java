package com.web.criterion;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBuilder extends GeneratedCriteria {

	protected String orderByClause;

	 

	private Integer limit;

	private Integer offset;

	protected List<Criteria> searchCriteriaList;
	
	
	
	/**
	 * 取得所有的查询条件对象
	 * @return
	 */
	public List<Criteria> getSearchCriteriaList() {
		return searchCriteriaList;
	}

	public CriteriaBuilder(){
		searchCriteriaList=new ArrayList<Criteria>();
	}

	/**
	 * 设定排序的列
	 * 
	 * @param orderByClause
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 得到要排序的列
	 * 
	 * @return
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	 

	/**
	 * 设定分页取几笔
	 * 
	 * @param limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * 得到分页取几笔
	 * 
	 * @return
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * 设定取分页开始笔数
	 * 
	 * @param offset
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * 分页开始笔数
	 * 
	 * @return
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * 添加一个新的or条件
	 * 
	 * @param criteria
	 */
	public void or(Criteria criteria) {
		searchCriteriaList.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		searchCriteriaList.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (searchCriteriaList.size() == 0) {
			searchCriteriaList.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		searchCriteriaList.clear();
		orderByClause = null;
		 
	}

	/**
	 * 查询对象
	 * @author Administrator
	 *
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}

		/**
		 * 查询该列为null，如： 列名 is null
		 * 
		 * @param columnName
		 */
		public Criteria andIsNull(String columnName) {
			super.addCriterion(columnName + "  is null");

			return this;
		}

		/**
		 * 查询该列不为null，如： 列名 is not null
		 * 
		 * @return
		 */
		public Criteria andIsNotNull(String columnName) {
			addCriterion(columnName + " is not null");

			return this;
		}

		/**
		 * 查询列名的值=
		 * 
		 * @param columnName
		 * @param value
		 */
		public Criteria andLike(String columnName, Object value) {
			addCriterion(columnName + "  like ",   value );
			return this;
		}

		/**
		 * 查询列名的值=
		 * 
		 * @param columnName
		 * @param value
		 */
		public Criteria andEqualTo(String columnName, Object value) {
			addCriterion(columnName + " = ", value);

			return this;
		}

		/**
		 * 查询列名的值<>
		 * 
		 * @param columnName
		 * @param value
		 */
		public Criteria andNotEqualTo(String columnName, Object value) {
			addCriterion(columnName + " <> ", value);

			return this;
		}

		public Criteria andGreaterThan(String columnName, Object value) {
			addCriterion(columnName + " > ", value);

			return this;
		}

		public Criteria andGreaterThanOrEqualTo(String columnName, Object value) {
			addCriterion(columnName + " >= ", value);

			return this;
		}

		public Criteria andLessThan(String columnName, Object value) {
			addCriterion(columnName + " < ", value);

			return this;
		}

		public Criteria andLessThanOrEqualTo(String columnName, Object value) {
			addCriterion(columnName + "<= ", value);

			return this;
		}

		public Criteria andIn(String columnName, List<Object> values) {
			addCriterion(columnName + " in ", values);

			return this;
		}

		public Criteria andNotIn(String columnName, List<Object> values) {
			addCriterion(columnName + " not in ", values);

			return this;

		}

		public Criteria andBetween(String columnName, Object value1,
				Object value2) {
			addBetweenAndCriterion(columnName + " between ", value1, value2);

			return this;
		}

		public Criteria andNotBetween(String columnName, Object value1,
				Object value2) {
			addBetweenAndCriterion(columnName + " not between ", value1, value2);

			return this;
		}

	}

}
