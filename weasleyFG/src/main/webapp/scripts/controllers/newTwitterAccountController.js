
angular.module('weasleyFG').controller('NewTwitterAccountController', function ($scope, $location, locationParser, flash, TwitterAccountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.twitterAccount = $scope.twitterAccount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The twitterAccount was created successfully.'});
            $location.path('/TwitterAccounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        TwitterAccountResource.save($scope.twitterAccount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/TwitterAccounts");
    };
});