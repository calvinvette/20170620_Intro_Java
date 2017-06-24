angular.module('weasleyFG').factory('HitCountResource', function($resource){
    var resource = $resource('rest/hitcounts/:HitCountId',{HitCountId:'@hitCountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});