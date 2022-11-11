package utils

import utils.Fichier.cassetteObjet
import utils.Memoire.{idExiste, memoireRestante}
import utils.Lecture.lireAvecId
import utils.Supprimer.{toutSupprimer, supprimerParId}
import utils.Menu.{nomFichier, menuPrincipal}

import scala.annotation.tailrec
import scala.io.StdIn
import scala.sys.exit

object Menu {
  val nomFichier = "sample_cassette1.txt"

  def menuPrincipal() : Unit = {

    println("\nChoisisez parmis les propositions suivantes :\n1. Lecture \n2. Ajout \n3. Suppression \n4. A propos \n5. Quitter \n");
    val choix_menu = scala.io.StdIn.readLine();

    choix_menu match {
      case "lecture" | "Lecture" | "1" =>
        menuLecture()
      case "ajout" | "Ajout" | "2" =>
        menuAjout()
      case "suppression" | "Suppression" | "3" =>
        menuSupp()
      case "a propos" | "A propos" | "4" =>
        aPropos()
      case "quitter" | "Quitter" | "5" =>
        println("Fin du programme")
        exit
      case _ =>
        println("Vous n'avez pas bien renseigné ce que vous voulez.\nVeuillez écrire présisément le numéro ou le nom du menu (exemple : \"Lecture\" ou \"1\")")
        menuPrincipal()
    }
  }

  def menuLecture() : Unit = {

    println("\nSouhaitez-vous :\n1. Lire un seul ID \n2. Tout lire \n3. Retour \n");
    val choix_menu = scala.io.StdIn.readLine();

    choix_menu match {
      case "Lire un seul ID" | "lire un seul ID" | "1" =>
        lectureId()
      case "Tout lire" | "tout lire" | "2" =>
        lectureTout()
      case "Retour" | "retour" | "3" =>
        menuPrincipal()
      case _ =>
        println("Vous n'avez pas bien renseigné ce que vous voulez.\nVeuillez écrire précisément le numéro ou le nom du menu (exemple : \"Lecture\" ou \"1\")")
        menuLecture()
    }
  }

  def lectureId() : Unit = {
    print("Quel ID voulez-vous lire : ")
    val cassette = cassetteObjet(nomFichier)
    val choix_id = StdIn.readInt()
    lireAvecId(cassette, choix_id)
    println("\nVoulez vous faire autre chose ?")
    menuPrincipal()
  }

  def lectureTout() : Unit = {
    val cassette = cassetteObjet(nomFichier)
    Lecture.lireTout(cassette)
    println("\n")
    menuPrincipal()
  }

  def menuAjout(): Unit = {
    val cassette = cassetteObjet(nomFichier)
    print("Quel Id voulez vous ajouter : ")
    try {
      val choix_id = StdIn.readInt()
      print("Saisissez le texte a ajouter : ")
      val texte = StdIn.readLine()
      println("\nEtes-vous sur de vouloir ajouter le texte \"" + texte + "\" dans l'Id " + choix_id + " ?\nPour confirmer tapez \"oui\"")
      val confirmation = StdIn.readLine()
      if (confirmation == "oui") {
        Ajout.ajoutDonnee(cassette, choix_id, texte)
      }
      else {
        println("Vous n'avez pas dit oui\n")
      }
    }
    catch {
      case e: NumberFormatException => println("L'id doit être un nombre entier")
        menuAjout()
    }
    menuPrincipal()
  }

  def menuSupp(): Unit = {

    println("\nSouhaitez-vous :\n1. Supprimer par ID \n2. Tout supprimer \n3. Retour \n");
    val choix_menu = scala.io.StdIn.readLine();

    choix_menu match {
      case "Supprimer par ID" | "supprimer par ID" | "1" =>
        supprimerId()
      case "Tout supprimer" | "tout supprimer" | "2" =>
        supprimerTout()
      case "Retour" | "retour" | "3" =>
        menuPrincipal()
      case _ =>
        println("Vous n'avez pas bien renseigné ce que vous voulez.\nVeuillez écrire précisément le numéro ou le nom du menu (exemple : \"Lecture\" ou \"1\")")
        menuSupp()
    }
  }

  def supprimerId(): Unit = {
    val cassette = cassetteObjet(nomFichier)
    print("Quel Id voulez-vous supprimer ?")
    try {
      val choix_id = StdIn.readInt()
      if (idExiste(cassette, choix_id)) {
        println("\nEtes-vous sur de vouloir supprimer l'Id " + choix_id + " ?\nPour confirmer tapez \"oui\"")
        val confirmation = StdIn.readLine()
        if (confirmation == "oui") {
          supprimerParId(cassette, choix_id)
          println("La donnee a bien ete supprimee\n")
        }
        else {
          println("Vous n'avez pas dit oui\n")
        }
      }
      else {
        println("L'Id n'existe pas\n")
      }
    }
    catch {
      case e: NumberFormatException => println("L'Id doit etre un entier")
        menuSupp()
    }
    menuPrincipal()
  }
  def supprimerTout(): Unit = {
    println("Vous etes sur le point de supprimer completement le fichier. \nPour confirmer tapez \"oui\"")
    val confirmation = StdIn.readLine()
    if (confirmation == "oui") {
      Supprimer.toutSupprimer()
      println("Toutes les donnees ont bien ete supprimees\n")
    }
    else {
      println("Vous n'avez pas dit oui\n")
    }
    menuPrincipal()
  }

  def aPropos(): Unit = {
    println("\nscala.version = 3.2.0")
    println("sbt.version = 1.7.3")
    println("\nProjet realise sur IntelliJ")
    println("auteur : Imane Hornain")
    println("\nSi vous changer de fichier, ne pas oublier de changer la valeur de \"nomFichier\" a la 14eme ligne de l'objet Menu.")
    menuPrincipal()
  }
}