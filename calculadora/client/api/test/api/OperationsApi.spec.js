/**
 * remotecalc-rest
 * Calculadora REST API
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', process.cwd()+'/src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require(process.cwd()+'/src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.RemotecalcRest);
  }
}(this, function(expect, RemotecalcRest) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new RemotecalcRest.OperationsApi();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('OperationsApi', function() {
    describe('div', function() {
      it('should call div successfully', function(done) {
        //uncomment below and update the code to test div
        //instance.div(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('getOperations', function() {
      it('should call getOperations successfully', function(done) {
        //uncomment below and update the code to test getOperations
        //instance.getOperations(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('mult', function() {
      it('should call mult successfully', function(done) {
        //uncomment below and update the code to test mult
        //instance.mult(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('soma', function() {
      it('should call soma successfully', function(done) {
        //uncomment below and update the code to test soma
        //instance.soma(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('sub', function() {
      it('should call sub successfully', function(done) {
        //uncomment below and update the code to test sub
        //instance.sub(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
  });

}));