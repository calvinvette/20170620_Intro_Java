angular.module('weasleyFG').factory('NoteResource', function($resource){
    var resource = $resource('rest/notes/:NoteId',{NoteId:'@noteId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});