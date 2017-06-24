
angular.module('weasleyFG').controller('NewUserIdController', function ($scope, $location, locationParser, flash, UserIdResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.userId = $scope.userId || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The userId was created successfully.'});
            $location.path('/UserIds');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        UserIdResource.save($scope.userId, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/UserIds");
    };
});