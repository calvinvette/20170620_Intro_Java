

angular.module('weasleyFG').controller('EditDeliveryTypeController', function($scope, $routeParams, $location, flash, DeliveryTypeResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.deliveryType = new DeliveryTypeResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The deliveryType could not be found.'});
            $location.path("/DeliveryTypes");
        };
        DeliveryTypeResource.get({DeliveryTypeId:$routeParams.DeliveryTypeId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.deliveryType);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The deliveryType was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.deliveryType.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/DeliveryTypes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The deliveryType was deleted.'});
            $location.path("/DeliveryTypes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.deliveryType.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});