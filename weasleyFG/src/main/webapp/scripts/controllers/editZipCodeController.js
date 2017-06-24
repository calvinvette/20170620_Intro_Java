

angular.module('weasleyFG').controller('EditZipCodeController', function($scope, $routeParams, $location, flash, ZipCodeResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.zipCode = new ZipCodeResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The zipCode could not be found.'});
            $location.path("/ZipCodes");
        };
        ZipCodeResource.get({ZipCodeId:$routeParams.ZipCodeId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.zipCode);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The zipCode was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.zipCode.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/ZipCodes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The zipCode was deleted.'});
            $location.path("/ZipCodes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.zipCode.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});