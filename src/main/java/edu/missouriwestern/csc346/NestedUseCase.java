package edu.missouriwestern.csc346;
import org.simpleframework.xml.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Authors Marshall Stone, Cooper Jones, Gabriel Adams, Josh Mesmer
 * @Since February 2022
 */
public class NestedUseCase {
    public static void main(String[] args) {
        Serializer serializer = new Persister();

        try{
            URL url = new URL("https://w1.weather.gov/xml/current_obs/KSTJ.xml");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            Weather weather = serializer.read(Weather.class, in);
            in.close();

            System.out.println(weather.toString());
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }
}

@Root(strict = false, name="curent_observation")
class Weather{
    @Attribute
    private double version;

    @Element
    private String credit;

    @Element
    private String credit_URL;

    @Element
    private Image image;

    @Element
    private String location;

    @Element
    private String station_id;

    @Element
    private String observation_time;

    @Element
    private String observation_time_rfc822;

    @Element
    private String weather;

    @Element
    private double temp_f;

    @Element
    private double temp_c;

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

    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",version,credit,credit_URL,image.getUrl(),image.getTitle(),image.getLink(),
                location,station_id,observation_time,observation_time_rfc822,weather,temp_f,temp_c);
    }
}

class Image{
    @Element
    private String url;
    @Element
    private String title;
    @Element
    private String link;

    public String getUrl(){return url;}
    public String getTitle(){return title;}
    public String getLink(){return link;}
}