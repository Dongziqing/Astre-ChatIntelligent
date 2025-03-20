package org.example;

import java.util.ArrayList;

public class ChatIntelligent {
    private final String nom;
    private final int age;
    private final ArrayList<String> vocabulaire;
    private MaisonPourChat maison;

    public ChatIntelligent(String nom, int age) {
        this.nom = nom;
        this.age = age;
        this.vocabulaire = new ArrayList<>();
        this.maison = null;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public void apprendreMot(String mot) {
        if (!vocabulaire.contains(mot)) {
            vocabulaire.add(mot);
        }
    }

    public int getNombreMots() {
        return vocabulaire.size();
    }

    public void rejoindreMaison(MaisonPourChat maison) {
        if (this.maison != null) {
            this.maison.retirerChat(this);
        }
        this.maison = maison;
        if (maison != null) {
            maison.ajouterChat(this);
        }
    }

    public MaisonPourChat getMaison() {
        return maison;
    }

    public String descriptionComplete() {
        if (maison != null) {
            return nom + " habite à " + maison.getAdresse() + ".";
        } else {
            return nom + " n'a pas de maison.";
        }
    }
}