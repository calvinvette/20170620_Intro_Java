angular.module('weasleyFG').factory('UserIdResource', function($resource){
    var resource = $resource('rest/userids/:UserIdId',{UserIdId:'@userId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});