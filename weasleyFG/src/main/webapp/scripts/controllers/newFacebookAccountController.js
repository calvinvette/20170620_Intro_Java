
angular.module('weasleyFG').controller('NewFacebookAccountController', function ($scope, $location, locationParser, flash, FacebookAccountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.facebookAccount = $scope.facebookAccount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The facebookAccount was created successfully.'});
            $location.path('/FacebookAccounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        FacebookAccountResource.save($scope.facebookAccount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/FacebookAccounts");
    };
});