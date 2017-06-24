

angular.module('weasleyFG').controller('EditFacebookAccountController', function($scope, $routeParams, $location, flash, FacebookAccountResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.facebookAccount = new FacebookAccountResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The facebookAccount could not be found.'});
            $location.path("/FacebookAccounts");
        };
        FacebookAccountResource.get({FacebookAccountId:$routeParams.FacebookAccountId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.facebookAccount);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The facebookAccount was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.facebookAccount.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/FacebookAccounts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The facebookAccount was deleted.'});
            $location.path("/FacebookAccounts");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.facebookAccount.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});