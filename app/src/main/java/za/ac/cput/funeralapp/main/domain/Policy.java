package za.ac.cput.funeralapp.main.domain;

/**
 * Created by Thabo on 4/16/2016.
 */
public abstract class Policy
{
    private int PolicyNum;
    private int InvoiceNum;
    public Policy nextPolicy;

    public void setNextPolicy(Policy nextPolicy)
    {
        this.nextPolicy = nextPolicy;
    }

    public int getPolicyNum()
    {
        return PolicyNum;
    }

    public int getInvoiceNum()
    {
        return InvoiceNum;
    }

    public abstract String policyType(String type);
}
