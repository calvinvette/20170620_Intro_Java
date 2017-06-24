angular.module('weasleyFG').factory('EmailAddressResource', function($resource){
    var resource = $resource('rest/emailaddresses/:EmailAddressId',{EmailAddressId:'@emailAddressId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});