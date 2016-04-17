package za.ac.cput.funeralapp;

/**
 * Created by Thabo on 4/17/2016.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import za.ac.cput.funeralapp.factoryTest.ClientTest;
import za.ac.cput.funeralapp.factoryTest.EmployeesTest;
import za.ac.cput.funeralapp.factoryTest.InvoiceTest;
import za.ac.cput.funeralapp.factoryTest.PolicyTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientTest.class,
        EmployeesTest.class,
        InvoiceTest.class,
        PolicyTest.class
})
public class AppUnitTestSuite {}
