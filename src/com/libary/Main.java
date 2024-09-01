package com.libary;

import com.libary.metier.Bibliotheque;
import com.libary.metier.Document;
import com.libary.metier.Livre;
import com.libary.metier.Magazine;
import com.libary.presentation.ConsoleUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsoleUI UI = new ConsoleUI();
        UI.Menu();

        Bibliotheque bibliotheque = new Bibliotheque();
        init(bibliotheque);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an Option.");
        int userOption = scanner.nextInt();

        switch(userOption){
            case 1:
                System.out.println("You Want to add : ");
                System.out.println("1. Livre ");
                System.out.println("2. Magazine ");
                int userChoice = scanner.nextInt();
                if(userChoice==1){
                    System.out.println("List of Books:");
                    for (Livre  livre : bibliotheque.getLivres()) {
                        livre.afficherDetails();
                    }
                }else{
                    System.out.println("List of Magazines:");
                    for (Magazine magazine : bibliotheque.getMagazines()) {
                        magazine.afficherDetails();
                    }
                }
                break;


            case 2:
                System.out.println("Which Document Do You Want To Borrow?");
                bibliotheque.afficherTousLesDocuments();

                System.out.println("Enter the ID of the document you want to borrow:");
                String documentId = scanner.next();
                if (bibliotheque.emprunterDocumentParId(documentId)) {
                    System.out.println("Document borrowed successfully.");
                } else {
                    System.out.println("Document with ID " + documentId + " not found or already borrowed.");
                }
                break;

            case 3:
                System.out.println("Which Document Do You Want To Return?");
                bibliotheque.afficherDocumentsEmpruntes();

                System.out.println("Enter the ID of the document you want to return:");
                String returnId = scanner.next();

                if (bibliotheque.retournerDocumentParId(returnId)) {
                    System.out.println("Document returned successfully.");
                } else {
                    System.out.println("Document with ID " + returnId + " not found in borrowed list.");
                }
                break;

            case 4:
                System.out.println("Display all documents:");
                bibliotheque.afficherTousLesDocuments();
                break;

            case 5:
                // recherche dun doc
                break;

            case 6:
                System.out.println("Displaying Borrowed Documents:");
                bibliotheque.afficherDocumentsEmpruntes();
                break;

            case 7:
                System.out.println("Exiting program.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option.");
                break;

        }
    }
    public static void init(Bibliotheque bibliotheque){

        bibliotheque.ajouterLivre("1", "Java Programming", "James Gosling", LocalDate.parse("01/01/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 450, "978-0135166307");
        bibliotheque.ajouterLivre("2", "Effective Java", "Joshua Bloch", LocalDate.parse("28/05/2008", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 374, "978-0321356680");
        bibliotheque.ajouterLivre("3", "Clean Code", "Robert C. Martin", LocalDate.parse("01/08/2008", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 464, "978-0132350884");
        bibliotheque.ajouterLivre("4", "Head First Design Patterns", "Eric Freeman", LocalDate.parse("25/10/2004", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 694, "978-0596007126");
        bibliotheque.ajouterLivre("5", "The Pragmatic Programmer", "Andrew Hunt", LocalDate.parse("20/10/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 352, "978-0201616224");
        bibliotheque.ajouterLivre("6", "Introduction to Algorithms", "Thomas H. Cormen", LocalDate.parse("01/09/2009", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 1312, "978-0262033848");
        bibliotheque.ajouterLivre("7", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", LocalDate.parse("31/10/1994", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 395, "978-0201633610");
        bibliotheque.ajouterLivre("8", "Refactoring: Improving the Design of Existing Code", "Martin Fowler", LocalDate.parse("08/07/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 431, "978-0201485677");
        bibliotheque.ajouterLivre("9", "Java Concurrency in Practice", "Brian Goetz", LocalDate.parse("19/05/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 424, "978-0321349606");
        bibliotheque.ajouterLivre("10", "The Art of Computer Programming", "Donald Knuth", LocalDate.parse("01/01/1968", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 672, "978-0201896831");

        bibliotheque.ajouterMagazine("11", "Tech Today", "Alice Tech", LocalDate.parse("15/08/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 40, "001");
        bibliotheque.ajouterMagazine("12", "Science Weekly", "Bob Science", LocalDate.parse("22/08/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 32, "002");
        bibliotheque.ajouterMagazine("13", "National Geographic", "John Geo", LocalDate.parse("01/09/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 100, "003");
        bibliotheque.ajouterMagazine("14", "Time", "Henry Luce", LocalDate.parse("01/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 120, "004");
        bibliotheque.ajouterMagazine("15", "The Economist", "Zanny Minton Beddoes", LocalDate.parse("15/08/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 80, "005");
        bibliotheque.ajouterMagazine("16", "Nature", "Magdalena Skipper", LocalDate.parse("01/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 90, "006");
        bibliotheque.ajouterMagazine("17", "Scientific American", "Laura Helmuth", LocalDate.parse("01/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 75, "007");
        bibliotheque.ajouterMagazine("18", "Wired", "Nicholas Thompson", LocalDate.parse("20/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 110, "008");
        bibliotheque.ajouterMagazine("19", "Forbes", "Steve Forbes", LocalDate.parse("10/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 85, "009");
        bibliotheque.ajouterMagazine("20", "Harvard Business Review", "Adi Ignatius", LocalDate.parse("01/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 95, "010");

    }

}