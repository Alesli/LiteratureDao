package com.itstep.literature.service;

import com.itstep.literature.model.impl.Book;

import java.util.List;

/**
 * интерфейс выводит книги по id автора,
 * данные в последующем используются в классе LiteratureFacadeImpl
 *
 * @author Слижова Олеся
 */
public interface BookService {

    List<Book> findAllByAuthorId(int id);
}
