var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function ($scope, $http) {
	$scope.initCart = function() {
		$scope.cart = {
			"id": 0
		};
		$scope.addCart($scope.cart.id);
		$scope.refreshCart($scope.cart.id);
	};
	
	$scope.addCart = function(cartId) {
		$http.post('/carts', $scope.cart)
				.then(function(data) {
					$scope.cart = data.data;
				});
	};
	
	$scope.refreshCart = function(cartId) {
		$http.get('/carts/' + $scope.cart.id)
				.then(function(data) {
					$scope.cart = data.data;
				});
	};
	
	$scope.clearCart = function() {
		$http.delete('/carts/' + $scope.cart.id)
				.then($scope.initCart());
	};
	
	$scope.addToCart = function(productId) {
		$http.put('/carts/add/' + $scope.cart.id + '?productId=' + productId)
				.then(function(data) {
					$scope.refreshCart($scope.cart.id);
					alert('Added product to basket')
				});
	};
	
	$scope.removeFromCart = function(productId) {
		$http.delete('/carts/remove/' + $scope.cart.id + '?productId=' + productId)
				.then(function(data) {
					$scope.refreshCart($scope.cart.id);
				});
	};
});