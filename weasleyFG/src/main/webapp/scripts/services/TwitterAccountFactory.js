angular.module('weasleyFG').factory('TwitterAccountResource', function($resource){
    var resource = $resource('rest/twitteraccounts/:TwitterAccountId',{TwitterAccountId:'@twitterAccountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});