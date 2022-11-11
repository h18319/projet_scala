package utils

import entity.Cassette

import scala.annotation.tailrec

object Memoire {

  def listeDonneeId(cassette : Cassette): Array[Int] = {
    listeDonneeIdBoucle(cassette, 0, Array[Int]())
  }

  def listeDonneeIdBoucle(cassette : Cassette, index : Int, output : Array[Int]): Array[Int] = {
    if (index < cassette.table.length) {
      if (cassette.table(index) != 0) {
        listeDonneeIdBoucle(cassette, index + 2, output.:+(cassette.table(index)))
      }
      else {
        output
      }
    }
    else {
      output
    }
  }

  def idExiste(cassette : Cassette, id : Int) : Boolean = {
    val idList = listeDonneeId(cassette)
    if (idList.contains(id)) {
      return true
    }
    else {
      return false
    }
  }

  def memoireRestante(cassette : Cassette): Int = {
    memoireRestanteBoucle(cassette, 0, 0)
  }

  def memoireRestanteBoucle(cassette : Cassette, index : Int, output : Int) : Int = {
    if (cassette.donnee.contains(0)) {
      if (index < cassette.donnee.length) {
        if(cassette.donnee(index) == 0) {
          memoireRestanteBoucle(cassette, index + 1, output + 1)
        }
        else {
          memoireRestanteBoucle(cassette, index + 1, output)
        }
      }
      else {
        return output
      }
    }
    else {
      return output
    }
  }
}