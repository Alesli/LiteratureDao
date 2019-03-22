package com.itstep.literature;

import com.itstep.literature.facade.LiteratureFacade;
import com.itstep.literature.facade.impl.LiteratureFacadeImpl;
import com.itstep.literature.model.impl.Author;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LiteratureFacade literatureFacade = new LiteratureFacadeImpl();
//
//        List<Author> author = literatureFacade.getAllAuthors();
//        for (Author author1 : author) {
//            System.out.println(author1);
//        }
//
        Author author = literatureFacade.getAuthorById(8);
        System.out.println(author);


    }
}
