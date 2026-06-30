package com.gladysz.future.compose;

import java.util.Objects;

public class Movie {

    private final Long id;
    private final String title;
    private final String director;


    public Movie(Long id, String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
