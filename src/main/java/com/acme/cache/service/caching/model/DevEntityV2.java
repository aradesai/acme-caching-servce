package com.acme.cache.service.caching.model;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEVELOPERS")
public class DevEntityV2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "GENDER")
    private GenderV2 gender;

    @Column(name = "LANGUAGES")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "LANGUAGES"
            , joinColumns = @JoinColumn(name = "id"))
    private Set<ProgrammingLanguagesV2> knownLanguages;

    public DevEntityV2() {
    }

    public DevEntityV2(String firstName, String lastName, int salary, GenderV2 gender, Set<ProgrammingLanguagesV2> knownLanguages) {
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
        DevEntityV2 devEntity = (DevEntityV2) o;
        return salary == devEntity.salary &&
                Objects.equals(id, devEntity.id) &&
                Objects.equals(firstName, devEntity.firstName) &&
                Objects.equals(lastName, devEntity.lastName) &&
                gender == devEntity.gender &&
                Objects.equals(knownLanguages, devEntity.knownLanguages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, gender, knownLanguages);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DevEntity{");
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
