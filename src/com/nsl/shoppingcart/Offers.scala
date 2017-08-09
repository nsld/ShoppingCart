package com.nsl.shoppingcart

object Offers {
  def buyOneGetOneFree(numberOfItems: Int, priceOfOneItem: BigDecimal): BigDecimal = ((numberOfItems / 2) + (numberOfItems % 2)) * priceOfOneItem

  def threeForPriceOfTwo(numberOfItems: Int, priceOfOneItem: BigDecimal): BigDecimal = (2 * (numberOfItems/3) + (numberOfItems %3)) * priceOfOneItem

  def offer(item: String): Int => BigDecimal = {
    val itemPrice: BigDecimal = ShoppingCart.getPrice(item)
    item toLowerCase() match {
      case "apple" => (numberOfItems:Int) => buyOneGetOneFree(numberOfItems, itemPrice)
      case "orange" => (numberOfItems:Int) => threeForPriceOfTwo(numberOfItems, itemPrice)
      case _ => (numberOfItems:Int) => numberOfItems * itemPrice
    }
  }
}