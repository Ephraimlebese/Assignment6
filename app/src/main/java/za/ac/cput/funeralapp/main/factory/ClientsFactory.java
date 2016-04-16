package za.ac.cput.funeralapp.main.factory;

import za.ac.cput.funeralapp.main.domain.Clients;

/**
 * Created by Thabo on 4/16/2016.
 */
public class ClientsFactory
{
    public static Clients getClient(String idNum,String fName,String lName)
    {
        return new Clients.Builder()
                .idNumber(idNum)
                .firstName(fName)
                .lastName(lName)
                .build();
    }
}
