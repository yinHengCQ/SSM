package com.web.service.impl;

import java.util.List;

import com.web.criterion.CriteriaBuilder;
import com.web.mapper.CommonMapper;
import com.web.service.CommonService;
import com.web.util.PageUtil;

public abstract class CommonServiceImpl<T> implements CommonService<T> {

	private CommonMapper<T>  commonMapper;
	 
	/**
	 * 子类给父类赋值
	 * @param commonMapper
	 */
	public void setCommonMapper(CommonMapper<T> commonMapper) {
		this.commonMapper = commonMapper;
	}

	@Override
	public boolean insert(T obj) { 
		return  this.commonMapper.insert(obj)>0;
	}

	public boolean delete(int id){
		return this.commonMapper.delete(id);
	}
	
	@Override
	public boolean update(T obj) {
		 
		return this.commonMapper.update(obj)>0;
	}

	@Override
	public T findById(int id) {
	 
		return this.commonMapper.findById(id);
	}

	@Override
	public void searchPaging(CriteriaBuilder criteria, PageUtil<T> paging) {
		
		criteria.setOffset( paging.getBegin());  //排除前几笔
		criteria.setLimit( paging.getEnd() );   //取向笔
		 
		
	   paging.setData(    this.commonMapper.searchPaging(criteria)  );
	   paging.setTotalRecords( this.commonMapper.searchPagingCount(criteria)  ); 
		
	}

	//通用查询
	@Override
	public List<T> search(CriteriaBuilder criteria) { 
		return this.commonMapper.search(criteria);
	}
	
	
	
	

}
