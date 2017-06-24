
angular.module('weasleyFG').controller('NewTwitterAssociationsController', function ($scope, $location, locationParser, flash, TwitterAssociationsResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.twitterAssociations = $scope.twitterAssociations || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The twitterAssociations was created successfully.'});
            $location.path('/TwitterAssociations');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        TwitterAssociationsResource.save($scope.twitterAssociations, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/TwitterAssociations");
    };
});