package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Person
{
    private final int id;
    private final String name;
    private final String gender;
    private final Department department;
    private final double salary;
    private final LocalDate birthDate;

    public Person(int id, String name, String gender, Department department, double salary, LocalDate birthDate)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getGender()
    {
        return gender;
    }

    public Department getDepartment()
    {
        return department;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return id == person.id && Double.compare(person.salary, salary) == 0 && Objects.equals(name, person.name) && Objects.equals(gender, person.gender) && Objects.equals(department, person.department) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, gender, department, salary, birthDate);
    }

    @Override
    public String toString()
    {
        return "Person{id: " + id + ", name: " + name + ", gender: " + gender + ", department: " + department + ", salary: " + salary + ", birthDate: " + birthDate + "}";
    }
}
