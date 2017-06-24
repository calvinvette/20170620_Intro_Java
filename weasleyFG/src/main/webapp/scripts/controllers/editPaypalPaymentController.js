

angular.module('weasleyFG').controller('EditPaypalPaymentController', function($scope, $routeParams, $location, flash, PaypalPaymentResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.paypalPayment = new PaypalPaymentResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paypalPayment could not be found.'});
            $location.path("/PaypalPayments");
        };
        PaypalPaymentResource.get({PaypalPaymentId:$routeParams.PaypalPaymentId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.paypalPayment);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The paypalPayment was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.paypalPayment.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/PaypalPayments");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paypalPayment was deleted.'});
            $location.path("/PaypalPayments");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.paypalPayment.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});