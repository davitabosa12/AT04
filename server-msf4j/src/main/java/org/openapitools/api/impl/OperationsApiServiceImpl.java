package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.*;

import java.net.URI;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2023-05-25T21:12:10.738765061-03:00[America/Fortaleza]")
public class OperationsApiServiceImpl extends OperationsApiService {
    @Override
    public Response getOperations() throws NotFoundException {
        // do some magic!
        String[] operations = { "soma", "subtracao", "divisao", "multiplicacao" };
        return Response.ok().entity(operations).build();
    }
}
