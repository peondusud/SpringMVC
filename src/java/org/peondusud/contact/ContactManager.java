/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peondusud.contact;

import org.peondusud.contact.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author X
 */
public class ContactManager {

    public ArrayList<Contact> arrContact;

    public ContactManager(ArrayList<Contact> arrContact) {
        this.arrContact = arrContact;
    }
        public ContactManager() {
        this.arrContact = null;
    }

    public ArrayList<Contact> getArrContact() {
        return arrContact;
    }

    public void setArrContact(ArrayList<Contact> arrContact) {
        this.arrContact = arrContact;
    }

    public Contact getById(String uuid) {
       List<Contact> tmp = null;
        Iterator itr = arrContact.iterator();
                while (itr.hasNext()) {
            Contact element = (Contact) itr.next();
            if (element.getUuid().equals(uuid)) {
                return element;
            }
        }
        
     
        return null;

    }

    public List<Contact> getByNom(String first) {

        List<Contact> tmp = null;
        Iterator itr = arrContact.iterator();

        while (itr.hasNext()) {
            Contact element = (Contact) itr.next();
            if (element.getNom().equals(first)) {
                tmp.add(element);
            }
        }
        return tmp;
    }

    public List<Contact> getByPrenom(String last) {
        List<Contact> tmp = null;
        Iterator itr = arrContact.iterator();

        while (itr.hasNext()) {
            Contact element = (Contact) itr.next();
            if (element.getPrenom().equals(last)) {
                tmp.add(element);
            }
        }
        return tmp;
    }

    public Contact getByEmail(String email) {
        Iterator itr = arrContact.iterator();

        while (itr.hasNext()) {
            Contact element = (Contact) itr.next();
            Iterator itr2 = element.getEmails().iterator();
            while (itr2.hasNext()) {
                Object element2 = itr2.next();
                if (element2.equals(email)) {
                    return element;
                }
            }
        }
        return null;
    }

    public Contact getByPhoneNumber(String phone) {
        Iterator itr = arrContact.iterator();

        while (itr.hasNext()) {
            Contact element = (Contact) itr.next();
            Iterator itr2 = element.getPhones().iterator();
            while (itr2.hasNext()) {
                Object element2 = itr2.next();
                if (element2.equals(phone)) {
                    return element;
                }
            }
        }
        return null;
    }
    
    public void Init(){
          
        
    }
    
     public static ArrayList<Contact> PopulateContact(){
         
        ArrayList<Contact> arr = new ArrayList<Contact>();
        Contact cont =new Contact("toto", "oups", "toto@ty.fr", "056170", "08/12/75");
        cont.addAddress("22", "rue de vesale", "Paris", "75", "France");
        cont.addAddress("22", "rue de fou", "Toulouse", "31", "France");
        cont.addAddress("22", "rue de fou", "Marseille", "13", "Magreb");
        cont.addEmailNoCheck("nn@ty.fr");
        cont.addPhoneNoCheck("54989899");
        arr.add(cont);
        Contact cont2 =new Contact("camille", "Viot","nn@ty.fr", "056170", "88/12/90");
        cont2.addAddress("22", "rue de vesale", "Paris", "75", "France");
        cont2.addAddress("22", "rue de fou", "Toulouse", "31", "France");
        cont2.addAddress("22", "rue de fou", "Marseille", "13", "Magreb");
        cont.addEmailNoCheck("toto@ty.fr");
        cont.addPhoneNoCheck("65948");
        arr.add(cont2);
     
        return arr;
    }
    
  /*  public static void main(String[] args) {
    
        ContactManager cont =new ContactManager( PopulateContact() );
        
        //Window wind = new Window(cont);
    }*/
    
}
