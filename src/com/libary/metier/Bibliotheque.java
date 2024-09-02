package com.libary.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Document> documents;
    private List<Document> borrowedDocuments;
    private int idCounter = 1;

    public Bibliotheque() {
        this.documents = new ArrayList<>();
        this.borrowedDocuments = new ArrayList<>();
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);
    }

    public void ajouterLivre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        Livre livre = new Livre(generateId(), titre, auteur, datePublication, nombreDePages, isbn);
        documents.add(livre);
    }

    public void ajouterMagazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        Magazine magazine = new Magazine(generateId(), titre, auteur, datePublication, nombreDePages, numero);
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

    public void afficherDocumentsEmpruntes() {
        if (borrowedDocuments.isEmpty()) {
            System.out.println("No documents have been borrowed.");
        } else {
            for (Document doc : borrowedDocuments) {
                doc.afficherDetails();
            }
        }
    }

    public boolean emprunterDocumentParId(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                documents.remove(doc);
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

    private int generateId() {
        return idCounter++;
    }
}
