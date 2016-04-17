package za.ac.cput.funeralapp.factoryTest;

import org.junit.Assert;
import org.junit.Test;

import za.ac.cput.funeralapp.main.domain.Policy;
import za.ac.cput.funeralapp.main.domain.PolicyOne;

/**
 * Created by Thabo on 4/17/2016.
 */
public class PolicyTest
{
    @Test
    public void testPolicy() throws Exception
    {
        Policy policyOne = new PolicyOne();
        Assert.assertSame(policyOne.policyType("one"),"Policy 1");
    }
}
