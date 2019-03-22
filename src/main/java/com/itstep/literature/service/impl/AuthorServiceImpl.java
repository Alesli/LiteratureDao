package com.itstep.literature.service.impl;

import com.itstep.literature.dao.AuthorDAO;
import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.dao.impl.AuthorDAOImpl;
import com.itstep.literature.dao.impl.BookDAOImpl;
import com.itstep.literature.model.impl.Author;
import com.itstep.literature.model.impl.Book;
import com.itstep.literature.service.AuthorService;

import java.util.List;

/**
 * класс, реализующий интерфейс AuthorService, выводит автора по id и коллекцию авторов,
 * получает данные DAO слоя
 *
 * @author Слижова Олеся
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO = new AuthorDAOImpl();

    private BookDAO bookDAO = new BookDAOImpl();

    /**
     * переопределеный метод выводит автрора по id
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return author, данные автора из таблицы БД
     */
    @Override
    public Author getOne(int id) {
        List<Book> books = bookDAO.findAllByAuthorId(id);
        Author author = authorDAO.getOne(id);
        author.setBooks(books);
        return author;
    }

    /**
     * переопределеный метод, получает список авторов и все их книги
     *
     * @return колллекция, данные авторов и их книг из таблицы БД
     */
    @Override
    public List<Author> findAll() {
        List<Author> authors = authorDAO.findAll();
        for (Author author : authors) {
            List<Book> books = bookDAO.findAllByAuthorId(author.getId());
            author.setBooks(books);
        }
        return authors;
    }
}
