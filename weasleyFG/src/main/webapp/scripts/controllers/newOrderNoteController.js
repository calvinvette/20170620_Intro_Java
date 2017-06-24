
angular.module('weasleyFG').controller('NewOrderNoteController', function ($scope, $location, locationParser, flash, OrderNoteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.orderNote = $scope.orderNote || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The orderNote was created successfully.'});
            $location.path('/OrderNotes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OrderNoteResource.save($scope.orderNote, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/OrderNotes");
    };
});