
angular.module('weasleyFG').controller('NewNoteController', function ($scope, $location, locationParser, flash, NoteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.note = $scope.note || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The note was created successfully.'});
            $location.path('/Notes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        NoteResource.save($scope.note, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Notes");
    };
});