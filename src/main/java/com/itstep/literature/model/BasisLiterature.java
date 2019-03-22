package com.itstep.literature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * интерфейс, содержащий поля таблиц БД
 *
 * @author Слижова Олеся
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BasisLiterature {

    private int id;
    private String name;
    private String years;
    private String genre;
    private String description;

    @Override
    public String toString() {
        return id + " " + name + ", " + years + "; " + genre + "; " + description;
    }
}
