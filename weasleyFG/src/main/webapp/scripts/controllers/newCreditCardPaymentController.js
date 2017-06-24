
angular.module('weasleyFG').controller('NewCreditCardPaymentController', function ($scope, $location, locationParser, flash, CreditCardPaymentResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.creditCardPayment = $scope.creditCardPayment || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The creditCardPayment was created successfully.'});
            $location.path('/CreditCardPayments');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CreditCardPaymentResource.save($scope.creditCardPayment, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/CreditCardPayments");
    };
});