package za.ac.cput.funeralapp.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import za.ac.cput.funeralapp.main.domain.Clients;
import za.ac.cput.funeralapp.main.repository.ClientsRepository;
import za.ac.cput.funeralapp.main.repository.impl.ClientsRepositoryImpl;

/**
 * Created by Thabo on 4/24/2016.
 */
public class ClientRepositoryTest  extends AndroidTestCase
{
    private static final String TAG="CLIENT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception
    {
        ClientsRepository repo = new ClientsRepositoryImpl(this.getContext());
        //Create
        Clients createEntity = new Clients.Builder()
                .idNumber("8806275689086")
                .firstName("Lucky")
                .lastName("Malome")
                .build();
        Clients insertedEntity = repo.save(createEntity);
        id = insertedEntity.getID();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Clients> clients = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",clients.size()>0);

        //READ ENTITY
        Clients entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Clients updatedClients = new Clients.Builder()
                .copy(entity)
                .lastName("Mahlala")
                .build();
        repo.update(updatedClients);
        Clients newEmployee = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Mahlala",newEmployee.getLastName());

        // DELETE ENTITY
        repo.delete(updatedClients);
        Clients deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }


}
