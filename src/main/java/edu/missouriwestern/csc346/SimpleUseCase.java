package edu.missouriwestern.csc346;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.File;

/**
 *This program is used to turn an XML file into POJOs,
 *deserializing XML elements and turning them into Java Objects
 *There is some nesting required in this use case, since the password has an attribute in it.
 *
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 */

public class SimpleUseCase {
    public static void main(String[] args) throws Exception {
        //We create a serializer and a Persister in order to grab the elements from the XML file.
        Serializer serializer = new Persister();
        //We grab from the source "woz.xml"
        File source = new File("woz.xml");
        //We then create a Credentials object and use the serializer to read from the source file and convert to
        // the Credentials.class objects.
        Credentials credentials = serializer.read(Credentials.class, source);
        System.out.println(credentials.toString());
    }//End of main
}//End of SimpleUseCase.class

/**
 * This class is used to serve as an object for the Credentials from the XML file,
 * where the persister will grab elements from the XML file and turn them into the variables for the object.
 */
@Root
class Credentials{

    //We grab the host element
    @Element
    private String host;

    //We grab the port element
    @Element
    private int port;

    //We grab the user element
    @Element
    private String user;

    //We grab the password element, which will be a Password object.
    @Element
    private Password password;

    //The constructor is used to create the object from the various elements from the XML file
    public Credentials(){
        super();
    }//end of constructor

    //Returns the host variable
    public String getHost() {
        return host;
    }//End of getHost

    //Returns the port variable
    public int getPort() {
        return port;
    }//End of getPort

    //Returns the user variable
    public String getUser() {
        return user;
    }//End of getUser

    //Returns the password hint
    public String getPassword(){
        return password.getXhint();
    }//End of getPassword

    //Returns the variables and turns them into a neatly formatted string for the output.
    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s\n",host,port,user,password.getXhint());
    }//End of toString
}//End of Credentials.class

/**
 * In order to grab the attribute from the password, we need to create a password object to grab the xhint attribute
 * from the password, since the simple framework can only grab the attribute from the root element (to our knowledge at least).
 */
@Root
class Password{

    //We grab the attrube known as xhint from the password element;
    @Attribute
    private String xhint;

    //Returns the xhint variable
    public String getXhint(){
        return xhint;
    }//End of getXhint
}//End of Password.class