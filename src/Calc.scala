import java.util.Scanner


object Calc extends App {
  val scanner = new Scanner(System.in)
  var continue = true

  while (continue) {
    println("Enter expression:")
    val exp = scanner.nextLine()

    try {
      println("Result: " + Calculator.calculate(exp))
    } catch {
      case e: IllegalArgumentException => println("Incorrect sign")
      case _: Throwable => {
        println("Incorrect expression.")
      }
    }
    println("Enter Q to exit. Or anything else to continue ;)")
    continue = scanner.nextLine() != "Q"


  }
}
