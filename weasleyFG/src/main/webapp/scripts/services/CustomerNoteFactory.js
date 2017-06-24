angular.module('weasleyFG').factory('CustomerNoteResource', function($resource){
    var resource = $resource('rest/customernotes/:CustomerNoteId',{CustomerNoteId:'@customerNoteId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});