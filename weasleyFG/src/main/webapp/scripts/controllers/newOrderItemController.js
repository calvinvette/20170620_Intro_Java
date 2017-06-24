
angular.module('weasleyFG').controller('NewOrderItemController', function ($scope, $location, locationParser, flash, OrderItemResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.orderItem = $scope.orderItem || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The orderItem was created successfully.'});
            $location.path('/OrderItems');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OrderItemResource.save($scope.orderItem, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/OrderItems");
    };
});