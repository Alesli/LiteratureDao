package com.itstep.literature.dao.impl;

import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.jdbc.ServerConnector;
import com.itstep.literature.jdbc.ServerQuery;
import com.itstep.literature.model.impl.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс BookDAO, получает данные из таблиц БД MySQL,
 * с использованием JDBC.
 *
 * @author Слижова Олеся
 */
public class BookDAOImpl implements BookDAO {

    private Connection connection = ServerConnector.getInstance().getConnection();

    /**
     * переопределеный метод, получает все книги, написанные определенный автором по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат запроса "getAllBooksByAuthorId" в БД
     */
    @Override
    public List<Book> findAllByAuthorId(int id) {

        String query = ServerQuery.getInstance().getQuery("getAllBooksByAuthorId");
        List<Book> books = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = getBook(resultSet);
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return books;
    }

    /**
     * метод обеспечивает построчный доступ к результатам запросов,
     * прописанного в файле mysql_queries.properties
     *
     * @param resultSet
     * @return данные книги из запроса
     */
    private Book getBook(ResultSet resultSet) {

        try {
            Book book = new Book();
            book.setId(resultSet.getInt(1));
            book.setName(resultSet.getString(2));
            book.setYears(resultSet.getString(3));
            book.setGenre(resultSet.getString(4));
            book.setDescription(resultSet.getString(5));
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
