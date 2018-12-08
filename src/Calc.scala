import java.util.Scanner

import util.control.Breaks._

object Calc extends App {

  val scanner = new Scanner(System.in)

  var continue = true
  while (continue) {
    println("Enter expression:")
    val expression = scanner.nextLine().toCharArray
    breakable {
      for (i <- expression.indices) {
        if (!Character.isDigit(expression.charAt(i))) {
          val num1 = expression.subSequence(0, i).toString
          val op = expression(i).toString
          val num2 = expression.subSequence(i + 1, expression.length).toString
          try {
            calc(num1.toDouble, num2.toDouble, op)
          } catch {
            case _: Throwable => {
              println("Incorrect expression.")
              break
            }
          }
        }
      }
    }
    println("Enter Q to exit. Or anything else to continue ;)")
    continue = scanner.nextLine() != "Q"
  }
  println("Bye!")


  def calc(a: Double, b: Double, sign: String): Unit = {
    sign match {
      case "+" => println(a + b)
      case "-" => println(a - b)
      case "*" => println(a * b)
      case "/" => println(a / b)
      case _ => println("You enter incorrect sign.\n Please, try again.")
    }
  }

}
