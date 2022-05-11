package com.springers.techevents.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDenied implements AccessDeniedHandler
{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
    {
        try
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null)
                System.out.println("The user '" + auth.getName() + "' tried to access to a private area '" + request.getRequestURI());
            response.sendRedirect(request.getContextPath() + "/denied");
        }
        catch (IOException ee)
        {
            System.out.println(ee.getMessage());
        }
    }
}