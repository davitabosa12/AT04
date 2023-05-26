# RemotecalcRest.OperationsApi

All URIs are relative to *https://virtserver.swaggerhub.com/WINDSON_1/Calculadora/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**div**](OperationsApi.md#div) | **POST** /operation/divisao/{value1}/{value2} | 
[**getOperations**](OperationsApi.md#getOperations) | **GET** /operations | 
[**mult**](OperationsApi.md#mult) | **POST** /operation/multiplicacao/{value1}/{value2} | 
[**soma**](OperationsApi.md#soma) | **POST** /operation/soma/{value1}/{value2} | 
[**sub**](OperationsApi.md#sub) | **POST** /operation/subtracao/{value1}/{value2} | 



## div

> Result div(value1, value2)



### Example

```javascript
import RemotecalcRest from 'remotecalc_rest';

let apiInstance = new RemotecalcRest.OperationsApi();
let value1 = 3.4; // Number | 
let value2 = 3.4; // Number | 
apiInstance.div(value1, value2, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **value1** | **Number**|  | 
 **value2** | **Number**|  | 

### Return type

[**Result**](Result.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getOperations

> [String] getOperations()



returns all registered operations

### Example

```javascript
import RemotecalcRest from 'remotecalc_rest';

let apiInstance = new RemotecalcRest.OperationsApi();
apiInstance.getOperations((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

**[String]**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## mult

> Result mult(value1, value2)



### Example

```javascript
import RemotecalcRest from 'remotecalc_rest';

let apiInstance = new RemotecalcRest.OperationsApi();
let value1 = 3.4; // Number | 
let value2 = 3.4; // Number | 
apiInstance.mult(value1, value2, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **value1** | **Number**|  | 
 **value2** | **Number**|  | 

### Return type

[**Result**](Result.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## soma

> Result soma(value1, value2)



### Example

```javascript
import RemotecalcRest from 'remotecalc_rest';

let apiInstance = new RemotecalcRest.OperationsApi();
let value1 = 3.4; // Number | 
let value2 = 3.4; // Number | 
apiInstance.soma(value1, value2, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **value1** | **Number**|  | 
 **value2** | **Number**|  | 

### Return type

[**Result**](Result.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## sub

> Result sub(value1, value2)



### Example

```javascript
import RemotecalcRest from 'remotecalc_rest';

let apiInstance = new RemotecalcRest.OperationsApi();
let value1 = 3.4; // Number | 
let value2 = 3.4; // Number | 
apiInstance.sub(value1, value2, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **value1** | **Number**|  | 
 **value2** | **Number**|  | 

### Return type

[**Result**](Result.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

