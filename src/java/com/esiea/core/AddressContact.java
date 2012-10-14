package com.esiea.core;

public class AddressContact 
{
    private Address Address;
    private Contact Contact;
    
    public AddressContact(Contact Con, Address Add)
    {
        this.Address=Add;
        this.Contact=Con;
    }

    public Address getAddress() 
    {
        return Address;
    }

    public void setAddress(Address address) 
    {
        this.Address = address;
    }

    public Contact getContact() 
    {
        return Contact;
    }

    public void setContact(Contact contact) 
    {
        this.Contact = contact;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (obj == null) 
        {
            return false;
        }
        else if (getClass() != obj.getClass()) 
        {
            return false;
        }
        else 
        {
            AddressContact objectToCompare = (AddressContact) obj;
            boolean returnValue = objectToCompare.getAddress().equals(this.getAddress());
            returnValue = returnValue && objectToCompare.getContact().equals(this.getContact());
            return returnValue;
        }
    }
}
