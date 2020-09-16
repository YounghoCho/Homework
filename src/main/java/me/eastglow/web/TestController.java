package me.eastglow.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.eastglow.service.TestService;

@Controller
public class TestController {
	
	@Resource
	private TestService testSvc;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	@ResponseBody
	public Object index(Model model) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("testList", testSvc.getTestList());
		return result;	
	}
}
