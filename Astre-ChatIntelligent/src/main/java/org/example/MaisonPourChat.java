package org.example;

import java.util.ArrayList;

public class MaisonPourChat {
    private String adresse;
    private ArrayList<ChatIntelligent> chats;

    public MaisonPourChat(String adresse) {
        this.adresse = adresse;
        this.chats = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void ajouterChat(ChatIntelligent chat) {
        if (!chats.contains(chat)) {
            chats.add(chat);
        }
    }

    public void retirerChat(ChatIntelligent chat) {
        chats.remove(chat);
    }

    public int getNombreChats() {
        return chats.size();
    }

    public ArrayList<ChatIntelligent> getChats() {
        return chats;
    }
}
