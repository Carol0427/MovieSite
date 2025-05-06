package com.moviesite.project.services;
import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.moviesite.project.models.Movie;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class getTopMoviesSrv {
    private final WebClient webClient;

    public getTopMoviesSrv(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> fetchTopBoxOfficeMono() {
        return webClient.get()
                .uri(URI.create("https://imdb236.p.rapidapi.com/imdb/top-box-office"))
                .header("x-rapidapi-key", "233ddb7bf5msh92906894e2155e1p154280jsn12962e25475f")
		        .header("x-rapidapi-host", "imdb236.p.rapidapi.com")
                .retrieve()
                .bodyToMono(String.class); // Automatically maps JSON array to list of UserInfo
    }

    public Flux<Movie> fetchTopBoxOffice() {
        return webClient.get()
                .uri(URI.create("https://imdb236.p.rapidapi.com/imdb/top-box-office"))
                .header("x-rapidapi-key", "233ddb7bf5msh92906894e2155e1p154280jsn12962e25475f")
		        .header("x-rapidapi-host", "imdb236.p.rapidapi.com")
                .retrieve()
                .bodyToFlux(Movie.class); // Automatically maps JSON array to list of Movies
    }
}
