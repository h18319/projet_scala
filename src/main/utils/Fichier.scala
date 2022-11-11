package utils

import entity.Cassette

import java.io.{BufferedWriter, File, FileWriter}
import scala.annotation.tailrec
import scala.io.Source.fromFile

object Fichier {
  val path = "./src/main/resources/"

  def lectureFichier(nomFichier : String) : Array[String] = {
    val resource = fromFile(path + nomFichier)
    val lines = try { resource.getLines.toArray } finally { resource.close() }
    return lines
  }

  def reecritureFichier(cassette : Cassette, nomFichier : String): Unit = {
    val fichierTemporaire = new File(path + "fichierTempo.txt")
    val fichierAnc = new File(path + nomFichier)
    val bw = new BufferedWriter(new FileWriter(fichierTemporaire))
    ecrireLigne(bw, cassette, 0)
    bw.close()
    if (fichierAnc.exists) {
      fichierAnc.delete()
    }
    fichierTemporaire.renameTo(new File(path + nomFichier))
  }

  def ecrireLigne(bw : BufferedWriter, cassette : Cassette, index : Int): Unit = {
    if (index < 50) {
      bw.write(ligneCassette(cassette, "", index*20, 0))
      ecrireLigne(bw, cassette, index + 1)
    }
  }

  def donneeLectureFichier(fichier:Array[String], index:Int, output:String) : Array[Int] = {
    if(index < 40) {
      donneeLectureFichier(fichier, index + 1, output++fichier(index))
    }
    else {
      output.split(",").map(_.toInt)
    }
  }

  def tableLectureFichier(fichier : Array[String], index : Int, output : String) : Array[Int] = {
    if(index < 50) {
      tableLectureFichier(fichier, index + 1, output++fichier(index))
    }
    else {
      output.split(",").map(_.toInt)
    }
  }

  def cassetteObjet(nomFichier:String) : Cassette = {
    Cassette(donneeLectureFichier(lectureFichier(nomFichier), 0, ""), tableLectureFichier(lectureFichier(nomFichier), 40, ""))
  }

  def ligneCassette(cassette : Cassette, output : String, index : Int, count : Int): String = {
    if (count<20) {
      ligneCassette(cassette, output+cassette.getElement(cassette, index).toString+",", index + 1, count + 1)
    }
    else {
      output+"\n"
    }
  }

}