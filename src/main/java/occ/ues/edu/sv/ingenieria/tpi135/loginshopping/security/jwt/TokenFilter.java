package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.service.UserDetailService;

public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    Provider provider;

    @Autowired
    UserDetailService detailService;

    private final static Logger logger= LoggerFactory.getLogger(TokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
         try {
             String token = getToken(req);
             if(token != null && provider.validateToken(token) ){
                 String username = provider.getUserNameFromToken(token);
                 UserDetails userDetails = detailService.loadUserByUsername(username);
                 
                /**Autenticando */ 
                UsernamePasswordAuthenticationToken auth = 
                 new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                 SecurityContextHolder.getContext().setAuthentication(auth);
             }
         } catch (Exception e) {
             logger.error("Error en el metodo dofilterInternal");
         }

         filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        
        if (header != null && header.startsWith("Bearer")) 
            return header.replace("Bearer", "");
        
        return null;
    }
    
}
