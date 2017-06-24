angular.module('weasleyFG').factory('OrderPaymentResource', function($resource){
    var resource = $resource('rest/orderpayments/:OrderPaymentId',{OrderPaymentId:'@orderPaymentId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});