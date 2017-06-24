angular.module('weasleyFG').factory('EcheckPaymentResource', function($resource){
    var resource = $resource('rest/echeckpayments/:EcheckPaymentId',{EcheckPaymentId:'@echeckPaymentId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});