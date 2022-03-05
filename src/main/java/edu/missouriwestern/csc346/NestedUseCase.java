package edu.missouriwestern.csc346;

import org.simpleframework.xml.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This program is used to turn a nested XML file into a nested amount of POJOs.
 * Where the program will grab from a URL ("https://w1.weather.gov/xml/current_obs/KSTJ.xml"), read from that URL,
 * and then created nested objects from the XML from that URL.
 * The URL uses XLS in order to give a graphical interface to the URL,
 * which we will just be grabbing the elements from the XML by itself.
 *
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 */
public class NestedUseCase {
    public static void main(String[] args) {
        //We start off by creating a Persister.
        Serializer serializer = new Persister();

        try{
            //We create a URL object and have it as the URL we want to grab from.
            URL url = new URL("https://w1.weather.gov/xml/current_obs/KSTJ.xml");

            //We then use a BufferedReader open the URL stream and grab the XML file from the URL.
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            //We then create the Weather object and use the serializer to read the BufferedReader and convert
            //the incoming XML file to the Weather object.
            Weather weather = serializer.read(Weather.class, in);
            in.close();

            System.out.println(weather.toString());
        }catch(Exception e){
            //In case we are unable to grab the URL, we then have to have an exception.
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
            System.exit(1);
        }
    }
}

/**
 * This class is to serve as our weather object, where the root will be from the name current_observation.
 * There is a nested object involved with this class.
 */
@Root(strict = false, name="current_observation")
class Weather{

    //We grab the version attribute from the root.
    @Attribute
    private double version;

    //We grab the credit element
    @Element
    private String credit;

    //We grab the credit_URL element
    @Element
    private String credit_URL;

    //We grab the image element, which will be given its own object.
    @Element
    private Image image;

    //We grab the location element
    @Element
    private String location;

    //We grab the station_id element
    @Element
    private String station_id;

    //We grab the observation_time
    @Element
    private String observation_time;

    //We grab the observation_time_rfc822
    @Element
    private String observation_time_rfc822;

    //We grab the weather element
    @Element
    private String weather;

    //We grab the temp_f element
    @Element
    private double temp_f;

    //We grab the temp_c element
    @Element
    private double temp_c;

    //We have the various amount of getters for each variable in the object.
    public double getVersion(){return version;}

    public String getCredit(){return credit;}

    public String getCredit_URL(){return credit_URL;}

    public String getImageUrl(){return image.getUrl();}

    public String getImageTitle(){return image.getTitle();}

    public String getImageLink(){return image.getLink();}

    public String getLocation(){return location;}

    public String getStation_id(){return station_id;}

    public String getObservation_time(){return observation_time;}

    public String getObservation_time_rfc822(){return observation_time_rfc822;}

    public String getWeather(){return weather;}

    public double getTemp_f(){return temp_f;}

    public double getTemp_c(){return temp_c;}

    //Returns the variables and turns them into a neatly formatted string for the output.
    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",version,credit,credit_URL,image.getUrl(),image.getTitle(),image.getLink(),
                location,station_id,observation_time,observation_time_rfc822,weather,temp_f,temp_c);
    }//End of toString
}//End of Weather.class

/**
 * This class serves to grab the various nested elements from the image element.
 */
class Image{

    //We grab the url element
    @Element
    private String url;

    //We grab the title element
    @Element
    private String title;

    //We grab the link element
    @Element
    private String link;

    //We set getters for each variable in the object.
    public String getUrl(){return url;}

    public String getTitle(){return title;}

    public String getLink(){return link;}
}//End of Image.class