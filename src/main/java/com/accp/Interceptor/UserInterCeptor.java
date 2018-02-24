package com.accp.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class UserInterCeptor extends AbstractInterceptor {

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //获取拦截器的上下文的名字
        String name=actionInvocation.getInvocationContext().getName();
        System.out.println(name);

        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Object user=session.get("userName");
        if (user!=null || "userLogin".equals(name))
        return actionInvocation.invoke();
        else
            return "Login";
    }
}
