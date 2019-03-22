package com.itstep.literature.service;

import com.itstep.literature.model.impl.Author;

import java.util.List;

/**
 * интерфейс выводит автора по id и коллекцию авторов,
 * данные в последующем используются в классе LiteratureFacadeImpl
 *
 * @author Слижова Олеся
 */
public interface AuthorService {

    Author getOne(int id);

    List<Author> findAll();
}
