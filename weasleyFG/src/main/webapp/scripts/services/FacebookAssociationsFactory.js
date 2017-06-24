angular.module('weasleyFG').factory('FacebookAssociationsResource', function($resource){
    var resource = $resource('rest/facebookassociations/:FacebookAssociationsId',{FacebookAssociationsId:'@associationId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});