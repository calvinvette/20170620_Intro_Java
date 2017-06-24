angular.module('weasleyFG').factory('CreditCardResource', function($resource){
    var resource = $resource('rest/creditcards/:CreditCardId',{CreditCardId:'@creditCardId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});