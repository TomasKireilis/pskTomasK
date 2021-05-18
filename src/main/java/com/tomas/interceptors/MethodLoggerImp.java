package com.tomas.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@MethodLogger
public class MethodLoggerImp implements Serializable{
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println("Logging interceptor was called on method: " + context.getMethod().getName());
        return context.proceed();
    }
}
