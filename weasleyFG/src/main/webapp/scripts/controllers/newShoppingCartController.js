
angular.module('weasleyFG').controller('NewShoppingCartController', function ($scope, $location, locationParser, flash, ShoppingCartResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.shoppingCart = $scope.shoppingCart || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The shoppingCart was created successfully.'});
            $location.path('/ShoppingCarts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ShoppingCartResource.save($scope.shoppingCart, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/ShoppingCarts");
    };
});