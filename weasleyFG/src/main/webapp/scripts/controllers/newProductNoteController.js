
angular.module('weasleyFG').controller('NewProductNoteController', function ($scope, $location, locationParser, flash, ProductNoteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.productNote = $scope.productNote || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The productNote was created successfully.'});
            $location.path('/ProductNotes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ProductNoteResource.save($scope.productNote, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/ProductNotes");
    };
});