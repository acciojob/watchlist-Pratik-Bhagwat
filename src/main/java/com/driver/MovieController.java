package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping ("/add-movie")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added Successfully", HttpStatus.CREATED);
    }
    @PostMapping ("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added Successfully",HttpStatus.CREATED);
    }
    @PutMapping ("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam ("movieName") String movieName,@RequestParam("directorName") String directorName) {
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Added Pair Successfully",HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName (@PathVariable ("name") String name) {
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name")
    public ResponseEntity<Director> getDirectorByName (@PathVariable ("name") String name) {
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable ("directorName") String directorName) {
        List<String> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName (@RequestParam ("directorName") String directorName) {
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Director deleted Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Deleted All Directors form DataBase",HttpStatus.OK);
    }
}
