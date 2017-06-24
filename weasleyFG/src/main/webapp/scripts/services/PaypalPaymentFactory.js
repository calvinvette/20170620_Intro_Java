angular.module('weasleyFG').factory('PaypalPaymentResource', function($resource){
    var resource = $resource('rest/paypalpayments/:PaypalPaymentId',{PaypalPaymentId:'@paypalPaymentId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});