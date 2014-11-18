package org.fedon.client.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * @author Dmytro Fedonin
 *
 */
public class HystrixInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {

        System.out.println("Interceptor: before proceed...");
        context.proceed(); // real call will be done latter in connector -- not good for Hystrix
        System.out.println("Interceptor: done ===============");
    }
}
