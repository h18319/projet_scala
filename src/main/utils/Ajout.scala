package utils

import entity.Cassette
import utils.Ascii.{texteVersAscii, afficheTab}
import utils.Memoire.{idExiste, memoireRestante}
import utils.Fichier.reecritureFichier

object Ajout {
  def ajoutDonnee(cassette : Cassette, id : Int, texte : String): Unit = {
    if (id != 0) {
      if (idExiste(cassette, id) == false) {
        if (texte.length <= memoireRestante(cassette)) {

          val donneeIni = cassette.donnee.indexOf(0)
          val donneeAnc = Array.fill[Int](donneeIni)(0)
          cassette.donnee.copyToArray(donneeAnc, 0, donneeIni)
          val nouvelleDonnee = donneeAnc ++ texteVersAscii(texte) ++ Array.fill[Int](800-donneeAnc.length-texte.length)(0)


          val tableIni = cassette.table.indexOf(0)
          val tableAnc = Array.fill[Int](tableIni)(0)
          cassette.table.copyToArray(tableAnc, 0, tableIni)
          val nouvelleTable = tableAnc ++ Array[Int](id) ++ Array[Int](texte.length) ++ Array.fill[Int](200-tableAnc.length-2)(0)

          val nouvelleCassette = Cassette(nouvelleDonnee, nouvelleTable)
          reecritureFichier(nouvelleCassette, "sample_cassette1.txt")
          println("La donnee a bien ete ajoutee\n")
        }

        else { println("Il n'y a pas assez de memoire. Il reste actuellement " + memoireRestante(cassette) + " de memoire\n") }
      }
      else { println("Cet id existe deja\n") }
    }
    else { println("L'id ne peut pas etre 0\n") }
  }
}
