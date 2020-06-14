package com.team.house_backapi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王建兵
 * @Classname ${NAME}
 * @Description TODO
 * 注意: 如果是在springboot工程中创建过滤器(使用注解的方式).需要在启动类上添加扫描servlet或者filter注解的配置
 * @ServletComponentScan(basePackages = {"com.example.sbdemo2.filter"})
 * com.example.sbdemo2.filter这个就存放过滤器的包
 */
@WebFilter(filterName = "CORSFilter", urlPatterns ="/*")
public class CORSFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //System.out.println("sssssssssss");
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", "null");//支持跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");  //支持 session异步请求，共享session
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Token");
        chain.doFilter(req, resp);  //放行
    }
    /**
     *  withCredentials：表示XMLHttpRequest是否接收cookies和发送cookies，
     * 也就是说如果该值是false，响应头的Set-Cookie，浏览器也不会理，
     * 并且即使有目标站点的cookies，浏览器也不会发送。
     *
     //指定允许其他域名访问
     'Access-Control-Allow-Origin:http://172.20.0.206'//一般用法（*，指定域，动态设置），3是因为*不允许携带认证头和cookies
     //是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
     response.setHeader("Access-Control-Allow-Credentials", "true");
     Access-Control-Allow-Origin设置为空*/
    public void init(FilterConfig config) throws ServletException {

    }
}
