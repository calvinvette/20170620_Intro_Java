angular.module('weasleyFG').factory('ZipCodeResource', function($resource){
    var resource = $resource('rest/zipcodes/:ZipCodeId',{ZipCodeId:'@zipCodeId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});