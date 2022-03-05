package edu.missouriwestern.csc346;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.File;

/**
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 *
 *
 */

public class SimpleUseCase {
    public static void main(String[] args) throws Exception {
        Serializer serializer = new Persister();
        File source = new File("woz.xml");
        Credentials credentials = serializer.read(Credentials.class, source);
        System.out.println(credentials.getHost());
        System.out.println(credentials.getPort());
        System.out.println(credentials.getUser());
        System.out.println(credentials.getPassword());
    }
}

@Root
class Credentials{


    @Element
    private String host;

    @Element
    private int port;

    @Element
    private String user;

    @Element
    private Password password;

    public Credentials(){
        super();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }
    public String getPassword(){
        return password.getXhint();
    }
}

@Root
class Password{

    @Attribute
    private String xhint;

    public String getXhint(){
        return xhint;
    }
}