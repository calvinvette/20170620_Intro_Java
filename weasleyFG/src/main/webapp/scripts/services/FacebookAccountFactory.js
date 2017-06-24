angular.module('weasleyFG').factory('FacebookAccountResource', function($resource){
    var resource = $resource('rest/facebookaccounts/:FacebookAccountId',{FacebookAccountId:'@facebookAccountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});