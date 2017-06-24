

angular.module('weasleyFG').controller('EditPaymentNoteController', function($scope, $routeParams, $location, flash, PaymentNoteResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.paymentNote = new PaymentNoteResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paymentNote could not be found.'});
            $location.path("/PaymentNotes");
        };
        PaymentNoteResource.get({PaymentNoteId:$routeParams.PaymentNoteId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.paymentNote);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The paymentNote was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.paymentNote.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/PaymentNotes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The paymentNote was deleted.'});
            $location.path("/PaymentNotes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.paymentNote.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});