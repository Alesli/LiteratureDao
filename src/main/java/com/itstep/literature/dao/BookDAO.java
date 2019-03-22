package com.itstep.literature.dao;

import com.itstep.literature.model.impl.Book;

import java.util.List;

/**
 * интерфейс, обеспечивающий доступ к базе данных Mysql
 *
 * @author Слижова Олеся
 */
public interface BookDAO {

    List<Book> findAllByAuthorId(int AuthorId);
}
