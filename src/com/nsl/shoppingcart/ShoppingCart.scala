package com.nsl.shoppingcart

object ShoppingCart {
  private val priceList: Map[String, BigDecimal] = Map(("apple", 0.60), ("orange", 0.25))

  def checkout(items: Array[String]): BigDecimal = {
    items.flatMap(price).sum
  }

  def price(item: String): Option[BigDecimal] = priceList.get(item toLowerCase)

}