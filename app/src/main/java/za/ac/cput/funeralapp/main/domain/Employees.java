package za.ac.cput.funeralapp.main.domain;

import java.io.Serializable;

/**
 * Created by Thabo on 4/16/2016.
 */
public class Employees implements Serializable,Person
{
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;

    public Employees(Builder builder){
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        idNumber = builder.idNumber;
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getIDNumber() {
        return idNumber;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String idNumber;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder idNumber(String idNumber){
            this.idNumber = idNumber;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copy(Employees value){
            this.id = value.getID();
            this.firstName = value.getFirstName();
            this.lastName = value.getLastName();
            this.idNumber = value.getIDNumber();
            return this;
        }
        public Employees build(){
            return new Employees(this);
        }
    }


}
