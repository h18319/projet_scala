package utils

import entity.Cassette
import utils.Ascii.asciiVersTexte
import utils.Memoire.{idExiste, listeDonneeId}
import utils.Ascii.afficheTab

import scala.annotation.tailrec

object Lecture {

  def nombreAvantDonnee(cassette : Cassette, id : Int): Int = {
    nombreAvantDonneeBoucle(cassette, id, 1, 0)
  }

  def nombreAvantDonneeBoucle(cassette : Cassette, id : Int, index : Int, output : Int) : Int = {
    if (index - 1 < cassette.table.indexOf(id)) {
      nombreAvantDonneeBoucle(cassette, id, index + 2, output + cassette.table(index))
    }
    else {
      return output
    }
  }

  def lireAvecId(cassette : Cassette, id : Int) : Unit = {
    if (idExiste(cassette, id) == true) {
      val longueur_data = cassette.table(cassette.table.indexOf(id) + 1)
      val nombre_avant_donnee = nombreAvantDonnee(cassette, id)
      val donnee = cassette.donnee.slice(nombre_avant_donnee, nombre_avant_donnee + longueur_data)
      val texte = asciiVersTexte(donnee)
      println("L'id " + id + " est \"" + texte + "\" et sa valeur en Ascii est : " + afficheTab(donnee))
    }
    else {
      print("L'Id choisi n'existe pas")
    }
  }

  def lireTout(cassette : Cassette): Unit = {
    lireToutBoucle(cassette, 0)
  }

  def lireToutBoucle(cassette : Cassette, index:Int) : Unit = {
    val listeId = listeDonneeId(cassette)

    if (index < listeId.length) {
      lireAvecId(cassette, listeId(index))
      lireToutBoucle(cassette, index + 1)
    }
    else {
    }
  }

}