package org.example;

import java.util.List;
import java.util.Map;

public class Main
{
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

    private static String getFilePath(String[] args)
    {
        if (args.length > 0)
            return args[0];
        else
            // По умолчанию используем файл из ресурсов
            return "foreign_names.csv";
    }

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