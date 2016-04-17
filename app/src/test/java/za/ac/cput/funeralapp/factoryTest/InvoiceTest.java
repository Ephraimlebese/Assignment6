package za.ac.cput.funeralapp.factoryTest;

import org.junit.Assert;
import org.junit.Test;

import za.ac.cput.funeralapp.main.domain.Invoice;
import za.ac.cput.funeralapp.main.factory.InvoiceFactory;

/**
 * Created by Thabo on 4/17/2016.
 */
public class InvoiceTest
{
    @Test
    public void testCreate() throws Exception
    {
        Invoice invoice = InvoiceFactory.getInvoice(12,100.0,150.0);
        Assert.assertTrue(invoice.getPremiums()==150.0);
    }

    @Test
    public void testUpdate() throws Exception
    {
        Invoice invoice = InvoiceFactory.getInvoice(12,100.0,150.0);
        Invoice updatedInvoice = new Invoice.Builder().copy(invoice).amountPaid(150.0).build();

        Assert.assertTrue(updatedInvoice.getAmountPaid() == 150.0);
    }
}
