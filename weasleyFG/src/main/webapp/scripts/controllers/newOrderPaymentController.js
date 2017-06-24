
angular.module('weasleyFG').controller('NewOrderPaymentController', function ($scope, $location, locationParser, flash, OrderPaymentResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.orderPayment = $scope.orderPayment || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The orderPayment was created successfully.'});
            $location.path('/OrderPayments');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OrderPaymentResource.save($scope.orderPayment, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/OrderPayments");
    };
});