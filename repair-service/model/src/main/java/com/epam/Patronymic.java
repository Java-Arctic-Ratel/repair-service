package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Patronymic.
 */
@Entity
public class Patronymic {

    @Id
    @GeneratedValue
    private Integer patronymicId;

    private String patronymic;

    /**
     * Gets patronymic id.
     *
     * @return the patronymic id
     */
    public Integer getPatronymicId() {
        return patronymicId;
    }

    /**
     * Sets patronymic id.
     *
     * @param patronymicId the patronymic id
     */
    public void setPatronymicId(Integer patronymicId) {
        this.patronymicId = patronymicId;
    }

    /**
     * Gets patronymic.
     *
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets patronymic.
     *
     * @param patronymic the patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Instantiates a new Patronymic.
     */
    public Patronymic() {
    }

    /**
     * Instantiates a new Patronymic.
     *
     * @param patronymic the patronymic
     */
    public Patronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Patronymic{" +
                "patronymicId=" + patronymicId +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
