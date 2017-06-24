

angular.module('weasleyFG').controller('EditLinkedInAccountController', function($scope, $routeParams, $location, flash, LinkedInAccountResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.linkedInAccount = new LinkedInAccountResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The linkedInAccount could not be found.'});
            $location.path("/LinkedInAccounts");
        };
        LinkedInAccountResource.get({LinkedInAccountId:$routeParams.LinkedInAccountId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.linkedInAccount);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The linkedInAccount was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.linkedInAccount.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/LinkedInAccounts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The linkedInAccount was deleted.'});
            $location.path("/LinkedInAccounts");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.linkedInAccount.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});