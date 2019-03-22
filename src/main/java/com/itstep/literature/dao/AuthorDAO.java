package com.itstep.literature.dao;

import com.itstep.literature.model.impl.Author;

import java.util.List;

/**
 * интерфейс, обеспечивающий доступ к базе данных Mysql
 *
 * @author Слижова Олеся
 */
public interface AuthorDAO {

    Author getOne(int id);

    List<Author> findAll();

}
