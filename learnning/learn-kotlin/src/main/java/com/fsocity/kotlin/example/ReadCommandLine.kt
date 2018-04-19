package com.fsocity.kotlin.example

/**
 * @author zail
 * @since 2018-01-12
 */
fun main(args: Array<String>) {
  if (args.isEmpty()) {
    println("Please provide a name as a command-line argument")
    return
  }
  println("Hello, ${args[0]}!")
}
