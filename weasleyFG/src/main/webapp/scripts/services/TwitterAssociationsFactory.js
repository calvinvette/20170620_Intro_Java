angular.module('weasleyFG').factory('TwitterAssociationsResource', function($resource){
    var resource = $resource('rest/twitterassociations/:TwitterAssociationsId',{TwitterAssociationsId:'@associationId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});