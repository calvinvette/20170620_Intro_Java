angular.module('weasleyFG').factory('OrderStatusResource', function($resource){
    var resource = $resource('rest/orderstatuses/:OrderStatusId',{OrderStatusId:'@orderStatusId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});