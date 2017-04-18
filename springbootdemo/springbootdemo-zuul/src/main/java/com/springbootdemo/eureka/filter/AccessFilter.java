package com.springbootdemo.eureka.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/18.
 *
 * 安全过滤器，验证请求中是否有accessToken参数
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 代表不同的过滤类型：
     * pre：请求之前调用；
     * routing：在路由请求时调用；
     * post：在routing和error过滤器之后被调用；
     * error：在处理错误是调用；
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值定义过滤器执行顺序；
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回boolean类型判断过滤器是否执行；
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");

        return null;
    }
}
