angular.module('weasleyFG').factory('ProductNoteResource', function($resource){
    var resource = $resource('rest/productnotes/:ProductNoteId',{ProductNoteId:'@productNoteId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});