package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.Templet;
import com.web.mapper.TempletMapper;
import com.web.service.TempletService;

@Service
public class TempletServiceImpl extends CommonServiceImpl<Templet> implements TempletService {

	private TempletMapper templetMapper;

	@Resource(name="templetMapper")
	public void setTempletMapper(TempletMapper templetMapper) {
		this.templetMapper = templetMapper;
		super.setCommonMapper(templetMapper);
	}
	
}
