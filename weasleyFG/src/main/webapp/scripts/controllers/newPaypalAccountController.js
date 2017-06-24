
angular.module('weasleyFG').controller('NewPaypalAccountController', function ($scope, $location, locationParser, flash, PaypalAccountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.paypalAccount = $scope.paypalAccount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The paypalAccount was created successfully.'});
            $location.path('/PaypalAccounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PaypalAccountResource.save($scope.paypalAccount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/PaypalAccounts");
    };
});