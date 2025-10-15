package org.example;

import java.util.List;
import java.util.Map;

/**
 * Главный класс, который служит для чтения и анализа данных о сотрудниках из CSV файла.
 * <p>
 * Приложение читает CSV файл с информацией о сотрудниках, преобразует данные в объекты
 * и выводит стсатистику по подразделениям.
 * </p>
 *
 * @author ilabe
 * @version 1.0
 */
public class Main
{
    /**
     * Основной метод.
     * <p>
     * Читает CSV файл, преобразует данные в список сотрудников и выводит статистику.
     * Путь к файлу можно передать как аргумент командной строки.
     * </p>
     *
     * @param args аргументы командной строки. Первый аргумент - путь к CSV файлу.
     *             Если аргументы не переданы, используется файл по умолчанию.
     */
    public static void main(String[] args)
    {
        System.out.println("=== CSV Reader Started ===");
        CsvReader csvReader = new CsvReader();

        try
        {
            String filePath = getFilePath(args);
            System.out.println("Reading people from CSV file: " + filePath);

            List<Person> people = csvReader.readPeopleFromCsv(filePath);

            System.out.println("\n=== RESULTS ===");
            System.out.println("Successfully read " + people.size() + " people");


            System.out.println("\nFirst 10 people:");
            for (int i = 0; i < Math.min(10, people.size()); i++)
                System.out.println((i + 1) + ". " + people.get(i));

            printDepartmentStatistics(people);

        }
        catch (Exception e)
        {
            System.err.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Определяет путь к CSV файлу на основе аргументов командной строки.
     * <p>
     * Если аргументы переданы, используется первый аргумент как путь к файлу.
     * Если аргументы не переданы, используется файл по умолчанию из ресурсов.
     * </p>
     *
     * @param args массив аргументов командной строки
     * @return путь к CSV файлу для обработки
     */
    private static String getFilePath(String[] args)
    {
        if (args.length > 0)
            return args[0];
        else
            // По умолчанию используем файл из ресурсов
            return "foreign_names.csv";
    }

    /**
     * Выводит статистику по подразделениям.
     * <p>
     * Рассчитывает и отображает для каждого подразделения количество сотрудников и среднюю зарплату
     * </p>
     *
     * @param people список сотрудников для анализа
     */
    private static void printDepartmentStatistics(List<Person> people)
    {
        System.out.println("\n=== DEPARTMENT STATISTICS ===");
        Map<String, Integer> deptCount = new java.util.HashMap<>();
        Map<String, Double> deptSalary = new java.util.HashMap<>();

        for (Person person : people)
        {
            String deptName = person.getDepartment().getName();
            deptCount.put(deptName, deptCount.getOrDefault(deptName, 0) + 1);
            deptSalary.put(deptName, deptSalary.getOrDefault(deptName, 0.0) + person.getSalary());
        }

        for (String dept : deptCount.keySet())
        {
            int count = deptCount.get(dept);
            double avgSalary = deptSalary.get(dept) / count;
            System.out.printf("Department %s: %d people, average salary: %.2f%n", dept, count, avgSalary);
        }
    }
}