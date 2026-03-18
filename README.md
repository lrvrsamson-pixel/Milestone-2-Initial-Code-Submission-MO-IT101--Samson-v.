EmployeeSalaryTool

CP1 - Phase 1 Source Code

Basic Payroll Program

This program collects employee information and weekly attendance input, calculates the total hours worked in a week, computes the gross weekly salary, and displays the net salary after applying basic government deductions (SSS, PhilHealth, Pag-IBIG).

How the Program Works

1. Imports
import java.util.Scanner;

-Scanner is used to get user input from the keyboard.

2. Main Class and Method
Main Class public class EmployeeSalaryTool { public static void main(String[] args) {

-EmployeeSalaryTool is the main class.
-main method is the entry point of the program.

3. Login System
System.out.print("Enter Username: ");
System.out.print("Enter Password: ");

-Program asks the user to enter username and password.
-If username or password is incorrect, program displays "Access Denied" and stops.
-Valid login: Username = 12345, Password = 12345

4. Get Employee Information
System.out.print("Enter Employee Number: ");
System.out.print("Enter Employee Name: ");
System.out.print("Enter Birthday: ");

-Program collects employee number, name, and birthday.

5. Get Weekly Work Hours
System.out.print("Monday: ");
System.out.print("Tuesday: ");
System.out.print("Wednesday: ");
System.out.print("Thursday: ");
System.out.print("Friday: ");

-User inputs hours worked for each day of the week.

6. Calculate Total Hours Worked
double totalHours = mon + tue + wed + thu + fri;

-Adds all daily hours to get total weekly hours.

7. Get Hourly Rate
System.out.print("Enter hourly rate: ");

-User inputs the hourly wage.

8. Calculate Gross Weekly Salary
double grossWeeklySalary = totalHours * hourlyRate;

-Gross salary is calculated based on total hours worked and hourly rate.

9. Compute Deductions

double sssPercent = 4.5;
double philhealthPercent = 1.5;
double pagibigPercent = 0.4;

double sssDeduction = grossWeeklySalary * (sssPercent / 100);
double philhealthDeduction = grossWeeklySalary * (philhealthPercent / 100);
double pagibigDeduction = grossWeeklySalary * (pagibigPercent / 100);

-Deductions are calculated based on percentage of gross salary.
-SSS = 4.5%
-PhilHealth = 1.5%
-Pag-IBIG = 0.4%

10. Calculate Total Deductions
double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction;

-Adds all deductions.

11. Calculate Net Weekly Salary
double netWeeklySalary = grossWeeklySalary - totalDeductions;

-Net salary is computed after deductions.

12. Display Employee Information
System.out.println("Employee Number: " + empNumber);
System.out.println("Employee Name: " + empName);
System.out.println("Birthday: " + birthday);

-Shows employee details.

13. Display Work Summary
System.out.println("Total Hours Worked: " + totalHours);

-Shows total weekly hours worked.

14. Display Salary Summary

System.out.println("Gross Weekly Salary: " + grossWeeklySalary);
System.out.println("SSS (4.5%): " + sssDeduction);
System.out.println("PhilHealth (1.5%): " + philhealthDeduction);
System.out.println("Pag-IBIG (0.4%): " + pagibigDeduction);
System.out.println("Total Deductions: " + totalDeductions);
System.out.println("Net Weekly Salary: " + netWeeklySalary);

-Shows gross salary, deductions, and final net salary.

Notes
-Program uses simple console input/output.
-Deductions are fixed percentages.
-No file handling is used in this version.
-This is a basic payroll system for Phase 1 requirements.
