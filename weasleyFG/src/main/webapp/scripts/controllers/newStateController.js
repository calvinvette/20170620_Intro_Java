
angular.module('weasleyFG').controller('NewStateController', function ($scope, $location, locationParser, flash, StateResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.state = $scope.state || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The state was created successfully.'});
            $location.path('/States');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        StateResource.save($scope.state, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/States");
    };
});