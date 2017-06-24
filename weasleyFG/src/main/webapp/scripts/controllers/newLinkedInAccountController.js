
angular.module('weasleyFG').controller('NewLinkedInAccountController', function ($scope, $location, locationParser, flash, LinkedInAccountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.linkedInAccount = $scope.linkedInAccount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The linkedInAccount was created successfully.'});
            $location.path('/LinkedInAccounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        LinkedInAccountResource.save($scope.linkedInAccount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/LinkedInAccounts");
    };
});