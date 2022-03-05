package edu.missouriwestern.csc346;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 */
public class ArrayUseCase{
    public static void main(String[] args){
        try{
            Serializer serializer = new Persister();
            File file = new File("states.xml");

            States states = serializer.read(States.class, file);

            System.out.println(Arrays.toString(states.getStates()));
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }
}

@Root
class States{
    @ElementList(inline = true)
    private List<State> states;

    public Object[] getStates(){return states.toArray();}
}

@Root
class State{
    @Element
    private String state;
    @Element
    private String slug;
    @Element
    private String code;
    @Element
    private String nickname;
    @Element
    private String website;
    @Element
    private String admission_date;
    @Element
    private int admission_number;
    @Element
    private String capital_city;
    @Element
    private String capital_url;
    @Element
    private int population;
    @Element
    private int population_rank;
    @Element
    private String constitution_url;
    @Element
    private String state_flag_url;
    @Element
    private String state_seal_url;
    @Element
    private String map_image_url;
    @Element
    private String landscape_background_url;
    @Element
    private String skyline_background_url;
    @Element(required = false)
    private String twitter_url;
    @Element(required = false)
    private String facebook_url;

    @Override
    public String toString() {
        return "State{" +
                "state='" + state + '\'' +
                ", slug='" + slug + '\'' +
                ", code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", website='" + website + '\'' +
                ", admission_date='" + admission_date + '\'' +
                ", admission_number=" + admission_number +
                ", capital_city='" + capital_city + '\'' +
                ", capital_url='" + capital_url + '\'' +
                ", population=" + population +
                ", population_rank=" + population_rank +
                ", constitution_url='" + constitution_url + '\'' +
                ", state_flag_url='" + state_flag_url + '\'' +
                ", state_seal_url='" + state_seal_url + '\'' +
                ", map_image_url='" + map_image_url + '\'' +
                ", landscape_background_url='" + landscape_background_url + '\'' +
                ", skyline_background_url='" + skyline_background_url + '\'' +
                ", twitter_url='" + twitter_url + '\'' +
                ", facebook_url='" + facebook_url + '\'' +
                '}';
    }
}