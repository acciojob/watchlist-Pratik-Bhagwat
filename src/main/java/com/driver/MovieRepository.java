package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDB = new HashMap<>();
    HashMap<String,Director> directorDB = new HashMap<>();
    HashMap<String,List<String>> directorMoviePairDB = new HashMap<>();
    List<Movie> moviesList = new ArrayList<>();
    public void addMovie(Movie movie) {
        movieDB.put(movie.getName(),movie);
        moviesList.add(movie);
    }

    public void addDirector(Director director) {
        directorDB.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(directorMoviePairDB.containsKey(directorName)) {
            List<String> oldMovieList = directorMoviePairDB.get(directorName);
            oldMovieList.add(movieName);
            directorMoviePairDB.put(directorName,oldMovieList);
        }
        else {
            List<String> newMovieList = new ArrayList<>();
            newMovieList.add(movieName);
            directorMoviePairDB.put(directorName,newMovieList);
        }
    }

    public Movie getMovieByName(String name) {
        for (Movie movie : movieDB.values()) {
            if(movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name) {
        for (Director director : directorDB.values()) {
            if(director.getName().equals(name)) {
                return director;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return directorMoviePairDB.get(directorName);
    }

    public List<Movie> findAllMovies() {
        return moviesList;
    }

    public void deleteDirectorByName(String directorName) {
        List<String> list = directorMoviePairDB.get(directorName);
        directorMoviePairDB.remove(directorName);
        for(String s : list) {
            movieDB.remove(s);
            moviesList.removeIf(m -> m.getName().equals(s));
        }
    }

    public void deleteAllDirectors() {
        directorMoviePairDB.clear();
    }
}
