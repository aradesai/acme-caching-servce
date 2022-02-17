package com.acme.cache.service.caching.model;


import java.util.Objects;
import java.util.Set;

public class DevFormModelV2 {

    private Long id;

    private String firstName;

    private String lastName;

    private int salary;

    private GenderV2 gender;

    private Set<ProgrammingLanguagesV2> knownLanguages;

    public DevFormModelV2() {
    }

    public DevFormModelV2(Long id, String firstName, String lastName, int salary, GenderV2 gender, Set<ProgrammingLanguagesV2> knownLanguages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.knownLanguages = knownLanguages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public GenderV2 getGender() {
        return gender;
    }

    public void setGender(GenderV2 gender) {
        this.gender = gender;
    }

    public Set<ProgrammingLanguagesV2> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(Set<ProgrammingLanguagesV2> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevFormModelV2 that = (DevFormModelV2) o;
        return salary == that.salary &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                gender == that.gender &&
                Objects.equals(knownLanguages, that.knownLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, gender, knownLanguages);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DevFormModel{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", gender=").append(gender);
        sb.append(", knownLanguages=").append(knownLanguages);
        sb.append('}');
        return sb.toString();
    }
}
