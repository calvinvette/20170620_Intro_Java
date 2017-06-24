

angular.module('weasleyFG').controller('EditShoppingCartController', function($scope, $routeParams, $location, flash, ShoppingCartResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.shoppingCart = new ShoppingCartResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The shoppingCart could not be found.'});
            $location.path("/ShoppingCarts");
        };
        ShoppingCartResource.get({ShoppingCartId:$routeParams.ShoppingCartId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.shoppingCart);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The shoppingCart was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.shoppingCart.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/ShoppingCarts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The shoppingCart was deleted.'});
            $location.path("/ShoppingCarts");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.shoppingCart.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});