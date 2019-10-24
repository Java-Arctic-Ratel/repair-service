package com.epam;

public class Executor {

    private Integer executorId;

    private Integer executorOrderId;

    private Integer firstNameId;

    private Integer lastNameId;

    private Integer patronymicId;

    public Integer getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Integer executorId) {
        this.executorId = executorId;
    }

    public Integer getExecutorOrderId() {
        return executorOrderId;
    }

    public void setExecutorOrderId(Integer executorOrderId) {
        this.executorOrderId = executorOrderId;
    }

    public Integer getFirstNameId() {
        return firstNameId;
    }

    public void setFirstNameId(Integer firstNameId) {
        this.firstNameId = firstNameId;
    }

    public Integer getLastNameId() {
        return lastNameId;
    }

    public void setLastNameId(Integer lastNameId) {
        this.lastNameId = lastNameId;
    }

    public Integer getPatronymicId() {
        return patronymicId;
    }

    public void setPatronymicId(Integer patronymicId) {
        this.patronymicId = patronymicId;
    }

    public Executor() {
    }

    public Executor(Integer executorOrderId, Integer firstNameId, Integer lastNameId, Integer patronymicId) {
        this.executorOrderId = executorOrderId;
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.patronymicId = patronymicId;
    }

    @Override
    public String toString() {
        return "Executor{" +
                "executorId=" + executorId +
                ", executorOrderId=" + executorOrderId +
                ", firstNameId=" + firstNameId +
                ", lastNameId=" + lastNameId +
                ", patronymicId=" + patronymicId +
                '}';
    }
}
