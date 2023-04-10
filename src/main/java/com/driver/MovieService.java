package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository repository;
    public void addMovie(Movie movie) {
        repository.addMovie(movie);
    }

    public void addDirector(Director director) {
        repository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        repository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String name) {
        return repository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return repository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return repository.getMoviesByDirectorName(directorName);
    }

    public List<Movie> findAllMovies() {
        return repository.findAllMovies();
    }

    public void deleteDirectorByName(String directorName) {
        repository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        repository.deleteAllDirectors();
    }
}
