

angular.module('weasleyFG').controller('EditCustomerNoteController', function($scope, $routeParams, $location, flash, CustomerNoteResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.customerNote = new CustomerNoteResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The customerNote could not be found.'});
            $location.path("/CustomerNotes");
        };
        CustomerNoteResource.get({CustomerNoteId:$routeParams.CustomerNoteId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.customerNote);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The customerNote was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.customerNote.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/CustomerNotes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The customerNote was deleted.'});
            $location.path("/CustomerNotes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.customerNote.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});