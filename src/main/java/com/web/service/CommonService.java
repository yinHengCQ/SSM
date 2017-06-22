package com.web.service;

import java.util.List;

import com.web.criterion.CriteriaBuilder;
import com.web.util.PageUtil;

public interface CommonService<T> {

	 
	/**
	 * 新增
	 * @param obj
	 * @return
	 */
	public boolean insert(T obj);
	
	/**
	 * 删除
	 * @param obj
	 * @return
	 */
	public boolean delete(int id);
		
	/**
	 * 修改
	 * @param obj
	 * @return
	 */
	public boolean update(T obj);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public T  findById(int id);
	
	
	/**
	 * 分页查询的数据
	 * @param criteria
	 * @return
	 */
	public void searchPaging(CriteriaBuilder criteria,PageUtil<T> paging);
	
//	public List<T> searchPaging(CriteriaBuilder criteria);
//	public int searchPagingCount(CriteriaBuilder criteria);
	
	
	
	/**
	 * 可以查询到你的任何的条件
	 * @param criteria
	 * @return
	 */
	public List<T> search(CriteriaBuilder criteria);
	
}
