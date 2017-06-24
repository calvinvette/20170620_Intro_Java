angular.module('weasleyFG').factory('OrderNoteResource', function($resource){
    var resource = $resource('rest/ordernotes/:OrderNoteId',{OrderNoteId:'@orderNoteId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});