package com.nsl.shoppingcarttest

import org.scalatest.FunSpec
import org.scalatest.matchers.MustMatchers

import com.nsl.shoppingcart.ShoppingCart

class ShoppingCartTest extends FunSpec with MustMatchers {
  
  describe(" PriceList ") {
    it(" Price of an apple is 0.60 ") {
      ShoppingCart.getPrice("apple") must be (0.60)
    }
    it(" Price of an orange is 0.25 ") {
      ShoppingCart.getPrice("orange") must be (0.25)
    }
    it(" Price of item that doesn't exist is 0 ") {
      ShoppingCart.getPrice("nonexistitem") must be (0)
    }
  }
  
   describe(" On Checkout ") {
    it(" 2 Apples should cost 1.20 ") {
      ShoppingCart.checkout(Array("apple", "apple")) must be (1.20)
    }
    it(" 3 Apples should cost 1.80 ") {
      ShoppingCart.checkout(Array("apple", "apple", "apple")) must be (1.80)
    }
    it(" 2 Oranges should cost 0.5 ") {
      ShoppingCart.checkout(Array("orange", "orange")) must be (0.5)
    }
    it(" 4 apples and 3 oranges should cost 3.15 in any order case insensitive ") {
      ShoppingCart.checkout(Array("Apple", "Orange", "apple", "orange", "Apple", "orange", "apple")) must be (3.15)
    }
  }
  describe(" On Checkout with offers ") {
    it(" 2 Apples should cost 0.60 ") {
      ShoppingCart.checkoutWithOffers(Array("apple", "apple")) must be (0.60)
    }
    it(" 3 Apples should cost 1.20 ") {
      ShoppingCart.checkoutWithOffers(Array("apple", "apple", "apple")) must be (1.20)
    }
    it(" 3 Oranges should cost 0.50 ") {
      ShoppingCart.checkoutWithOffers(Array("orange", "orange", "orange")) must be (0.50)
    }
    it(" 4 apples and 3 oranges should cost 1.70 in any order case insensitive ") {
      ShoppingCart.checkoutWithOffers(Array("Apple", "Orange", "apple", "orange", "Apple", "orange", "apple")) must be (1.70)
    }
  }
}