
angular.module('weasleyFG').controller('NewCreditCardController', function ($scope, $location, locationParser, flash, CreditCardResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.creditCard = $scope.creditCard || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The creditCard was created successfully.'});
            $location.path('/CreditCards');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CreditCardResource.save($scope.creditCard, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/CreditCards");
    };
});