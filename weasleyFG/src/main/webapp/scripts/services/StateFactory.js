angular.module('weasleyFG').factory('StateResource', function($resource){
    var resource = $resource('rest/states/:StateId',{StateId:'@stateId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});