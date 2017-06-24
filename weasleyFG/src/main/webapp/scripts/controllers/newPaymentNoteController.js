
angular.module('weasleyFG').controller('NewPaymentNoteController', function ($scope, $location, locationParser, flash, PaymentNoteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.paymentNote = $scope.paymentNote || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The paymentNote was created successfully.'});
            $location.path('/PaymentNotes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PaymentNoteResource.save($scope.paymentNote, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/PaymentNotes");
    };
});