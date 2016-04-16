package za.ac.cput.funeralapp.main.domain;

/**
 * Created by Thabo on 4/16/2016.
 */
public class PolicyTwo extends Policy
{
    @Override
    public String policyType(String type)
    {
        if(type.equalsIgnoreCase("Two"))
        {
            return "Policy 2";
        }
        else
        {
            return nextPolicy.policyType(type);
        }
    }
}
