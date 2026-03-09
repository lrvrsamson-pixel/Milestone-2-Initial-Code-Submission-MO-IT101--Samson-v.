/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
 
package com.mycompany.motorph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeSalaryTool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== MANUAL LOGIN =====
        System.out.println("MOTORPH LOGIN");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (!username.equals("12345") || !password.equals("12345")) {
            System.out.println("Access Denied.");
            return;
        }

        System.out.println("\nLogin Successful!\n");

        // ===== MANUAL EMPLOYEE INPUT =====
        System.out.print("Enter Employee Number: ");
        String empNumber = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Birthday: ");
        String birthday = scanner.nextLine();

        // Default hourly rate and workday
        double defaultHourlyRate = 142;
        double standardDailyHours = 8;
        int standardDays = 5;
        double standardWeeklyHours = standardDailyHours * standardDays;

        // Manual hours input
        System.out.println("\nEnter hours worked each day:");
        System.out.print("Monday: ");
        double mon = scanner.nextDouble();
        System.out.print("Tuesday: ");
        double tue = scanner.nextDouble();
        System.out.print("Wednesday: ");
        double wed = scanner.nextDouble();
        System.out.print("Thursday: ");
        double thu = scanner.nextDouble();
        System.out.print("Friday: ");
        double fri = scanner.nextDouble();

        double totalHours = mon + tue + wed + thu + fri;

        // Hourly rate input (optional)
        System.out.print("\nEnter hourly rate (or 0 for default 142): ");
        double inputRate = scanner.nextDouble();
        double hourlyRate = (inputRate > 0) ? inputRate : defaultHourlyRate;

        // ===== SALARY CALCULATIONS =====
        double grossWeeklySalary = totalHours * hourlyRate;

        double sssPercent = 4.5;
        double philhealthPercent = 1.5;
        double pagibigPercent = 0.4;

        double sssDeduction = grossWeeklySalary * (sssPercent / 100);
        double philhealthDeduction = grossWeeklySalary * (philhealthPercent / 100);
        double pagibigDeduction = grossWeeklySalary * (pagibigPercent / 100);

        // Deviation deduction if total hours not standard
        double deviationDeduction = 0;
        if (totalHours != standardWeeklyHours) {
            deviationDeduction = (standardWeeklyHours - totalHours) * hourlyRate;
        }

        double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction + deviationDeduction;
        double netWeeklySalary = grossWeeklySalary - totalDeductions;

        // ===== OUTPUT =====
        System.out.println("\n===== EMPLOYEE INFORMATION =====");
        System.out.println("Employee Number: " + empNumber);
        System.out.println("Employee Name: " + empName);
        System.out.println("Birthday: " + birthday);

        System.out.println("\n===== WORK SUMMARY =====");
        System.out.println("Total Hours Worked This Week: " + totalHours);

        System.out.println("\n===== SALARY DETAILS =====");
        System.out.println("Gross Weekly Salary: " + grossWeeklySalary);

        System.out.println("\n----- DEDUCTIONS -----");
        System.out.println("SSS (4.5%): " + sssDeduction);
        System.out.println("PhilHealth (1.5%): " + philhealthDeduction);
        System.out.println("Pag-IBIG (0.4%): " + pagibigDeduction);
        if (deviationDeduction != 0) {
            System.out.println("Deviation Deduction: " + deviationDeduction);
        }
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Net Weekly Salary: " + netWeeklySalary);

        // ===== DISPLAY CSV CONTENT =====
        System.out.println("\n===== CSV DATA (Reference) =====");
        String[] possiblePaths = {
                "payroll.csv", 
                "src/com/mycompany/motorph/payroll.csv"
        };
        File csvFile = null;
        for (String path : possiblePaths) {
            File f = new File(path);
            if (f.exists()) {
                csvFile = f;
                break;
            }
        }

        if (csvFile != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
            }
        } else {
            System.out.println("CSV file not found. Please place payroll.csv in project root or src folder.");
            System.out.println("Current directory: " + System.getProperty("user.dir"));
        }
    }
}