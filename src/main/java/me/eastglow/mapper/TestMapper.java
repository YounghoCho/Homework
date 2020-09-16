package me.eastglow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.eastglow.vo.TestVO;

@Mapper
public interface TestMapper {

	List<TestVO> selectTestList() throws Exception;
}