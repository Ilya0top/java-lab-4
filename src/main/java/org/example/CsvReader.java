package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvReader
{

    public List<Person> readPeopleFromCsv(String csvFilePath) throws IOException
    {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentCache = new HashMap<>();
        int departmentIdCounter = 1;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Looking for file: " + csvFilePath);

        InputStream in = null;
        in = getClass().getClassLoader().getResourceAsStream(csvFilePath);

        if (in == null)
        {
            File file = new File(csvFilePath);
            if (file.exists())
            {
                System.out.println("Found file in project directory: " + file.getAbsolutePath());
                in = new FileInputStream(file);
            }
            else
            {
                file = new File("src/main/resources/" + csvFilePath);
                if (file.exists())
                {
                    System.out.println("Found file in src/main/resources: " + file.getAbsolutePath());
                    in = new FileInputStream(file);
                }
                else
                    throw new FileNotFoundException("File not found: " + csvFilePath + " (checked resources, project root, and src/main/resources)");
            }
        }
        else
            System.out.println("File found in resources!");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8")))
        {
            String header = reader.readLine();
            System.out.println("Header: " + header);

            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (!line.trim().isEmpty())
                {
                    try
                    {
                        String[] fields = line.split(";", -1);

                        if (fields.length >= 6)
                        {
                            int id = Integer.parseInt(fields[0].trim());
                            String name = fields[1].trim();
                            String gender = fields[2].trim();
                            LocalDate birthDate = LocalDate.parse(fields[3].trim(), dateFormatter);
                            String divisionName = fields[4].trim();
                            double salary = Double.parseDouble(fields[5].trim());

                            Department department = departmentCache.get(divisionName);
                            if (department == null)
                            {
                                department = new Department(departmentIdCounter++, divisionName);
                                departmentCache.put(divisionName, department);
                            }

                            Person person = new Person(id, name, gender, department, salary, birthDate);
                            people.add(person);
                        }
                        else
                            System.err.println("Skipping line - not enough fields: " + line);
                    }
                    catch (Exception e)
                    {
                        System.err.println("Error parsing line " + lineCount + ": " + line);
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            }
            System.out.println("Total lines processed: " + lineCount);
            System.out.println("Total people read: " + people.size());
            System.out.println("Total departments created: " + departmentCache.size());

        }
        catch (Exception e)
        {
            System.err.println("Error reading file: " + e.getMessage());
            throw e;
        }
        return people;
    }
}
