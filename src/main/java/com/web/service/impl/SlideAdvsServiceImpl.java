package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.entity.SlideAdvs;
import com.web.mapper.SlideAdvsMapper;
import com.web.service.SlideAdvsService;

@Service
public class SlideAdvsServiceImpl extends CommonServiceImpl<SlideAdvs> implements SlideAdvsService {
 
	private SlideAdvsMapper slideAdvsMapper;

	@Resource(name="slideAdvsMapper")
	public void setSlideAdvsMapper(SlideAdvsMapper slideAdvsMapper) {
		this.slideAdvsMapper = slideAdvsMapper;
		super.setCommonMapper(slideAdvsMapper);
	}
}
