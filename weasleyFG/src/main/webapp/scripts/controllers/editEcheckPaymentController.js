

angular.module('weasleyFG').controller('EditEcheckPaymentController', function($scope, $routeParams, $location, flash, EcheckPaymentResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.echeckPayment = new EcheckPaymentResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The echeckPayment could not be found.'});
            $location.path("/EcheckPayments");
        };
        EcheckPaymentResource.get({EcheckPaymentId:$routeParams.EcheckPaymentId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.echeckPayment);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The echeckPayment was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.echeckPayment.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/EcheckPayments");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The echeckPayment was deleted.'});
            $location.path("/EcheckPayments");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.echeckPayment.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});