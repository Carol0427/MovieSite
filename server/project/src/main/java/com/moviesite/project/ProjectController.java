package com.moviesite.project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class ProjectController {
    
    @GetMapping("/getTopBoxOffice")
    public List<JSONObject> getTopBoxOffice() {
        JSONArray rawData = null;
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://imdb236.p.rapidapi.com/imdb/top-box-office"))
		.header("x-rapidapi-key", "233ddb7bf5msh92906894e2155e1p154280jsn12962e25475f")
		.header("x-rapidapi-host", "imdb236.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            rawData = new JSONArray(response.body());
        }
        catch(IOException | InterruptedException e) {
            System.out.println(e);
        }
        List<JSONObject> updatedData = new ArrayList<>();
        for (int i = 0;i < rawData.length();i++){
            JSONObject jsonObject = rawData.getJSONObject(i);
            JSONObject newjsonObject = new JSONObject();
            newjsonObject.put("title", jsonObject.getString("primaryTitle"));
            newjsonObject.put("runtime", jsonObject.getInt("runtimeMinutes"));
            newjsonObject.put("desc", jsonObject.getString("description"));
            newjsonObject.put("genres", jsonObject.getJSONArray("genres"));
            newjsonObject.put("rating", jsonObject.getInt("averageRating"));
            newjsonObject.put("imageLink", jsonObject.getString("primaryImage"));
            updatedData.add(newjsonObject);
        }
        for (int i = 0;i < updatedData.size();i++){
            System.out.println(updatedData.get(i));
        }
        return updatedData;
    }
    
}
