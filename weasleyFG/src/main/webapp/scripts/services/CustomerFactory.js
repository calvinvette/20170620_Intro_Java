angular.module('weasleyFG').factory('CustomerResource', function($resource){
    var resource = $resource('rest/customers/:CustomerId',{CustomerId:'@customerId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});