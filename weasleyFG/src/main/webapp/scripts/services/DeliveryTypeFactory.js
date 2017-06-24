angular.module('weasleyFG').factory('DeliveryTypeResource', function($resource){
    var resource = $resource('rest/deliverytypes/:DeliveryTypeId',{DeliveryTypeId:'@deliveryTypeId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});