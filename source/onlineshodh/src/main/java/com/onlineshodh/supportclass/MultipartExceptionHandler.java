package com.onlineshodh.supportclass;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MultipartExceptionHandler extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
            filterChain.doFilter(request, response);
        } catch (MaxUploadSizeExceededException e) {
        	handle(request, response, e);
        } catch (ServletException e) {
            if(e.getRootCause() instanceof MaxUploadSizeExceededException) {
                handle(request, response, (MaxUploadSizeExceededException) e.getRootCause());
            } else {
                throw e;
            }
        }
		
		
	}

   
    private void handle(HttpServletRequest request,
            HttpServletResponse response, MaxUploadSizeExceededException e) throws ServletException, IOException {
    	
        String redirect = UrlUtils.buildFullRequestUrl(request);
        String sustr = redirect.substring(0, redirect.length()-4)+"exception";
        
        System.out.println(" Yes Caught.."+sustr);
        System.out.println(request.getMethod()); 
        response.sendRedirect(sustr);
      
        //RequestDispatcher rd=request.getRequestDispatcher("sustr");
        //rd.forward(request, response);
        
    }

    
    
}