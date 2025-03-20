package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ChatIntelligentTest {
    private ChatIntelligent chat;
    private ChatIntelligent autreChat;
    private MaisonPourChat maison;

    @BeforeEach
    public void setUp() {
        chat = new ChatIntelligent("Milo", 3);
        autreChat = new ChatIntelligent("Luna", 2);
        maison = new MaisonPourChat("123 rue de la republique");
        chat.rejoindreMaison(maison);
    }

    @AfterEach
    public void tearDown() {
        chat = null;
        autreChat = null;
        maison = null;
    }

    @Test
    public void testGetNom() {
        assertEquals("Milo", chat.getNom());
    }

    @Test
    public void testGetAge() {
        assertEquals(3, chat.getAge()); // 确保 Milo 的年龄是 3
    }

    @Test
    public void testApprendreMot() {
        chat.apprendreMot("Bonjour");
        chat.apprendreMot("Miao");
        assertEquals(2, chat.getNombreMots());
    }

    @Test
    public void testGetNombreMots() {
        assertEquals(0, chat.getNombreMots());
        chat.apprendreMot("Salut");
        assertEquals(1, chat.getNombreMots());
    }

    @Test
    public void testRejoindreMaison() {
        assertNotNull(chat.getMaison());
        assertEquals("123 rue de la republique", chat.getMaison().getAdresse());
    }

    @Test
    public void testDescriptionComplete() {
        assertEquals("Milo habite à 123 rue de la republique.", chat.descriptionComplete());
    }

    @Test
    public void testChangerMaison() {
        MaisonPourChat nouvelleMaison = new MaisonPourChat("45 avenue des chats");
        chat.rejoindreMaison(nouvelleMaison);

        assertEquals(nouvelleMaison, chat.getMaison());
        assertEquals("45 avenue des chats", chat.getMaison().getAdresse());
        assertEquals("Milo habite à 45 avenue des chats.", chat.descriptionComplete());
    }

    @Test
    public void testSansMaison() {
        chat.rejoindreMaison(null);
        assertNull(chat.getMaison());
        assertEquals("Milo n'a pas de maison.", chat.descriptionComplete());
    }

    @Test
    public void testGetNombreChats() {
        assertEquals(1, maison.getNombreChats());
        autreChat.rejoindreMaison(maison);
        assertEquals(2, maison.getNombreChats());
    }

    @Test
    public void testAjouterChat() {
        maison.ajouterChat(autreChat);
        assertTrue(maison.getChats().contains(autreChat));
        assertEquals(2, maison.getNombreChats());
    }

    @Test
    public void testRetirerChat() {
        maison.retirerChat(chat);
        assertEquals(0, maison.getNombreChats());
        assertFalse(maison.getChats().contains(chat));
    }

    @Test
    public void testGetChats() {
        maison.ajouterChat(autreChat);
        ArrayList<ChatIntelligent> chats = maison.getChats();
        assertEquals(2, chats.size());
        assertTrue(chats.contains(chat));
        assertTrue(chats.contains(autreChat));
    }
}
