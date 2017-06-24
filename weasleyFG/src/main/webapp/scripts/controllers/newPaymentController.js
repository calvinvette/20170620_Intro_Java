
angular.module('weasleyFG').controller('NewPaymentController', function ($scope, $location, locationParser, flash, PaymentResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.payment = $scope.payment || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The payment was created successfully.'});
            $location.path('/Payments');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PaymentResource.save($scope.payment, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Payments");
    };
});