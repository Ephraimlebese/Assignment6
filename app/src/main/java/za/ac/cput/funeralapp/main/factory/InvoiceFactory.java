package za.ac.cput.funeralapp.main.factory;

import za.ac.cput.funeralapp.main.domain.Invoice;

/**
 * Created by Thabo on 4/16/2016.
 */
public class InvoiceFactory
{
    public static Invoice getInvoice(int InvoiceNum, Double AmountPaid, Double Premiums)
    {
        return new Invoice.Builder()
                .InvoiceNum(InvoiceNum)
                .amountPaid(AmountPaid)
                .Premiums(Premiums)
                .build();
    }
}
