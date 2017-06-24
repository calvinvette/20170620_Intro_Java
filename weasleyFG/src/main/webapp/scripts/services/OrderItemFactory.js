angular.module('weasleyFG').factory('OrderItemResource', function($resource){
    var resource = $resource('rest/orderitems/:OrderItemId',{OrderItemId:'@orderItemId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});