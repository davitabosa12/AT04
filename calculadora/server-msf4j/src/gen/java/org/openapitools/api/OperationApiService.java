package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import org.openapitools.model.Result;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2023-05-25T21:12:10.738765061-03:00[America/Fortaleza]")
public abstract class OperationApiService {
    public abstract Response div(Double value1
 ,Double value2
 ) throws NotFoundException;
    public abstract Response mult(Double value1
 ,Double value2
 ) throws NotFoundException;
    public abstract Response soma(Double value1
 ,Double value2
 ) throws NotFoundException;
    public abstract Response sub(Double value1
 ,Double value2
 ) throws NotFoundException;
}
