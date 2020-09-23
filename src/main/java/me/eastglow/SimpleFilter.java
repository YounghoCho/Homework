package me.eastglow;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.eastglow.dao.TrafficDao;
 
@Slf4j
@Component
public class SimpleFilter implements Filter {
	
	@Resource
	private TrafficDao dao;
	
    @Override
    public void destroy() {
    	System.out.println("Filter Destroyed");
	}

    @Override 
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain) 
       throws IOException, ServletException {
	   
	   final HttpServletRequest request = new RequestWrapper((HttpServletRequest) req);
       final HttpServletResponse response = new ResponseWrapper((HttpServletResponse) res);
       Map<String, Object> requestMap = LoggingUtil.makeLoggingRequestMap(request);
       
       filterchain.doFilter(request, response);

       Map<String, Object> responseMap = LoggingUtil.makeLoggingResponseMap(response);
       ((ResponseWrapper) response).copyBodyToResponse();

       System.out.println("REQUEST :" + requestMap.toString());
       System.out.println("RESPONSE :" + responseMap.toString());

       dao.insertTraffic(requestMap.toString(), responseMap.toString());
   }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {
	   System.out.println("Filter Initiatied");
   }
}