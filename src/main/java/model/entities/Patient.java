package model.entities;


public class Patient {

    private int id;
    private String lastName;
    private String firstName;
    private String surName;

    public static class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private String surName;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Patient build(){
            Patient patient = new Patient();
            patient.setId(id);
            patient.setLastName(lastName);
            patient.setFirstName(firstName);
            patient.setSurName(surName);
            return patient;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

}
