package org.fedon.matrix.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fedon.matrix.annotation.StatusAccepted;
import org.glassfish.jersey.server.internal.routing.RoutingContext;

/**
 * @author Dmytro Fedonin
 *
 */
public class AgoraResponseFilter implements ContainerResponseFilter {
    private final Log log = LogFactory.getLog(getClass());

    @Inject
    Provider<RoutingContext> routingContextProvider;
    @Context
    private HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Method m = routingContextProvider.get().getResourceMethod();
        log.info("routing context -- " + routingContextProvider);
        log.info("routing method == " + m);
        log.info("Fileter -- server: " + servletRequest.getServerName());
        if (m != null && m.isAnnotationPresent(StatusAccepted.class)) {
            log.info("------------------------------------ Fileter: " + this);
            if (responseContext.getStatus() == Response.Status.OK.getStatusCode())
                responseContext.setStatus(Response.Status.ACCEPTED.getStatusCode());
        }
    }
}
