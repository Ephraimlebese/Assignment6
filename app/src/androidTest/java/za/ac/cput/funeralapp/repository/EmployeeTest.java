package za.ac.cput.funeralapp.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.funeralapp.main.domain.Employees;
import za.ac.cput.funeralapp.main.repository.EmployeeRepository;
import za.ac.cput.funeralapp.main.repository.impl.EmployeeRepositoryImpl;

/**
 * Created by Thabo on 4/24/2016.
 */
public class EmployeeTest extends AndroidTestCase
{
    private static final String TAG="Employee TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception
    {
        EmployeeRepository repo = new EmployeeRepositoryImpl(this.getContext());
        //Create
        Employees createEntity = new Employees.Builder()
                .idNumber("8806275689086")
                .firstName("Sarah")
                .lastName("Jackson")
                .build();
        Employees insertedEntity = repo.save(createEntity);
        id = insertedEntity.getID();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Employees> employees = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",employees.size()>0);

        //READ ENTITY
        Employees entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Employees updatedEmployees = new Employees.Builder()
                .copy(entity)
                .lastName("Mahlala")
                .build();
        repo.update(updatedEmployees);
        Employees newEmployee = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Mahlala",newEmployee.getLastName());

        // DELETE ENTITY
        repo.delete(updatedEmployees);
        Employees deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}
