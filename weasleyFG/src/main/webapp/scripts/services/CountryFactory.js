angular.module('weasleyFG').factory('CountryResource', function($resource){
    var resource = $resource('rest/countries/:CountryId',{CountryId:'@countryId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});