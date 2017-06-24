

angular.module('weasleyFG').controller('EditCreditCardPaymentController', function($scope, $routeParams, $location, flash, CreditCardPaymentResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.creditCardPayment = new CreditCardPaymentResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The creditCardPayment could not be found.'});
            $location.path("/CreditCardPayments");
        };
        CreditCardPaymentResource.get({CreditCardPaymentId:$routeParams.CreditCardPaymentId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.creditCardPayment);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The creditCardPayment was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.creditCardPayment.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/CreditCardPayments");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The creditCardPayment was deleted.'});
            $location.path("/CreditCardPayments");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.creditCardPayment.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});