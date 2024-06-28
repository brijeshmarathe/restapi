package org.brijlabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    private static String REST_URL = "https://jsonmock.hackerrank.com/api/tvseries";

    /**
     * @return
     * @throws MalformedURLException
     */
    private static String callAPI() throws MalformedURLException {

        int currentPage = 1;
        int totalPages = 2;
        StringBuilder content = null;
        List<TVShow> tvShows = new ArrayList<TVShow>();

        while (currentPage <= totalPages) {
            try {
                URL url = new URL(REST_URL + "?page=" + currentPage++);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            Response res = processResponse(content.toString());
            // currentPage += res.getPage();
            totalPages = res.getTotal_pages();
            tvShows.addAll(Arrays.asList(res.getData()));

        }
        
        StringBuilder output = new StringBuilder("Shows in range:\n");
        if (tvShows.size()==0) output.append("None");

        for (TVShow show : tvShows) {
            if (show.isRuntimeInRange(2015, 2024))
                output.append(show.getName().trim()).append("\n");
        }

        return output.toString();
    }

    private static Response processResponse(String response) {

        Gson gson = new Gson();
        return  gson.fromJson(response, Response.class);
    }

    public static void main(String[] args) {
        try {
            System.out.println(callAPI());
        } catch (MalformedURLException ex) {
        }
    }
}
