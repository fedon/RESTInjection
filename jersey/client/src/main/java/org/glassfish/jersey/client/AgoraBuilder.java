package org.glassfish.jersey.client;

import java.net.URI;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.odesk.agora.hystrix.O2HystrixCommand;

/**
 * @author Dmytro Fedonin
 * 
 */
public class AgoraBuilder extends JerseyInvocation.Builder {
    private final Log log = LogFactory.getLog(this.getClass());

    protected AgoraBuilder(URI uri, ClientConfig cc) {
        super(uri, cc);
    }

    @Override
    public <T> T method(final String name, final GenericType<T> responseType) throws ProcessingException, WebApplicationException {
        log.info("Invoke Histrix command here...");

        return new O2HystrixCommand<T>("matrix", name) {
            @Override
            protected T run() throws Exception {
                return methodCall(name, responseType);
            }
        }.execute();
    }

    <T> T methodCall(String name, GenericType<T> responseType) throws ProcessingException, WebApplicationException {
        log.info("Inside Histrix command... -- " + name);
        return super.method(name, responseType);
    }

    @Override
    public <T> T method(final String name, final Entity<?> entity, final GenericType<T> responseType) throws ProcessingException,
            WebApplicationException {
        log.debug("Invoke Histrix command with entity here... -- " + entity.getEntity());

        return new O2HystrixCommand<T>("matrix", name) {
            @Override
            protected T run() throws Exception {
                return methodCall(name, entity, responseType);
            }
        }.execute();
    }

    <T> T methodCall(String name, Entity<?> entity, GenericType<T> responseType) throws ProcessingException, WebApplicationException {
        log.debug("Inside Histrix command with entity...");
        return super.method(name, entity, responseType);
    }
}
