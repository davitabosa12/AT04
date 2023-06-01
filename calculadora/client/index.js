var RemotecalcRest = require('remotecalc_rest');

var client = new RemotecalcRest.ApiClient("http://localhost:9090/")
var api = new RemotecalcRest.OperationsApi(client)
var value1 = 3.4; // {Number} 
var value2 = 0; // {Number} 
var callback = function (error, data, response) {
    if (error) {
        console.error(error);
    } else {
        console.log('API called successfully. Returned data: ' + JSON.stringify(data));
    }
};
api.div(value1, value2, callback);