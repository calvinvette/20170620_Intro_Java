
angular.module('weasleyFG').controller('NewOrderStatusController', function ($scope, $location, locationParser, flash, OrderStatusResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.orderStatus = $scope.orderStatus || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The orderStatus was created successfully.'});
            $location.path('/OrderStatuses');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OrderStatusResource.save($scope.orderStatus, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/OrderStatuses");
    };
});