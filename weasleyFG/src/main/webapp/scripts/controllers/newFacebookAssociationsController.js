
angular.module('weasleyFG').controller('NewFacebookAssociationsController', function ($scope, $location, locationParser, flash, FacebookAssociationsResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.facebookAssociations = $scope.facebookAssociations || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The facebookAssociations was created successfully.'});
            $location.path('/FacebookAssociations');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        FacebookAssociationsResource.save($scope.facebookAssociations, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/FacebookAssociations");
    };
});