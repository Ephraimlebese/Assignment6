package za.ac.cput.funeralapp.factoryTest;

import org.junit.Test;

import za.ac.cput.funeralapp.main.domain.Clients;
import za.ac.cput.funeralapp.main.factory.ClientsFactory;

/**
 * Created by Thabo on 4/16/2016.
 */
public class ClientTest
{

    @Test
    public void testCreate() throws Exception
    {
        Clients clients = ClientsFactory.getClient("8805165415086","Ricky","Ross");

    }
}
