package com.nsl.shoppingcart

object ShoppingCartMain {
  def main(args: Array[String]) {
    println("[ " + args.mkString(", ") + " ] => £" + ShoppingCart.checkout(args))
  }
}