package org.example;

import java.util.Objects;

/**
 * Класс, представляющий подразделение организации.
 * <p>
 * Содержит информацию о подразделении: уникальный идентификатор и название.
 * Все поля являются неизменяемыми. Идентификатор генерируется
 * автоматически при создании подразделения.
 * </p>
 *
 * @author ilabe
 * @version 1.0
 */
public class Department
{
    /** Уникальный идентификатор подразделения */
    private final int id;

    /** Название подразделения */
    private final String name;

    /**
     * Создает новый объект подразделения.
     *
     * @param id уникальный идентификатор подразделения
     * @param name название подразделения
     */
    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Возвращает уникальный идентификатор подразделения.
     *
     * @return идентификатор подразделения
     */
    public int getId()
    {
        return id;
    }

    /**
     * Возвращает название подразделения.
     *
     * @return название подразделения
     */
    public String getName()
    {
        return name;
    }

    /**
     * Сравнивает данный объект подразделения с другим объектом на равенство.
     * <p>
     * Два объекта подразделения считаются равными, если у них совпадают
     * идентификатор и название.
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
        Department that = (Department) obj;
        return id == that.id && Objects.equals(name, that.name);
    }

    /**
     * Возвращает хэш-код объекта подразделения.
     * <p>
     * Хэш-код вычисляется на основе идентификатора и названия подразделения.
     * </p>
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }

    /**
     * Возвращает строковое представление объекта подразделения.
     * <p>
     * Формат строки: "Department{id: [id], name: [name]}"
     * </p>
     *
     * @return строковое представление подразделения
     */
    @Override
    public String toString()
    {
        return "Department{id: " + id + ", name: " + name + "}";
    }
}
