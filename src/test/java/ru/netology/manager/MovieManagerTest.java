package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void shouldSetItemsNumber() {
        MovieManager manager = new MovieManager();
        manager.setItemsNumber(7);
        int expected = 7;
        int actual = manager.getItemsNumber();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetLast10ByDefault() {
        MovieManager manager = new MovieManager();
        FilmItem one = new FilmItem(1, 1, "url", "name", "film");
        FilmItem two = new FilmItem(2, 2, "url", "name", "film");
        FilmItem three = new FilmItem(3, 3, "url", "name", "film");
        FilmItem four = new FilmItem(4, 4, "url", "name", "film");
        FilmItem five = new FilmItem(5, 5, "url", "name", "film");
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        manager.addFilm(four);
        manager.addFilm(five);

        FilmItem[] actual = manager.getLastN();
        FilmItem[] expected = new FilmItem[]{ five, four, three, two, one};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAnyItemsNumber() {
        MovieManager manager = new MovieManager(3);
        FilmItem one = new FilmItem(1, 1, "url", "name", "film");
        FilmItem two = new FilmItem(2, 2, "url", "name", "film");
        FilmItem three = new FilmItem(3, 3, "url", "name", "film");
        manager.addFilm(one);
        manager.addFilm(two);
        manager.addFilm(three);
        FilmItem[] actual = manager.getLastN();
        FilmItem[] expected = new FilmItem[]{three, two, one};

        assertArrayEquals(expected, actual);
    }
}