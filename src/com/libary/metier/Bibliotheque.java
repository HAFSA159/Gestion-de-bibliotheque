package com.libary.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private ArrayList<Document> documents;

    public Bibliotheque() {
        this.documents = new ArrayList<>();
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
}
