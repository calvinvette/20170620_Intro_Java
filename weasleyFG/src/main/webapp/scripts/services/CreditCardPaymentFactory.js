angular.module('weasleyFG').factory('CreditCardPaymentResource', function($resource){
    var resource = $resource('rest/creditcardpayments/:CreditCardPaymentId',{CreditCardPaymentId:'@creditCardPaymentId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});