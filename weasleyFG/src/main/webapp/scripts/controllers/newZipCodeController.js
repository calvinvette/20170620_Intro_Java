
angular.module('weasleyFG').controller('NewZipCodeController', function ($scope, $location, locationParser, flash, ZipCodeResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.zipCode = $scope.zipCode || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The zipCode was created successfully.'});
            $location.path('/ZipCodes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ZipCodeResource.save($scope.zipCode, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/ZipCodes");
    };
});