package ua.gerasymiuk.TimerForHerokuSites;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class Main {
    private static final String USER_AGENT = "MyBot/1.0";
    public static void main(String[] args) {
        new java.util.Timer().schedule(
                new TimerTask() {
                    public void run() {
                        try {
                            sendGet("http://gerasymiuk.herokuapp.com/");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                0 ,500*3600);
    }
    private static void sendGet(String url) throws Exception {


        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

    }
}
