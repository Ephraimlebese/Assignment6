package za.ac.cput.funeralapp.main.domain;

/**
 * Created by Thabo on 4/16/2016.
 */
public class PolicyThree extends Policy
{
    @Override
    public String policyType(String type)
    {
        if(type.equalsIgnoreCase("Three"))
        {
            return "Policy 3";
        }
        else
        {
            return nextPolicy.policyType(type);
        }
    }
}
