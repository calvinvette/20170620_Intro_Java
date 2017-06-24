angular.module('weasleyFG').factory('LinkedInAccountResource', function($resource){
    var resource = $resource('rest/linkedinaccounts/:LinkedInAccountId',{LinkedInAccountId:'@linkedInAccountId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});