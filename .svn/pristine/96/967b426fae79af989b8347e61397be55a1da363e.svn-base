package com.web.criterion;

import java.util.List;

/**
 * 查询的条件
 * 
 * @author Administrator
 *
 */
public class Criterion {

	// 条件
	private String condition;

	// 第1值
	private Object value;

	// 第二个值
	private Object secondValue;

	// 是否有值
	private boolean noValue;

	// 是否是唯一的值
	private boolean singleValue;

	// 是否使用between and
	private boolean betweenValue;

	// 是不是有多个值
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

	protected Criterion(String condition, Object value, Object secondValue,
			String typeHandler) {
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
