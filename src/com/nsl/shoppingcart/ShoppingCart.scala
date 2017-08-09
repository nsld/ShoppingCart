package com.nsl.shoppingcart

object ShoppingCart {
  private val priceList: Map[String, BigDecimal] = Map(("apple", 0.60), ("orange", 0.25))

  def checkout(items: Array[String]): BigDecimal = {
    items.flatMap(price).sum
  }
  
  def checkoutWithOffers(items: Array[String]): BigDecimal = {
    val numberOfApples: Int = items.count(p => p.equalsIgnoreCase("apple"))
    val numberOfOranges: Int = items.count(p => p.equalsIgnoreCase("orange"))
    Offers.offer("apple")(numberOfApples) + Offers.offer("orange")(numberOfOranges) 
  }

  def getPrice(item: String): BigDecimal = {
    priceList.getOrElse(item toLowerCase, 0.0)
  }

  def price(item: String): Option[BigDecimal] = priceList.get(item toLowerCase)

}