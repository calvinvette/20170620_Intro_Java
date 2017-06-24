
angular.module('weasleyFG').controller('NewHitCountController', function ($scope, $location, locationParser, flash, HitCountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.hitCount = $scope.hitCount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The hitCount was created successfully.'});
            $location.path('/HitCounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        HitCountResource.save($scope.hitCount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/HitCounts");
    };
});