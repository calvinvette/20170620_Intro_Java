angular.module('weasleyFG').factory('ShoppingCartResource', function($resource){
    var resource = $resource('rest/shoppingcarts/:ShoppingCartId',{ShoppingCartId:'@shoppingCartId'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});