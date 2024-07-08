import scala.collection.mutable.ArrayBuffer
import scala.util.Random

val words: List[String] = List("elbow", "writer", "circle", "polish", "bridge", "store", "fang", "scarecrow", "show", "jeans", "wilderness", "attempt", "waxing", "aftermath", "banana", "wrist", "wheel", "spring", "cherries", "nerve")

var word = ""
val guesses: ArrayBuffer[Char] = ArrayBuffer[Char]()
var remainingGuesses = 6
var mistake = 0

@main def HangmanGame(): Unit = {
  setupGame()
}

def setupGame(): Unit = {
  val wordIndex = Random.nextInt(words.size)
  word = words(wordIndex).toUpperCase
  println(word)

  for (_ <- word.indices)
    guesses.addOne('_')

  var gameOver = false

  while (!gameOver) {
    printGameStatus()
    println("Guess a letter: ")
    val input = scala.io.StdIn.readLine()

    if (input.isEmpty) {
      println("Invalid input")
    } else {
      val letter = input.charAt(0).toUpper
      if (word.contains(letter)) {
        for (i <- word.indices) {
          if (word.charAt(i) == letter) {
            guesses(i) = letter
          }
        }
        if (!guesses.contains('_')) {
          gameOver = true
          println("Congratulations! You've guessed the word!")
        }
      } else {
        println("Sorry, that letter is not in the word")
        remainingGuesses -= 1
        mistake += 1
        if (mistake == 6) {
          gameOver = true
          println(s"Sorry, you have lost. The word was $word")
        }
      }
    }
  }

  printGameStatus()
}

def printGameStatus(): Unit = {
  mistake match {
    case 0 => print0Mistakes()
    case 1 => print1Mistake()
    case 2 => print2Mistakes()
    case 3 => print3Mistakes()
    case 4 => print4Mistakes()
    case 5 => print5Mistakes()
    case 6 => print6Mistakes()
    case _ => print6Mistakes()
  }

  print("Word: ")
  for (element <- guesses) {
    print(s"$element ")
  }

  println(s"\nYou have $remainingGuesses guesses left")
}

def print0Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |       ")
  println("  |")
  println("  |")
  println("  |")
  println(" /|\\")
  println("/ | \\")
}

def print1Mistake(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |")
  println("  |")
  println("  |")
  println(" /|\\")
  println("/ | \\")
}

def print2Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |      |")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")
}

def print3Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")
}

def print4Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |")
  println(" /|\\")
  println("/ | \\")
}

def print5Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |     /")
  println(" /|\\")
  println("/ | \\")
}

def print6Mistakes(): Unit = {
  println("  |------|-")
  println("  |      |")
  println("  |      O")
  println("  |     /|\\")
  println("  |      |")
  println("  |     / \\")
  println(" /|\\")
  println("/ | \\")
}
