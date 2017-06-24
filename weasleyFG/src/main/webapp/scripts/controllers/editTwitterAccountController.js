

angular.module('weasleyFG').controller('EditTwitterAccountController', function($scope, $routeParams, $location, flash, TwitterAccountResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.twitterAccount = new TwitterAccountResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The twitterAccount could not be found.'});
            $location.path("/TwitterAccounts");
        };
        TwitterAccountResource.get({TwitterAccountId:$routeParams.TwitterAccountId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.twitterAccount);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The twitterAccount was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.twitterAccount.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/TwitterAccounts");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The twitterAccount was deleted.'});
            $location.path("/TwitterAccounts");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.twitterAccount.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});