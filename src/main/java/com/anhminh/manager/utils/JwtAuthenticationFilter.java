package com.anhminh.manager.utils;

import com.anhminh.manager.DTO.request.UserDetailProjection;
import com.anhminh.manager.service.JwtService;
import com.anhminh.manager.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends HttpFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractJwtFromRequest(request);
        if(token != null) {
            String username = jwtService.extractUsername(token);
            UserDetailProjection userDetails = userService.getAuthenticatedUser(username);
            if (userDetails != null) {
                //tạo access(phân quyền)
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userDetails.getRole().toUpperCase());

                //tạo ra 1 springUser có chua phan quyen
                UserDetails springUser = new User(userDetails.getUsername(), userDetails.getPassword(), Collections.singletonList(authority));

                //định nghĩa kiểu authen dang xư ly+(giay phep)
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(springUser, null, springUser.getAuthorities());

                //tạo ngữ cảnh sử dụng cho authen(giay phep hieen tại) - (nơi áp dụng giay phep)
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //luu vao trong context(nhà nước công nhận)
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    // extract token từ request thong qua header 'Authorization'
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }



}

