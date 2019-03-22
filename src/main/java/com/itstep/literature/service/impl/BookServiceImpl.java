package com.itstep.literature.service.impl;

import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.dao.impl.BookDAOImpl;
import com.itstep.literature.model.impl.Book;
import com.itstep.literature.service.BookService;

import java.util.List;

/**
 * класс реализует интерфейс BookService, получает данные DAO слоя
 *
 * @author Слижова Олеся
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    /**
     * переопределеный метод, получает все книги, написанные определенный автором по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат метода getAllBooksByAuthorId из класса BookDAOImpl
     */
    @Override
    public List<Book> findAllByAuthorId(int id) {
        return bookDAO.findAllByAuthorId(id);
    }
}
