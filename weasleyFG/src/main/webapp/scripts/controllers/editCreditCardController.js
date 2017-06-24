

angular.module('weasleyFG').controller('EditCreditCardController', function($scope, $routeParams, $location, flash, CreditCardResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.creditCard = new CreditCardResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The creditCard could not be found.'});
            $location.path("/CreditCards");
        };
        CreditCardResource.get({CreditCardId:$routeParams.CreditCardId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.creditCard);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The creditCard was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.creditCard.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/CreditCards");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The creditCard was deleted.'});
            $location.path("/CreditCards");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.creditCard.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});