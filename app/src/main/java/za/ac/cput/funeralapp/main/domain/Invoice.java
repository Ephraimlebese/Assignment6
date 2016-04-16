package za.ac.cput.funeralapp.main.domain;

import java.io.Serializable;

/**
 * Created by Thabo on 4/16/2016.
 */
public class Invoice implements Serializable
{

    private Long id;
    private int InvoiceNum;
    private Double amountPaid;
    private Double Premiums;

    public Invoice(Builder builder){
        id = builder.id;
        InvoiceNum = builder.InvoiceNum;
        amountPaid = builder.amountPaid;
        Premiums = builder.Premiums;
    }


    public Long getID() {
        return id;
    }


    public int getInvoiceNum() {
        return InvoiceNum;
    }


    public Double getAmountPaid() {
        return amountPaid;
    }


    public Double getPremiums() {
        return Premiums;
    }

    public static class Builder
    {
        private Long id;
        private int InvoiceNum;
        private Double amountPaid;
        private Double Premiums;

        public Builder InvoiceNum(int InvoiceNum){
            this.InvoiceNum = InvoiceNum;
            return this;
        }

        public Builder amountPaid(Double amountPaid){
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder Premiums(Double Premiums){
            this.Premiums = Premiums;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copy(Invoice value){
            this.id = value.getID();
            this.InvoiceNum = value.getInvoiceNum();
            this.amountPaid = value.getAmountPaid();
            this.Premiums = value.getPremiums();
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }
}
