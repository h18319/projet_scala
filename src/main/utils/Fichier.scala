package main.utils

import scala.io.Source

object Fichier {

  def lectureFichier(nomFichier : String) : Array[String] = {
    val resource = Source.fromResource(nomFichier)
    val lines = try {resource.getLines.toArray} finally {resource.close()}

    return lines
  }

  def donneeLectureFichier(fichier : Array[String], index : Int, output : String) : Array[Int] = {
    if (index < 40){
      donneeLectureFichier(fichier, index + 1, output++fichier(index))
    }
    else {
      output.split(",").map(_.toInt)
    }
  }

  def tableLectureFichier(fichier : Array[String], index : Int, output : String) : Array[Int] = {
    if (index > 50){
      tableLectureFichier(fichier, index + 1, output++fichier(index))
    }
    else {
      output.split(",").map(_.toInt)
    }
  }

  def cassetteObjet(nomFichier : String) : Cassette = {
    Cassette(donneeLectureFichier(lectureFichier(nomFichier), 0, ""), tableLectureFichier(lectureFichier(nomFichier), 40, ""))
  }


}
