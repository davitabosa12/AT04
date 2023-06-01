package org.openapitools.api.factories;

import org.openapitools.api.OperationApiService;
import org.openapitools.api.impl.OperationApiServiceImpl;

public class OperationApiServiceFactory {
    private static final OperationApiService service = new OperationApiServiceImpl();

    public static OperationApiService getOperationApi() {
        return service;
    }
}
