
angular.module('weasleyFG').controller('NewPaypalPaymentController', function ($scope, $location, locationParser, flash, PaypalPaymentResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.paypalPayment = $scope.paypalPayment || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The paypalPayment was created successfully.'});
            $location.path('/PaypalPayments');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PaypalPaymentResource.save($scope.paypalPayment, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/PaypalPayments");
    };
});