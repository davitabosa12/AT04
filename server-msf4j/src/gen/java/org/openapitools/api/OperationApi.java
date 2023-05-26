package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.OperationApiService;
import org.openapitools.api.factories.OperationApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Result;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/operation")

@io.swagger.annotations.Api(description = "the operation API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2023-05-25T21:12:10.738765061-03:00[America/Fortaleza]")
public class OperationApi {
    private final OperationApiService delegate = OperationApiServiceFactory.getOperationApi();

    @POST
    @Path("/divisao/{value1}/{value2}")

    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Result.class, tags = { "Operations", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "response", response = Result.class) })
    public Response div(@ApiParam(value = "", required = true) @PathParam("value1") Double value1,
            @ApiParam(value = "", required = true) @PathParam("value2") Double value2)
            throws NotFoundException {
        return delegate.div(value1, value2);
    }

    @POST
    @Path("/multiplicacao/{value1}/{value2}")

    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Result.class, tags = { "Operations", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "response", response = Result.class) })
    public Response mult(@ApiParam(value = "", required = true) @PathParam("value1") Double value1,
            @ApiParam(value = "", required = true) @PathParam("value2") Double value2)
            throws NotFoundException {
        return delegate.mult(value1, value2);
    }

    @POST
    @Path("/soma/{value1}/{value2}")

    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Result.class, tags = { "Operations", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "response", response = Result.class) })
    public Response soma(@ApiParam(value = "", required = true) @PathParam("value1") Double value1,
            @ApiParam(value = "", required = true) @PathParam("value2") Double value2)
            throws NotFoundException {
        return delegate.soma(value1, value2);
    }

    @POST
    @Path("/subtracao/{value1}/{value2}")

    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Result.class, tags = { "Operations", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "response", response = Result.class) })
    public Response sub(@ApiParam(value = "", required = true) @PathParam("value1") Double value1,
            @ApiParam(value = "", required = true) @PathParam("value2") Double value2)
            throws NotFoundException {
        return delegate.sub(value1, value2);
    }
}
