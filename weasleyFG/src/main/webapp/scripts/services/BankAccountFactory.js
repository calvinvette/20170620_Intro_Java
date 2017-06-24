angular.module('weasleyFG').factory('BankAccountResource', function($resource){
    var resource = $resource('rest/bankaccounts/:BankAccountId',{BankAccountId:'@bankAccountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});