package me.eastglow.service;

import java.util.List;

import me.eastglow.vo.TestVO;

public interface TestService {

	List<TestVO> getTestList() throws Exception;
}