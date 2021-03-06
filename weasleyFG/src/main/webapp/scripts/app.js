'use strict';

angular.module('weasleyFG',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Addresses',{templateUrl:'views/Address/search.html',controller:'SearchAddressController'})
      .when('/Addresses/new',{templateUrl:'views/Address/detail.html',controller:'NewAddressController'})
      .when('/Addresses/edit/:AddressId',{templateUrl:'views/Address/detail.html',controller:'EditAddressController'})
      .when('/BankAccounts',{templateUrl:'views/BankAccount/search.html',controller:'SearchBankAccountController'})
      .when('/BankAccounts/new',{templateUrl:'views/BankAccount/detail.html',controller:'NewBankAccountController'})
      .when('/BankAccounts/edit/:BankAccountId',{templateUrl:'views/BankAccount/detail.html',controller:'EditBankAccountController'})
      .when('/Countries',{templateUrl:'views/Country/search.html',controller:'SearchCountryController'})
      .when('/Countries/new',{templateUrl:'views/Country/detail.html',controller:'NewCountryController'})
      .when('/Countries/edit/:CountryId',{templateUrl:'views/Country/detail.html',controller:'EditCountryController'})
      .when('/CreditCards',{templateUrl:'views/CreditCard/search.html',controller:'SearchCreditCardController'})
      .when('/CreditCards/new',{templateUrl:'views/CreditCard/detail.html',controller:'NewCreditCardController'})
      .when('/CreditCards/edit/:CreditCardId',{templateUrl:'views/CreditCard/detail.html',controller:'EditCreditCardController'})
      .when('/CreditCardPayments',{templateUrl:'views/CreditCardPayment/search.html',controller:'SearchCreditCardPaymentController'})
      .when('/CreditCardPayments/new',{templateUrl:'views/CreditCardPayment/detail.html',controller:'NewCreditCardPaymentController'})
      .when('/CreditCardPayments/edit/:CreditCardPaymentId',{templateUrl:'views/CreditCardPayment/detail.html',controller:'EditCreditCardPaymentController'})
      .when('/Customers',{templateUrl:'views/Customer/search.html',controller:'SearchCustomerController'})
      .when('/Customers/new',{templateUrl:'views/Customer/detail.html',controller:'NewCustomerController'})
      .when('/Customers/edit/:CustomerId',{templateUrl:'views/Customer/detail.html',controller:'EditCustomerController'})
      .when('/CustomerNotes',{templateUrl:'views/CustomerNote/search.html',controller:'SearchCustomerNoteController'})
      .when('/CustomerNotes/new',{templateUrl:'views/CustomerNote/detail.html',controller:'NewCustomerNoteController'})
      .when('/CustomerNotes/edit/:CustomerNoteId',{templateUrl:'views/CustomerNote/detail.html',controller:'EditCustomerNoteController'})
      .when('/DeliveryTypes',{templateUrl:'views/DeliveryType/search.html',controller:'SearchDeliveryTypeController'})
      .when('/DeliveryTypes/new',{templateUrl:'views/DeliveryType/detail.html',controller:'NewDeliveryTypeController'})
      .when('/DeliveryTypes/edit/:DeliveryTypeId',{templateUrl:'views/DeliveryType/detail.html',controller:'EditDeliveryTypeController'})
      .when('/EcheckPayments',{templateUrl:'views/EcheckPayment/search.html',controller:'SearchEcheckPaymentController'})
      .when('/EcheckPayments/new',{templateUrl:'views/EcheckPayment/detail.html',controller:'NewEcheckPaymentController'})
      .when('/EcheckPayments/edit/:EcheckPaymentId',{templateUrl:'views/EcheckPayment/detail.html',controller:'EditEcheckPaymentController'})
      .when('/EmailAddresses',{templateUrl:'views/EmailAddress/search.html',controller:'SearchEmailAddressController'})
      .when('/EmailAddresses/new',{templateUrl:'views/EmailAddress/detail.html',controller:'NewEmailAddressController'})
      .when('/EmailAddresses/edit/:EmailAddressId',{templateUrl:'views/EmailAddress/detail.html',controller:'EditEmailAddressController'})
      .when('/FacebookAccounts',{templateUrl:'views/FacebookAccount/search.html',controller:'SearchFacebookAccountController'})
      .when('/FacebookAccounts/new',{templateUrl:'views/FacebookAccount/detail.html',controller:'NewFacebookAccountController'})
      .when('/FacebookAccounts/edit/:FacebookAccountId',{templateUrl:'views/FacebookAccount/detail.html',controller:'EditFacebookAccountController'})
      .when('/FacebookAssociations',{templateUrl:'views/FacebookAssociations/search.html',controller:'SearchFacebookAssociationsController'})
      .when('/FacebookAssociations/new',{templateUrl:'views/FacebookAssociations/detail.html',controller:'NewFacebookAssociationsController'})
      .when('/FacebookAssociations/edit/:FacebookAssociationsId',{templateUrl:'views/FacebookAssociations/detail.html',controller:'EditFacebookAssociationsController'})
      .when('/HitCounts',{templateUrl:'views/HitCount/search.html',controller:'SearchHitCountController'})
      .when('/HitCounts/new',{templateUrl:'views/HitCount/detail.html',controller:'NewHitCountController'})
      .when('/HitCounts/edit/:HitCountId',{templateUrl:'views/HitCount/detail.html',controller:'EditHitCountController'})
      .when('/LinkedInAccounts',{templateUrl:'views/LinkedInAccount/search.html',controller:'SearchLinkedInAccountController'})
      .when('/LinkedInAccounts/new',{templateUrl:'views/LinkedInAccount/detail.html',controller:'NewLinkedInAccountController'})
      .when('/LinkedInAccounts/edit/:LinkedInAccountId',{templateUrl:'views/LinkedInAccount/detail.html',controller:'EditLinkedInAccountController'})
      .when('/LinkedInAssociations',{templateUrl:'views/LinkedInAssociations/search.html',controller:'SearchLinkedInAssociationsController'})
      .when('/LinkedInAssociations/new',{templateUrl:'views/LinkedInAssociations/detail.html',controller:'NewLinkedInAssociationsController'})
      .when('/LinkedInAssociations/edit/:LinkedInAssociationsId',{templateUrl:'views/LinkedInAssociations/detail.html',controller:'EditLinkedInAssociationsController'})
      .when('/Notes',{templateUrl:'views/Note/search.html',controller:'SearchNoteController'})
      .when('/Notes/new',{templateUrl:'views/Note/detail.html',controller:'NewNoteController'})
      .when('/Notes/edit/:NoteId',{templateUrl:'views/Note/detail.html',controller:'EditNoteController'})
      .when('/OrderItems',{templateUrl:'views/OrderItem/search.html',controller:'SearchOrderItemController'})
      .when('/OrderItems/new',{templateUrl:'views/OrderItem/detail.html',controller:'NewOrderItemController'})
      .when('/OrderItems/edit/:OrderItemId',{templateUrl:'views/OrderItem/detail.html',controller:'EditOrderItemController'})
      .when('/OrderNotes',{templateUrl:'views/OrderNote/search.html',controller:'SearchOrderNoteController'})
      .when('/OrderNotes/new',{templateUrl:'views/OrderNote/detail.html',controller:'NewOrderNoteController'})
      .when('/OrderNotes/edit/:OrderNoteId',{templateUrl:'views/OrderNote/detail.html',controller:'EditOrderNoteController'})
      .when('/OrderPayments',{templateUrl:'views/OrderPayment/search.html',controller:'SearchOrderPaymentController'})
      .when('/OrderPayments/new',{templateUrl:'views/OrderPayment/detail.html',controller:'NewOrderPaymentController'})
      .when('/OrderPayments/edit/:OrderPaymentId',{templateUrl:'views/OrderPayment/detail.html',controller:'EditOrderPaymentController'})
      .when('/OrderStatuses',{templateUrl:'views/OrderStatus/search.html',controller:'SearchOrderStatusController'})
      .when('/OrderStatuses/new',{templateUrl:'views/OrderStatus/detail.html',controller:'NewOrderStatusController'})
      .when('/OrderStatuses/edit/:OrderStatusId',{templateUrl:'views/OrderStatus/detail.html',controller:'EditOrderStatusController'})
      .when('/Orders',{templateUrl:'views/Orders/search.html',controller:'SearchOrdersController'})
      .when('/Orders/new',{templateUrl:'views/Orders/detail.html',controller:'NewOrdersController'})
      .when('/Orders/edit/:OrdersId',{templateUrl:'views/Orders/detail.html',controller:'EditOrdersController'})
      .when('/Payments',{templateUrl:'views/Payment/search.html',controller:'SearchPaymentController'})
      .when('/Payments/new',{templateUrl:'views/Payment/detail.html',controller:'NewPaymentController'})
      .when('/Payments/edit/:PaymentId',{templateUrl:'views/Payment/detail.html',controller:'EditPaymentController'})
      .when('/PaymentNotes',{templateUrl:'views/PaymentNote/search.html',controller:'SearchPaymentNoteController'})
      .when('/PaymentNotes/new',{templateUrl:'views/PaymentNote/detail.html',controller:'NewPaymentNoteController'})
      .when('/PaymentNotes/edit/:PaymentNoteId',{templateUrl:'views/PaymentNote/detail.html',controller:'EditPaymentNoteController'})
      .when('/PaypalAccounts',{templateUrl:'views/PaypalAccount/search.html',controller:'SearchPaypalAccountController'})
      .when('/PaypalAccounts/new',{templateUrl:'views/PaypalAccount/detail.html',controller:'NewPaypalAccountController'})
      .when('/PaypalAccounts/edit/:PaypalAccountId',{templateUrl:'views/PaypalAccount/detail.html',controller:'EditPaypalAccountController'})
      .when('/PaypalPayments',{templateUrl:'views/PaypalPayment/search.html',controller:'SearchPaypalPaymentController'})
      .when('/PaypalPayments/new',{templateUrl:'views/PaypalPayment/detail.html',controller:'NewPaypalPaymentController'})
      .when('/PaypalPayments/edit/:PaypalPaymentId',{templateUrl:'views/PaypalPayment/detail.html',controller:'EditPaypalPaymentController'})
      .when('/Products',{templateUrl:'views/Product/search.html',controller:'SearchProductController'})
      .when('/Products/new',{templateUrl:'views/Product/detail.html',controller:'NewProductController'})
      .when('/Products/edit/:ProductId',{templateUrl:'views/Product/detail.html',controller:'EditProductController'})
      .when('/ProductNotes',{templateUrl:'views/ProductNote/search.html',controller:'SearchProductNoteController'})
      .when('/ProductNotes/new',{templateUrl:'views/ProductNote/detail.html',controller:'NewProductNoteController'})
      .when('/ProductNotes/edit/:ProductNoteId',{templateUrl:'views/ProductNote/detail.html',controller:'EditProductNoteController'})
      .when('/ShoppingCarts',{templateUrl:'views/ShoppingCart/search.html',controller:'SearchShoppingCartController'})
      .when('/ShoppingCarts/new',{templateUrl:'views/ShoppingCart/detail.html',controller:'NewShoppingCartController'})
      .when('/ShoppingCarts/edit/:ShoppingCartId',{templateUrl:'views/ShoppingCart/detail.html',controller:'EditShoppingCartController'})
      .when('/States',{templateUrl:'views/State/search.html',controller:'SearchStateController'})
      .when('/States/new',{templateUrl:'views/State/detail.html',controller:'NewStateController'})
      .when('/States/edit/:StateId',{templateUrl:'views/State/detail.html',controller:'EditStateController'})
      .when('/TwitterAccounts',{templateUrl:'views/TwitterAccount/search.html',controller:'SearchTwitterAccountController'})
      .when('/TwitterAccounts/new',{templateUrl:'views/TwitterAccount/detail.html',controller:'NewTwitterAccountController'})
      .when('/TwitterAccounts/edit/:TwitterAccountId',{templateUrl:'views/TwitterAccount/detail.html',controller:'EditTwitterAccountController'})
      .when('/TwitterAssociations',{templateUrl:'views/TwitterAssociations/search.html',controller:'SearchTwitterAssociationsController'})
      .when('/TwitterAssociations/new',{templateUrl:'views/TwitterAssociations/detail.html',controller:'NewTwitterAssociationsController'})
      .when('/TwitterAssociations/edit/:TwitterAssociationsId',{templateUrl:'views/TwitterAssociations/detail.html',controller:'EditTwitterAssociationsController'})
      .when('/UserIds',{templateUrl:'views/UserId/search.html',controller:'SearchUserIdController'})
      .when('/UserIds/new',{templateUrl:'views/UserId/detail.html',controller:'NewUserIdController'})
      .when('/UserIds/edit/:UserIdId',{templateUrl:'views/UserId/detail.html',controller:'EditUserIdController'})
      .when('/ZipCodes',{templateUrl:'views/ZipCode/search.html',controller:'SearchZipCodeController'})
      .when('/ZipCodes/new',{templateUrl:'views/ZipCode/detail.html',controller:'NewZipCodeController'})
      .when('/ZipCodes/edit/:ZipCodeId',{templateUrl:'views/ZipCode/detail.html',controller:'EditZipCodeController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
