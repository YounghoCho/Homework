package me.eastglow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.eastglow.mapper.TestMapper;
import me.eastglow.service.TestService;
import me.eastglow.vo.TestVO;

@Service
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper testDao;
	
	@Override
	public List<TestVO> getTestList() throws Exception {
		return testDao.selectTestList();
	}	
}