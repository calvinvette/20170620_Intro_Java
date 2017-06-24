
angular.module('weasleyFG').controller('NewOrdersController', function ($scope, $location, locationParser, flash, OrdersResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.orders = $scope.orders || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The orders was created successfully.'});
            $location.path('/Orders');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OrdersResource.save($scope.orders, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Orders");
    };
});