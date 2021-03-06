

angular.module('weasleyFG').controller('EditOrderStatusController', function($scope, $routeParams, $location, flash, OrderStatusResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.orderStatus = new OrderStatusResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The orderStatus could not be found.'});
            $location.path("/OrderStatuses");
        };
        OrderStatusResource.get({OrderStatusId:$routeParams.OrderStatusId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.orderStatus);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The orderStatus was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.orderStatus.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/OrderStatuses");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The orderStatus was deleted.'});
            $location.path("/OrderStatuses");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.orderStatus.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});