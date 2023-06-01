package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.OperationsApiService;
import org.openapitools.api.factories.OperationsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import java.net.URI;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/operations")


@io.swagger.annotations.Api(description = "the operations API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2023-05-25T21:12:10.738765061-03:00[America/Fortaleza]")
public class OperationsApi  {
   private final OperationsApiService delegate = OperationsApiServiceFactory.getOperationsApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "returns all registered operations", response = URI.class, responseContainer = "List", tags={ "Operations", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "All available operations", response = URI.class, responseContainer = "List") })
    public Response getOperations()
    throws NotFoundException {
        return delegate.getOperations();
    }
}
