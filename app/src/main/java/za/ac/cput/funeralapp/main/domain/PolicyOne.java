package za.ac.cput.funeralapp.main.domain;

import java.io.Serializable;

/**
 * Created by Thabo on 4/16/2016.
 */
public class PolicyOne extends Policy implements Serializable{

    @Override
    public String policyType(String type)
    {
        if(type.equalsIgnoreCase("One"))
        {
            return "Policy 1";
        }
        else
        {
            return nextPolicy.policyType(type);
        }
    }
}
