package com.itstep.literature.model.impl;

import com.itstep.literature.model.BasisLiterature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * класс, унаследованный от астрактного класса BasisLiterature
 *
 * @author Слижова Олеся
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author extends BasisLiterature {

    private List<Book> books;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Book book : books) {
            b.append("\t" + book + "\n");
        }
        return "Author: " + super.toString() + "\n    " + "Book: " + "\n" + b.toString();
    }
}
