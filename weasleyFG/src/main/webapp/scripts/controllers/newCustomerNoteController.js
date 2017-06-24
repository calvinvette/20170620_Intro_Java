
angular.module('weasleyFG').controller('NewCustomerNoteController', function ($scope, $location, locationParser, flash, CustomerNoteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.customerNote = $scope.customerNote || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The customerNote was created successfully.'});
            $location.path('/CustomerNotes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CustomerNoteResource.save($scope.customerNote, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/CustomerNotes");
    };
});