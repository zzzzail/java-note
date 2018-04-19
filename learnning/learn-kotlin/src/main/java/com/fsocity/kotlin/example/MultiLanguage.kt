package com.fsocity.kotlin.example

/**
 * @author zail
 * @since 2018-01-12
 */
fun main(args: Array<String>) {
  val language = if (args.isEmpty()) "EN" else args[0]
  
  println(
    message = when (language) {
      "EN" -> "Hello!"
      "FR" -> "Salut!"
      "IT" -> "Ciao!"
      else -> "Sorry, I can't greet you in $language yet."
    }
  )
}
