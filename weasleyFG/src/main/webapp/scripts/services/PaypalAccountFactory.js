angular.module('weasleyFG').factory('PaypalAccountResource', function($resource){
    var resource = $resource('rest/paypalaccounts/:PaypalAccountId',{PaypalAccountId:'@paypalAccountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});