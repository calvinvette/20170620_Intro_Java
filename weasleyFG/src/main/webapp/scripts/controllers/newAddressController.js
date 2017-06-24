
angular.module('weasleyFG').controller('NewAddressController', function ($scope, $location, locationParser, flash, AddressResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.address = $scope.address || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The address was created successfully.'});
            $location.path('/Addresses');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        AddressResource.save($scope.address, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Addresses");
    };
});