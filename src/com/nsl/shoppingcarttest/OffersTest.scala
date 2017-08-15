package com.nsl.shoppingcarttest

import org.scalatest.FunSpec
import org.scalatest.matchers.MustMatchers

import com.nsl.shoppingcart._

class OffersTest extends FunSpec with MustMatchers {

  describe(" Offers ") {
    it(" Apple has buyOneGetOne offer") {
      Offers.offer("apple")(2) must be(ShoppingCart.getPrice("apple"))
    }
    it(" Orange has threeForPriceOfTwo offer") {
      Offers.offer("orange")(3) must be(2 * ShoppingCart.getPrice("orange"))
    }
  }
  
  describe(" On buyOneGetOneFree offer ") {
    it(" 2 items should cost 0.50 when price for 1 is 0.50") {
      Offers.buyOneGetOneFree(2, 0.50) must be(0.50)
    }
    it(" 3 items should cost 1.00 when price for 1 is 0.50") {
      Offers.buyOneGetOneFree(3, 0.50) must be(1.00)
    }
    it(" 3 items should cost 0.50 when price for 1 is 0.25") {
      Offers.buyOneGetOneFree(3, 0.25) must be(0.50)
    }
    it(" 4 items should cost 1.00 when price for 1 is 0.50") {
      Offers.buyOneGetOneFree(4, 0.50) must be(1.00)
    }
  }
  
  describe(" On threeForPriceOfTwo offer ") {
    it(" 3 items should cost 1.00 when price for 1 is 0.50") {
      Offers.threeForPriceOfTwo(3, 0.50) must be(1.00)
    }
  }
  

}