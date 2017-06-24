
angular.module('weasleyFG').controller('NewLinkedInAssociationsController', function ($scope, $location, locationParser, flash, LinkedInAssociationsResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.linkedInAssociations = $scope.linkedInAssociations || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The linkedInAssociations was created successfully.'});
            $location.path('/LinkedInAssociations');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        LinkedInAssociationsResource.save($scope.linkedInAssociations, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/LinkedInAssociations");
    };
});