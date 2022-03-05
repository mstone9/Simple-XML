package edu.missouriwestern.csc346;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * This program is used to grab an array of elements from an XML file, and turn each Element of that array
 * into a POJO. This program will grab from an XML file from the Fifty US states and turn each one into an Object,
 * and have an array of those objects to be printed out.
 *
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 */
public class ArrayUseCase{
    public static void main(String[] args){
        try{
            //We start off by creating the Persister.
            Serializer serializer = new Persister();

            //We then grab from the source "states.xml"
            File file = new File("states.xml");

            //We then create a States object, and use the serializer to read from the file, which will then
            //create the array of states and put the elements into that array.
            States states = serializer.read(States.class, file);

            System.out.println(Arrays.toString(states.getStates()));
        }catch(Exception e){
            //In case we are unable to grab from the XML file, we have to throw an exception
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
            System.exit(1);
        }
    }
}

/**
 * This class serves as the ArrayList for the 50 states, which will grab each element from the array and turn
 * each state into an object.
 */
@Root
class States{
    @ElementList(inline = true)
    private ArrayList<State> states;

    public Object[] getStates(){return states.toArray();}
}//End of States Class

/**
 * This class serves to be the actual object for the state, grabbing each element from the states.
 */
@Root
class State{

    //We grab the state element
    @Element
    private String state;

    //We grab the slug element
    @Element
    private String slug;

    //We grab the code element
    @Element
    private String code;

    //We grab the nickname element
    @Element
    private String nickname;

    //We grab the website element
    @Element
    private String website;

    //We grab the admission_date element
    @Element
    private String admission_date;

    //We grab the admission_number element
    @Element
    private int admission_number;

    //We grab the capital_city element
    @Element
    private String capital_city;

    //We grab the capital_url element
    @Element
    private String capital_url;

    //We grab the population element
    @Element
    private int population;

    //We grab the population_rank element
    @Element
    private int population_rank;

    //We grab the constitution_url element
    @Element
    private String constitution_url;

    //We grab the state_flag_url element
    @Element
    private String state_flag_url;

    //We grab the state_seal_url element
    @Element
    private String state_seal_url;

    //We grab the map_image_url element
    @Element
    private String map_image_url;

    //We grab the landscape_background element
    @Element
    private String landscape_background_url;

    //We grab the skyline_background element
    @Element
    private String skyline_background_url;

    //We grab the twitter_url element
    @Element(required = false)
    private String twitter_url;

    //We grab the facebook_url element
    @Element(required = false)
    private String facebook_url;

    //Returns the variables and turns them into a neatly formatted string for the output.
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n\n",
                state,slug,code,nickname,website,admission_date,admission_number,capital_city,capital_url,population,
                population_rank,constitution_url,state_flag_url,state_seal_url,map_image_url,landscape_background_url,
                skyline_background_url,twitter_url,facebook_url);
    }//End of toString
}//End of State.class