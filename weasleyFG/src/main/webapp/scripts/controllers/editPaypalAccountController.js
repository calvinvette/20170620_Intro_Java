

angular.module('weasleyFG').controller('EditPaypalAccountController', function($scope, $routeParams, $location, flash, PaypalAccountResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.paypalAccount = new PaypalAccountResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paypalAccount could not be found.'});
            $location.path("/PaypalAccounts");
        };
        PaypalAccountResource.get({PaypalAccountId:$routeParams.PaypalAccountId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.paypalAccount);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The paypalAccount was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.paypalAccount.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/PaypalAccounts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paypalAccount was deleted.'});
            $location.path("/PaypalAccounts");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.paypalAccount.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});