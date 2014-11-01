package com.springapp.mvc;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;

/**
 * Created by adrianh on 26.10.14.
 */
public class SearchProcessing {
    protected static Person getPerson(SearchResult searchResult) {
        Person person = null;
        try {
            Attributes attributes = searchResult.getAttributes();

            Attribute firstName = attributes.get("givenName");
            Attribute lastName = attributes.get("sn");
            Attribute id = attributes.get("uidNumber");
            Attribute mobile = attributes.get("telephoneNumber");
            Attribute email = attributes.get("mail");
            Attribute groups = attributes.get("memberOf");
            Attribute username = attributes.get("uid");
            Attribute fullName = attributes.get("cn");

            person = new Person();

            if (firstName != null) {
                //System.out.println("First Name: " + firstName.get());
                person.setFirstName("" + firstName.get());
            }
            if (lastName != null) {
                //System.out.println("Last Name: " + lastName.get());
                person.setLastName("" + lastName.get());
            }
            if (fullName != null) {
                //System.out.println("Full Name: " + fullName.get());
                person.setFullName("" + fullName.get());
            }
            if (username != null) {
                //System.out.println("Username: " + username.get());
                person.setUid("" + username.get());
            }
            if (email != null) {
                //System.out.println("Email: " + email.get());
                person.setEmail("" + email.get());
            }
            if (mobile != null) {
                //System.out.println("Mobile: " + mobile.get());
                person.setMobile(Integer.valueOf("" + mobile.get()));
            }
            if (groups != null) {
                //System.out.println("Groups:");
                for (int j = 0; j < groups.size(); j++) {
                    //System.out.println("\t" + groups.get(i));
                    person.groups.add("" + groups.get(j));
                }
            }
            if (id != null) {
                //System.out.println("ID: " + id.get());
                person.setId(Integer.valueOf("" + id.get()));
            }
        }
        catch (NamingException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return person;
    }

    protected static PersonList getPersons(NamingEnumeration answer) {
        PersonList returnList = new PersonList();
        try {
            //Find the next person with while(answer.hasMore())
            while(answer.hasMore()) {
                Person returnperson = new Person();
                //Get the next result
                SearchResult searchResult = (SearchResult) answer.next();

                //Getting the attributes of the result
                Attributes attributes = searchResult.getAttributes();

                //Storing each attribute
                Attribute firstName = attributes.get("givenName");
                Attribute lastName = attributes.get("sn");
                Attribute id = attributes.get("gidNumber");
                Attribute mobile = attributes.get("telephoneNumber");
                Attribute email = attributes.get("mail");
                Attribute groups = attributes.get("memberOf");
                Attribute fullName = attributes.get("cn");
                Attribute uid = attributes.get("uid");
                String dn = searchResult.getNameInNamespace();


                if (firstName != null) {
                    //System.out.println("First Name: " + firstName.get());
                    returnperson.setFirstName("" + firstName.get());
                }
                if (lastName != null) {
                    //System.out.println("Last Name: " + lastName.get());
                    returnperson.setLastName("" + lastName.get());
                }
                if (fullName != null) {
                    //System.out.println("Full Name: " + fullName.get());
                    returnperson.setFullName("" + fullName.get());
                }
                if (uid != null) {
                    //System.out.println("Username: " + username.get());
                    returnperson.setUid("" + uid.get());
                }
                if (email != null) {
                    //System.out.println("Email: " + email.get());
                    returnperson.setEmail("" + email.get());
                }
                if (mobile != null) {
                    //System.out.println("Mobile: " + mobile.get());
                    returnperson.setMobile(Integer.valueOf("" + mobile.get()));
                }
                if (groups != null) {
                    //System.out.println("Groups:");
                    for (int j = 0; j < groups.size(); j++) {
                        //System.out.println("\t" + groups.get(i));
                        returnperson.groups.add("" + groups.get(j));
                    }
                }
                if (id != null) {
                    //System.out.println("ID: " + id.get());
                    returnperson.setId(Integer.valueOf("" + id.get()));
                }
                if (dn != null) {
                    returnperson.setDn(dn);
                }
                returnperson.setRightsLevel(LDAP.checkRightsLevelSimple((String) uid.get()));
                returnList.add(returnperson);
                //System.out.println(returnperson);
            }
        } catch(NamingException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return returnList;
    }
}