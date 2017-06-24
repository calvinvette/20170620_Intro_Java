
angular.module('weasleyFG').controller('NewEmailAddressController', function ($scope, $location, locationParser, flash, EmailAddressResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.emailAddress = $scope.emailAddress || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The emailAddress was created successfully.'});
            $location.path('/EmailAddresses');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        EmailAddressResource.save($scope.emailAddress, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/EmailAddresses");
    };
});