
angular.module('weasleyFG').controller('NewDeliveryTypeController', function ($scope, $location, locationParser, flash, DeliveryTypeResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.deliveryType = $scope.deliveryType || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The deliveryType was created successfully.'});
            $location.path('/DeliveryTypes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        DeliveryTypeResource.save($scope.deliveryType, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/DeliveryTypes");
    };
});