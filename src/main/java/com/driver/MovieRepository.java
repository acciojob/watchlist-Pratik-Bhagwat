package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap = new HashMap<>();
    HashMap<String,Director> directorMap = new HashMap<>();
    HashMap<String,Set<String>> directorToMovieMap = new HashMap<>();

    public boolean addMovie(Movie movie){
        if(movieMap.containsKey(movie.getName())) return false;
        movieMap.put(movie.getName(),movie);
        return true;
    }
    public boolean addDirector(Director director){
        if(directorMap.containsKey(director.getName())) return false;
        directorMap.put(director.getName(),director);
        return true;
    }
    public void addMovieToDirector(String movie,String director){
        directorToMovieMap.putIfAbsent(director,new HashSet<>());
        //if(directorToMovieMap.get(director).contains(movie)) return false;
        directorToMovieMap.get(director).add(movie);
    }

    public Movie getMovie(String movie){
        if(!movieMap.containsKey(movie)) return new Movie();
        return movieMap.get(movie);
    }

    public Director getDirector(String director){
        if(!directorMap.containsKey(director)) return new Director();
        return directorMap.get(director);
    }

    public List<String> getMoviesOfDirector(String director){
        List<String> list = new ArrayList<>();
        if(!directorToMovieMap.containsKey(director)) return list;

        list.addAll(directorToMovieMap.get(director));

        return list;
    }
    public List<String> getAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    public List<String> getAllDirectors(){
        return new ArrayList<>(directorMap.keySet());
    }

    public void deleteDirector(String director){
        if(!directorMap.containsKey(director)) return;
        for(String movie:directorToMovieMap.get(director))
            movieMap.remove(movie);
        directorMap.remove(director);
        directorToMovieMap.remove(director);
    }
}