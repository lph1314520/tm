package com.xunxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xunxing.mapper.OuterBoxMapper;
import com.xunxing.pojo.OuterBox;
import com.xunxing.service.OuterBoxService;


@Service
public class OuterBoxServiceImpl implements OuterBoxService {

	@Autowired
	private OuterBoxMapper  outerBoxMapper;

	public List<OuterBox> getOuterBoxList() {
		// TODO Auto-generated method stub
		return this.outerBoxMapper.getOuterBoxList();
	}

	
	



}
