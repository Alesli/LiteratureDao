package com.itstep.literature.dao.impl;

import com.itstep.literature.jdbc.ServerConnector;
import com.itstep.literature.dao.AuthorDAO;
import com.itstep.literature.model.impl.Author;
import com.itstep.literature.jdbc.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс AuthorDAO, получает данные из таблиц БД MySQL
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 * @author Слижова Олеся
 */
public class AuthorDAOImpl implements AuthorDAO {

    /**
     * переопределеный метод, получает автора книги по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат запроса getOneAuthor из файла mysql_queries.properties
     */
    @Override
    public Author getOne(int id) {

        Connection connection = ServerConnector.getInstance().getConnection();
        String query = ServerQuery.getInstance().getQuery("getOneAuthor");

        Author author = new Author();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // подготавливаем запрос, т.е. подставляем его строковое представление в connection
            preparedStatement = connection.prepareStatement(query);
            // устанавливаем параметр для запроса
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setYears(resultSet.getString(3));
                author.setGenre(resultSet.getString(4));
                author.setDescription(resultSet.getString(5));

                author.setBooks(new ArrayList<>());
            }
            return author;

        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, resultSet);
        }
        return author;
    }

    /**
     * переопределеный метод, получает список авторов по входному параметру
     *
     * @return результат запроса getAllAuthors из файла mysql_queries.properties
     */
    @Override
    public List<Author> findAll() {

        Connection connection = ServerConnector.getInstance().getConnection();
        String query = ServerQuery.getInstance().getQuery("getAllAuthors");

        List<Author> authorsList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author();

                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setYears(resultSet.getString(3));
                author.setGenre(resultSet.getString(4));
                author.setDescription(resultSet.getString(5));

                author.setBooks(new ArrayList<>());

                authorsList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return authorsList;
    }

    /**
     * метод закрывает соединение
     *
     * @param preparedStatement
     * @param resultSet
     */
    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
