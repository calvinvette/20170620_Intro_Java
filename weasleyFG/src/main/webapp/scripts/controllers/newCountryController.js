
angular.module('weasleyFG').controller('NewCountryController', function ($scope, $location, locationParser, flash, CountryResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.country = $scope.country || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The country was created successfully.'});
            $location.path('/Countries');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CountryResource.save($scope.country, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Countries");
    };
});