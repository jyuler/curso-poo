package ean.poo.eventos;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

import jdt.pruebas.chat.model.Message;

public class ConsumeMensajes implements Consumer<Message> {

    @Override
    public void accept(Message m) {
       System.out.println(m.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,5) + " - " + m.getSender() + ": " + m.getContent() );
    }
    
}
