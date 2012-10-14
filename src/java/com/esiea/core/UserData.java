package org.peon.core;

import java.util.ArrayList;

public class UserData 
{  
    private ArrayList<Contact> tableContact = new ArrayList<Contact>();
    private ArrayList<Address> tableAddress = new ArrayList<Address>();   
    private ArrayList<AddressContact> tableAddressContact = new ArrayList<AddressContact>();

    public ArrayList<Contact> getTableContact() {
        return tableContact;
    }

    public void setTableContact(ArrayList<Contact> tableContact) {
        this.tableContact = tableContact;
    }

    public ArrayList<Address> getTableAddress() {
        return tableAddress;
    }

    public void setTableAddress(ArrayList<Address> tableAddress) {
        this.tableAddress = tableAddress;
    }

    public ArrayList<AddressContact> getTableAddressContact() {
        return tableAddressContact;
    }

    public void setTableAddressContact(ArrayList<AddressContact> tableAddressContact) {
        this.tableAddressContact = tableAddressContact;
    }
    
    public ArrayList<Address> getAddressAssociatedToContact(Contact input)
    {
        ArrayList<Address> arrayList = new ArrayList<Address>();
        for(int i=0; i<tableAddressContact.size();i++)
        {
            if(input.equals(tableAddressContact.get(i).getContact()))
            {
                Address address = tableAddressContact.get(i).getAddress();
                arrayList.add(address);
            }
        }
        return arrayList;
    }
    
    public void removeAddressAssociatedToContact(Address address,Contact contact)
    {
        for(int i=0; i<tableAddressContact.size();i++)
        {
            boolean bool = tableAddressContact.get(i).getAddress().equals(address) && tableAddressContact.get(i).getContact().equals(contact);
            if(bool)
            {
                tableAddressContact.remove(i);
            }
        }
        for(int i=0; i<tableAddress.size();i++)
        {
            Address get = tableAddress.get(i);
            if(get.equals(address))
            {
                tableAddress.remove(i);
            }
        }
        
    }
    
    public void removeContact(Contact contact)
    {
        ArrayList<Address> arrayList = new ArrayList<Address>();
        for(int i=0; i<tableAddressContact.size();i++)
        {
            boolean bool = tableAddressContact.get(i).getContact().equals(contact);
            if(bool)
            {
                arrayList.add(tableAddressContact.get(i).getAddress());
            }
        }
        for(int i=0; i<arrayList.size();i++)
        {
            removeAddressAssociatedToContact(arrayList.get(i), contact);
        }
        for(int i=0; i<tableContact.size();i++)
        {
            Contact get = tableContact.get(i);
            if(get.equals(contact))
            {
                tableContact.remove(i);
            }
        }
    }
    
    public void InsertContact(Contact contact) throws Exception
    {
        boolean bool=false;
        for(int i=0; i<tableAddressContact.size() &&!bool ;i++)
        {
            bool = tableAddressContact.get(i).getContact().equals(contact) || bool;
        }
        if(!bool)
        {
            tableContact.add(contact);
        }
        else
        {
            throw new Exception("Contact already presents in Database");
        }
    }
    
    public void InsertAddressAssociatedToContact(Contact contact,Address address) throws Exception
    {
        boolean bool=false;
        boolean AddressAlReadyInDataBase = false;
        boolean ContactAlReadyInDataBase = false;
        for(int i=0; i<tableAddressContact.size() &&!bool ;i++)
        {
            AddressAlReadyInDataBase = AddressAlReadyInDataBase || tableAddressContact.get(i).getAddress().equals(address);
            ContactAlReadyInDataBase = ContactAlReadyInDataBase || tableAddressContact.get(i).getContact().equals(contact);
            boolean temp = tableAddressContact.get(i).getContact().equals(contact);
            temp = temp && tableAddressContact.get(i).getAddress().equals(address);
            bool =  temp || bool;
        }
        if(!bool)
        {
            if (!AddressAlReadyInDataBase)
            {
                tableAddress.add(address);
            }
            if (!ContactAlReadyInDataBase)
            {
                tableContact.add(contact);
            }
            tableAddressContact.add(new AddressContact(contact, address));
        }
        else
        {
            throw new Exception("Contact already presents in Database");
        }
    }
     
}