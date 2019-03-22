package com.itstep.literature.facade.impl;

import com.itstep.literature.facade.LiteratureFacade;
import com.itstep.literature.model.impl.Author;
import com.itstep.literature.service.AuthorService;
import com.itstep.literature.service.impl.AuthorServiceImpl;

import java.util.List;

/**
 * класс, реализующий интерфейс LiteratureFacade, выводит результат работы методов DAO и Service слоев
 *
 * @author Слижова Олеся
 */
public class LiteratureFacadeImpl implements LiteratureFacade {

    private AuthorService authorService = new AuthorServiceImpl();

    /**
     * переопределенный метод, выводит автора по первичному ключу
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return метод getOne из Service слоя
     */
    @Override
    public Author getAuthorById(int id) {
        return authorService.getOne(id);
    }

    /**
     * переопределенный метод, выводит всех авторов
     *
     * @return метод findAll из Service слоя
     */
    @Override
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }
}
