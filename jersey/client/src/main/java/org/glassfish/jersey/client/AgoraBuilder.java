package org.glassfish.jersey.client;

import java.net.URI;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

/**
 * @author Dmytro Fedonin
 * 
 */
public class AgoraBuilder extends JerseyInvocation.Builder {
    protected AgoraBuilder(URI uri, ClientConfig cc) {
        super(uri, cc);
    }

    @Override
    public <T> T method(String name, GenericType<T> responseType) throws ProcessingException, WebApplicationException {
        System.out.println("Invoke Histrix command here...");
        return super.method(name, responseType);
    }

    @Override
    public <T> T method(String name, Entity<?> entity, GenericType<T> responseType) throws ProcessingException, WebApplicationException {
        System.out.println("Invoke Histrix command with entity here... -- " + entity.getEntity());
        return super.method(name, entity, responseType);
    }
}
