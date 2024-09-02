package com.libary;

import com.libary.metier.Bibliotheque;
import com.libary.metier.Document;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an Option:");
            System.out.println("1. Add Document");
            System.out.println("2. Borrow Document");
            System.out.println("3. Return Document");
            System.out.println("4. Display All Documents");
            System.out.println("5. Search Document");
            System.out.println("6. Display Borrowed Documents");
            System.out.println("7. Exit");

            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                // To Add a Doc
                case 1:
                    ajouterDocument(scanner, bibliotheque);
                    break;
                // To Borrow A Book
                case 2:
                    emprunterDocument(scanner, bibliotheque);
                    break;

                // TO Return A Book
                case 3:
                    retournerDocument(scanner, bibliotheque);
                    break;

                // To Display All The Books
                case 4:
                    System.out.println("Displaying all documents:");
                    bibliotheque.afficherTousLesDocuments();
                    break;


                //doc search
                case 5:
                    System.out.print("Enter the title to search: ");
                    String title = scanner.nextLine();
                    Document resultByTitle = bibliotheque.chercherParTitre(title);
                    if (resultByTitle != null) {
                        System.out.println("Document found with the title: " + title);
                        resultByTitle.afficherDetails();
                    } else {
                        System.out.println("No document found with the title: " + title);
                    }
                    break;

                // Display Borrowed Books
                case 6:
                    System.out.println("Displaying borrowed documents:");
                    bibliotheque.afficherDocumentsEmpruntes();
                    break;

                // Exit The Program
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private static void ajouterDocument(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.println("You want to add:");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        if (userChoice == 1) {
            System.out.println("Enter details for Livre:");
            System.out.print("Title: ");
            String titre = scanner.nextLine();
            System.out.print("Author: ");
            String auteur = scanner.nextLine();
            LocalDate datePublication = LocalDate.now();
            System.out.print("Number of Pages: ");
            int nombreDePages = scanner.nextInt();
            scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            bibliotheque.ajouterLivre(titre, auteur, datePublication, nombreDePages, isbn);
            System.out.println("Livre added successfully!");

        } else if (userChoice == 2) {
            System.out.println("Enter details for Magazine:");
            System.out.print("Title: ");
            String titre = scanner.nextLine();
            System.out.print("Author: ");
            String auteur = scanner.nextLine();
            LocalDate datePublication = LocalDate.now();
            System.out.print("Number of Pages: ");
            int nombreDePages = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Issue Number: ");
            String numero = scanner.nextLine();

            bibliotheque.ajouterMagazine(titre, auteur, datePublication, nombreDePages, numero);
            System.out.println("Magazine added successfully!");

        } else {
            System.out.println("Invalid choice. Please choose again.");
        }
    }

    private static void emprunterDocument(Scanner scanner, Bibliotheque bibliotheque) {
        if (bibliotheque.getDocuments().isEmpty()) {
            System.out.println("No documents are available to borrow.");
            return;
        }
        System.out.println("Which document do you want to borrow?");
        bibliotheque.afficherTousLesDocuments();
        System.out.print("Enter the ID of the document: ");
        String documentId = scanner.nextLine();

        if (bibliotheque.emprunterDocumentParId(documentId)) {
            System.out.println("Document borrowed successfully.");
        } else {
            System.out.println("Document with ID " + documentId + " not found or already borrowed.");
        }
    }

    private static void retournerDocument(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.println("Which document do you want to return?");
        bibliotheque.afficherDocumentsEmpruntes();
        System.out.print("Enter the ID of the document: ");
        String returnId = scanner.nextLine();

        if (bibliotheque.retournerDocumentParId(returnId)) {
            System.out.println("Document returned successfully.");
        } else {
            System.out.println("Document with ID " + returnId + " not found in borrowed list.");
        }
    }
}
