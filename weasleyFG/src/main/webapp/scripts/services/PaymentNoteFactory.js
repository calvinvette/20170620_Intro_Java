angular.module('weasleyFG').factory('PaymentNoteResource', function($resource){
    var resource = $resource('rest/paymentnotes/:PaymentNoteId',{PaymentNoteId:'@paymentNoteId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});