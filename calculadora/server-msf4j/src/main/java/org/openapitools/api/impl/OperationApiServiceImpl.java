package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.openapitools.model.Result;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2023-05-25T21:12:10.738765061-03:00[America/Fortaleza]")
public class OperationApiServiceImpl extends OperationApiService {
    @Override
    public Response div(Double value1, Double value2) throws NotFoundException {
        // do some magic!
        Result result = new Result();
        if (value2 == 0) {
            result.setError(true);
            return Response.ok(result).build();
        }
        result.setValue(value1 / value2);
        return Response.ok().entity(result).build();
    }

    @Override
    public Response mult(Double value1, Double value2) throws NotFoundException {
        // do some magic!
        Result result = new Result();
        result.setValue(value1 * value2);
        return Response.ok().entity(result).build();
    }

    @Override
    public Response soma(Double value1, Double value2) throws NotFoundException {
        // do some magic!
        Result result = new Result();
        result.setValue(value1 + value2);
        return Response.ok().entity(result).build();
    }

    @Override
    public Response sub(Double value1, Double value2) throws NotFoundException {
        // do some magic!
        Result result = new Result();
        result.setValue(value1 - value2);
        return Response.ok().entity(result).build();
    }
}
