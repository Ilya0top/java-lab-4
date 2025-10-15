package org.example;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс, представляющий сотрудника организации.
 * <p>
 * Содержит информацию о сотруднике: идентификатор, имя, пол, подразделение,
 * зарплату и дату рождения. Все поля являются неизменяемыми (immutable).
 * </p>
 *
 * @author ilabe
 * @version 1.0
 */
public class Person
{
    /** Уникальный идентификатор сотрудника */
    private final int id;

    /** Имя сотрудника */
    private final String name;

    /** Пол сотрудника */
    private final String gender;

    /** Подразделение, в котором работает сотрудник */
    private final Department department;

    /** Зарплата сотрудника */
    private final double salary;

    /** Дата рождения сотрудника */
    private final LocalDate birthDate;

    /**
     * Создает новый объект сотрудника.
     *
     * @param id уникальный идентификатор сотрудника
     * @param name имя сотрудника
     * @param gender пол сотрудника
     * @param department подразделение сотрудника
     * @param salary зарплата сотрудника
     * @param birthDate дата рождения сотрудника
     */
    public Person(int id, String name, String gender, Department department, double salary, LocalDate birthDate)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает уникальный идентификатор сотрудника.
     *
     * @return идентификатор сотрудника
     */
    public int getId()
    {
        return id;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName()
    {
        return name;
    }

    /**
     * Возвращает пол сотрудника.
     *
     * @return пол сотрудника
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Возвращает подразделение сотрудника.
     *
     * @return объект подразделения
     */
    public Department getDepartment()
    {
        return department;
    }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата сотрудника
     */
    public double getSalary()
    {
        return salary;
    }

    /**
     * Возвращает дату рождения сотрудника.
     *
     * @return дата рождения сотрудника
     */
    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    /**
     * Сравнивает данный объект сотрудника с другим объектом на равенство.
     * <p>
     * Два объекта считаются равными, если у них совпадают все поля:
     * id, name, gender, department, salary и birthDate.
     * </p>
     *
     * @param obj объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
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

    /**
     * Возвращает хэш-код объекта сотрудника.
     * <p>
     * Хэш-код вычисляется на основе всех полей объекта.
     * </p>
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, gender, department, salary, birthDate);
    }

    /**
     * Возвращает строковое представление объекта сотрудника.
     * <p>
     * Формат строки: "Person{id: [id], name: [name], gender: [gender],
     * department: [department], salary: [salary], birthDate: [birthDate]}"
     * </p>
     *
     * @return строковое представление сотрудника
     */
    @Override
    public String toString()
    {
        return "Person{id: " + id + ", name: " + name + ", gender: " + gender + ", department: " + department + ", salary: " + salary + ", birthDate: " + birthDate + "}";
    }
}
