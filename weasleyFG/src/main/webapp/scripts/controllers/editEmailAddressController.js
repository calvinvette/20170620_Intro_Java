

angular.module('weasleyFG').controller('EditEmailAddressController', function($scope, $routeParams, $location, flash, EmailAddressResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.emailAddress = new EmailAddressResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The emailAddress could not be found.'});
            $location.path("/EmailAddresses");
        };
        EmailAddressResource.get({EmailAddressId:$routeParams.EmailAddressId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.emailAddress);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The emailAddress was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.emailAddress.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/EmailAddresses");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The emailAddress was deleted.'});
            $location.path("/EmailAddresses");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.emailAddress.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});