package ean.poo.eventos;

import jdt.pruebas.chat.client.ChatClient;
import jdt.pruebas.chat.client.ChatClientException;
import jdt.pruebas.chat.client.ChatClientFactory;

public class Main {
    public static void main(String[] args) throws ChatClientException {
        ChatClient cc = ChatClientFactory.createChatClientDummy();
        cc.connect("Jhan_Yuler");
        ConsumeMensajes cm = new ConsumeMensajes();
        cc.onMessageReceived(cm);
        try { Thread.sleep(10000); } catch (InterruptedException e) {}
        cc.disconnect();
    }
}
