
angular.module('weasleyFG').controller('NewBankAccountController', function ($scope, $location, locationParser, flash, BankAccountResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.bankAccount = $scope.bankAccount || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The bankAccount was created successfully.'});
            $location.path('/BankAccounts');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        BankAccountResource.save($scope.bankAccount, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/BankAccounts");
    };
});