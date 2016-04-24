package za.ac.cput.funeralapp.main.repository;

import java.util.Set;

/**
 * Created by Thabo on 4/24/2016.
 */
public interface Repository<E, ID>
{

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
