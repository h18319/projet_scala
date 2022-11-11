package utils

import java.nio.charset.StandardCharsets
import scala.annotation.tailrec

object Ascii {

  def texteVersAscii(texte : String) : Array[Int] = {
    texte.map(_.toInt).toArray
  }

  def asciiVersTexte(ascii : Array[Int]) : String = {
    new String(ascii.map(_.toByte), StandardCharsets.US_ASCII)
  }

  def afficheTab(tableau : Array[Int]): String = {
    afficheTabBoucle(tableau, 0, "")
  }

  def afficheTabBoucle(tableau : Array[Int], index : Int, output : String): String = {
    if (index < tableau.length) {
      afficheTabBoucle(tableau, index + 1, output++(tableau(index).toString + " "))
    }
    else {
      return output
    }
  }

}