
package org.fedon.matrix.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fedon.matrix.model.Matrix;

/**
 * @author Dmytro Fedonin
 */
public interface MatrixIf {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/mult")
    public Matrix mult(Matrix... matrixs);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/trans")
    public Matrix trans(Matrix matrix);

    @GET
    @Path("/ops")
    public String supportedOps();

    @GET
    @Path("/get1")
    @Produces(MediaType.APPLICATION_JSON)
    public Matrix single();

    @GET
    @Path("/exc/{bool}")
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public String badMethod(@PathParam("bool") boolean flag);
}
