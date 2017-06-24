

angular.module('weasleyFG').controller('EditOrderPaymentController', function($scope, $routeParams, $location, flash, OrderPaymentResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.orderPayment = new OrderPaymentResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The orderPayment could not be found.'});
            $location.path("/OrderPayments");
        };
        OrderPaymentResource.get({OrderPaymentId:$routeParams.OrderPaymentId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.orderPayment);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The orderPayment was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.orderPayment.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/OrderPayments");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The orderPayment was deleted.'});
            $location.path("/OrderPayments");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.orderPayment.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});