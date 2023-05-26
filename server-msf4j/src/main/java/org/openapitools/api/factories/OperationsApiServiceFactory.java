package org.openapitools.api.factories;

import org.openapitools.api.OperationsApiService;
import org.openapitools.api.impl.OperationsApiServiceImpl;

public class OperationsApiServiceFactory {
    private static final OperationsApiService service = new OperationsApiServiceImpl();

    public static OperationsApiService getOperationsApi() {
        return service;
    }
}
