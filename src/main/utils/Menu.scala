package main.utils

import scala.sys.exit

object Menu {

  lazy val nomFichier = "sample_cassette1.txt"

  def menuPrincipal(): Unit = {
    println("\nChoisisez parmis les propositions suivantes :\n1. Lecture \n2. Ajout \n3. Suppression \n4. A propos \n5. Quitter \n");
    val choix_menu = scala.io.StdIn.readLine();

    choix_menu match {
      case "lecture" | "Lecture" | "1" =>
        menuLecture()
      case "ajout" | "Ajout" | "2" =>
        println("vous avez choisi ajout")
      case "suppression" | "Suppression" | "3" =>
        println("vous avez choisi lecture")
      case "a propos" | "A propos" | "4" =>
        println("vous avez choisi lecture")
      case "quitter" | "Quitter" | "5" =>
        println("Fin du programme")
        exit
      case _ =>
        println("Vous n'avez pas bien renseigné ce que vous voulez.\nVeuillez écrire présisément le numéro ou le nom du menu (exemple : \"Lecture\" ou \"1\")")
        menuPrincipal()
    }
  }

  def menuLecture(): Unit = {
    println("\nSouhaitez-vous :\n1. Lire un seul ID \n2. Tout lire \n3. Retour \n");
    val choix_menu = scala.io.StdIn.readLine();

    choix_menu match {
      case "Lire un seul ID" | "lire un seul ID" | "1" =>
        lectureID()
      case "Tout lire" | "tout lire" | "2" =>
        lectureAll()
      case "Retour" | "retour" | "3" =>
        menuPrincipal()
      case _ =>
        println("Vous n'avez pas bien renseigné ce que vous voulez.\nVeuillez écrire présisément le numéro ou le nom du menu (exemple : \"Lecture\" ou \"1\")")
        menuLecture()
    }
  }

  def lectureID(): Unit = {
    val cassette = cass
  }
}
