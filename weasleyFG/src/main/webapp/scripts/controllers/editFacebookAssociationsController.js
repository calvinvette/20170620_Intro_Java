

angular.module('weasleyFG').controller('EditFacebookAssociationsController', function($scope, $routeParams, $location, flash, FacebookAssociationsResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.facebookAssociations = new FacebookAssociationsResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The facebookAssociations could not be found.'});
            $location.path("/FacebookAssociations");
        };
        FacebookAssociationsResource.get({FacebookAssociationsId:$routeParams.FacebookAssociationsId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.facebookAssociations);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The facebookAssociations was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.facebookAssociations.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/FacebookAssociations");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The facebookAssociations was deleted.'});
            $location.path("/FacebookAssociations");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.facebookAssociations.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});