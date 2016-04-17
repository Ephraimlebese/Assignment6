package za.ac.cput.funeralapp.factoryTest;

import org.junit.Assert;
import org.junit.Test;

import za.ac.cput.funeralapp.main.domain.Employees;
import za.ac.cput.funeralapp.main.factory.EmployeesFactory;

/**
 * Created by Thabo on 4/17/2016.
 */
public class EmployeesTest
{
    @Test
    public void testCreate() throws Exception
    {
        Employees employees = EmployeesFactory.getEmployees("9905255415086","Mpho","Dube");
        Assert.assertEquals(employees.getFirstName(),"Mpho");

    }

    @Test
    public void testUpdate() throws Exception
    {
        Employees employees = EmployeesFactory.getEmployees("9905255415086","Mpho","Dube");
        Employees updatedEmployees = new Employees.Builder().copy(employees).lastName("Mahlala").build();

    }
}
