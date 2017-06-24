angular.module('weasleyFG').factory('LinkedInAssociationsResource', function($resource){
    var resource = $resource('rest/linkedinassociations/:LinkedInAssociationsId',{LinkedInAssociationsId:'@associationId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});