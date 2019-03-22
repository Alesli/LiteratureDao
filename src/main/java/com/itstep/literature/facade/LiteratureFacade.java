package com.itstep.literature.facade;

import com.itstep.literature.model.impl.Author;
import com.itstep.literature.model.impl.Book;

import java.util.List;

/**
 * интерфейс выводит автора по id и коллекцию авторов
 *
 * @author Слижова Олеся
 */
public interface LiteratureFacade {

    Author getAuthorById(int id);

    List<Author> getAllAuthors();

}
