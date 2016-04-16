package za.ac.cput.funeralapp.main.factory;

import za.ac.cput.funeralapp.main.domain.Employees;

/**
 * Created by Thabo on 4/16/2016.
 */
public class EmployeesFactory
{
    public static Employees getEmployees(String idNum, String fName, String lName)
    {
        return new Employees.Builder()
                .idNumber(idNum)
                .firstName(fName)
                .lastName(lName)
                .build();
    }
}
