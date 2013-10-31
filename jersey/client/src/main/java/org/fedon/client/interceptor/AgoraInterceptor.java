package org.fedon.client.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * @author Dmytro Fedonin
 *
 */
public class AgoraInterceptor implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {

        System.out.println("Interceptor: before proceed...");
        context.proceed();
        System.out.println("Interceptor: done ===============");
    }
}
