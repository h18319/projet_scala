package utils

import entity.Cassette

import Fichier.reecritureFichier
import Memoire.listeDonneeId
import Lecture.nombreAvantDonnee

object Supprimer {

  def supprimerParId(cassette : Cassette, id : Int): Unit = {
    val longueurDonnee = cassette.table(listeDonneeId(cassette).indexOf(id)*2+1)
    val bbd = nombreAvantDonnee(cassette, id)
    val idIndex = listeDonneeId(cassette).indexOf(id)*2
    val longueurIndex = idIndex+1

    val donneeAnc1 = Array.fill[Int](bbd)(0)
    val donneeAnc2 = cassette.donnee.slice(bbd + longueurDonnee, 800)
    cassette.donnee.copyToArray(donneeAnc1, 0, bbd)
    val nouvelleDonnee = donneeAnc1 ++ donneeAnc2 ++ Array.fill[Int](longueurDonnee)(0)

    val tableAnc1 = Array.fill[Int](idIndex)(0)
    val tableAnc2 = cassette.table.slice(longueurIndex + 1, 200)
    cassette.table.copyToArray(tableAnc1, 0, idIndex)
    val nouvelleTable = tableAnc1 ++ tableAnc2 ++ Array[Int](0, 0)

    val nouvelleCassette = Cassette(nouvelleDonnee, nouvelleTable)
    reecritureFichier(nouvelleCassette, "sample_cassette1.txt") //Update the memory file
  }

  def toutSupprimer(): Unit = {
    val nouvelleCassette = Cassette()
    reecritureFichier(nouvelleCassette, "sample_cassette1.txt")
  }
}