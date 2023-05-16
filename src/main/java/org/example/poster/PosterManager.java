package org.example.poster;


public class PosterManager {
    private Poster[] movies = new Poster[0];
    private int limit;
    public PosterManager(){
        this.limit=5;

    }
    public PosterManager(int limit){
        this.limit=limit;

    }
    //private String[] films = new String[0];//0 потому что изначально фильмов нет
    public void save(Poster movie ) {         //добавление фильмов
    Poster[] tmp = new Poster[movies.length+1];
    for (int i=0; i<movies.length; i++) {
        tmp[i] = movies[i];
    }
    tmp[tmp.length-1]=movie;
    movies=tmp;
    }

    public Poster[] findAll() {//показ всех фильмов
        return movies;
    }

    public Poster[] findLast() { //показ 5 последне добавленных фильмов
        int resultLength;
        if (movies.length>limit) {
            resultLength = limit;
        }else{
            resultLength= movies.length;
        }

        Poster[]tmp = new Poster[resultLength];
        for (int i=0; i<tmp.length; i++){
            tmp[i]=movies[movies.length-1-i];
        }
        return tmp;
    }
}
