package org.example.poster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    Poster movie1 = new Poster("Бладшот", "боевик", "01.01.2023");
    Poster movie2 = new Poster("Вперед", "мультфильм", "01.02.2023");
    Poster movie3 = new Poster("Отель Белград", "комедия", "15.02.2023");
    Poster movie4 = new Poster("Джентельмены", "боевик", "20.02.2023");
    Poster movie5 = new Poster("Человек-невидимка", "ужасы", "10.03.2023");
    Poster movie6 = new Poster("Тролли.Мировой тур", "мультфильм", "23.03.2023");
    Poster movie7 = new Poster("Номер один", "комедия", "1.04.2023");

    @BeforeEach
    public void shouldSave() {
        PosterManager manager = new PosterManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Poster[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave2() {
        PosterManager manager = new PosterManager();
        manager.save(movie1);
        manager.save(movie2);

        Poster[] expected = {movie1, movie2};
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        PosterManager manager = new PosterManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Poster[] expected = {movie7, movie6, movie5, movie4, movie3};
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLessLimit() {
        PosterManager manager = new PosterManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

        Poster[] expected = {movie7, movie6, movie5, movie2, movie1};
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
