package com.epam;

public class Patronymic {

    private Integer patronymicId;

    private String patronymic;

    public Integer getPatronymicId() {
        return patronymicId;
    }

    public void setPatronymicId(Integer patronymicId) {
        this.patronymicId = patronymicId;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Patronymic() {
    }

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
