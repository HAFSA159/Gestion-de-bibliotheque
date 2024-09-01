package com.libary.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private ArrayList<Document> borrowedDocuments;  // Consistent naming

    public Bibliotheque() {
        this.documents = new ArrayList<>();
        this.borrowedDocuments = new ArrayList<>();
    }

    public void ajouterLivre(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        Livre livre = new Livre(id, titre, auteur, datePublication, nombreDePages, isbn);
        documents.add(livre);
    }

    public void ajouterMagazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        Magazine magazine = new Magazine(id, titre, auteur, datePublication, nombreDePages, numero);
        documents.add(magazine);
    }

    public List<Livre> getLivres() {
        List<Livre> livres = new ArrayList<>();
        for (Document doc : documents) {
            if (doc instanceof Livre) {
                livres.add((Livre) doc);
            }
        }
        return livres;
    }

    public List<Magazine> getMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for (Document doc : documents) {
            if (doc instanceof Magazine) {
                magazines.add((Magazine) doc);
            }
        }
        return magazines;
    }

    public void afficherTousLesDocuments() {
        for (Document doc : documents) {
            doc.afficherDetails();
        }
    }


    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public ArrayList<Document> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public boolean emprunterDocumentParId(String id) {
        for (int i = 0; i < documents.size(); i++) {
            Document doc = documents.get(i);
            if (doc.getId().equals(id)) {
                documents.remove(i);
                borrowedDocuments.add(doc);
                return true;
            }
        }
        return false;
    }

    public boolean retournerDocumentParId(String id) {
        for (int i = 0; i < borrowedDocuments.size(); i++) {
            Document doc = borrowedDocuments.get(i);
            if (doc.getId().equals(id)) {
                borrowedDocuments.remove(i);
                documents.add(doc);
                return true;
            }
        }
        return false;
    }

    public void afficherDocumentsEmpruntes() {
        if (borrowedDocuments.isEmpty()) {
            System.out.println("No documents have been borrowed.");
        } else {
            System.out.println("Borrowed Documents:");
            for (Document doc : borrowedDocuments) {
                doc.afficherDetails();
            }
        }
    }
}
