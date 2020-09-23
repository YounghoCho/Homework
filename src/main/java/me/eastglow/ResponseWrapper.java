package me.eastglow;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseWrapper extends ContentCachingResponseWrapper {
   private ObjectMapper objectMapper;

   public ResponseWrapper(HttpServletResponse response) {
       super(response);
       this.objectMapper = new ObjectMapper();
   }

   public Object convertToObject() throws IOException {
       return objectMapper.readValue(getContentAsByteArray(), Object.class);
   }
}