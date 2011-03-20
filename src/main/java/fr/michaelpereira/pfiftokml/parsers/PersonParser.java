/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.michaelpereira.pfiftokml.parsers;

import fr.michaelpereira.pfiftokml.HibernateUtil;
import fr.michaelpereira.pfiftokml.Person;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.classic.Session;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Michael
 */
public class PersonParser extends DefaultHandler
{

  int i = 0;
  String tmpstring;
  boolean personExist;
  private Person person;
  private Session session;
  private DateFormat df;

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException
  {
    tmpstring = new String(ch, start, length);
  }

  @Override
  public void endDocument() throws SAXException
  {
    System.out.println("finished person.xml");
    session.close();
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException
  {
    if (personExist) {
      return;
    }
    if (qName.equals("pfif:person")) {
      System.out.println("saving person " + ++i);

      session.save(person);
      session.flush();
      session.getTransaction().commit();

      person = null;
    } else if (qName.equals("pfif:person_record_id")) {
      Person exist = (Person) session.get(Person.class, person.getPersonRecordId());
      if (exist == null) {
        person.setPersonRecordId(tmpstring);
      } else {
        person = null;
        personExist = true;
      }
    } else if (qName.equals("pfif:entry_date")) {
      try {
        person.setEntryDate(df.parse(tmpstring));
      } catch (ParseException ex) {
        Logger.getLogger(PersonParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else if (qName.equals("pfif:author_name")) {
      person.setAuthorName(tmpstring);
    } else if (qName.equals("pfif:author_email")) {
      person.setAuthorEmail(tmpstring);
    } else if (qName.equals("pfif:author_phone")) {
      person.setAuthorPhone(tmpstring);
    } else if (qName.equals("pfif:source_name")) {
      person.setSourceName(tmpstring);
    } else if (qName.equals("pfif:source_date")) {
      try {
        person.setSourceDate(df.parse(tmpstring));
      } catch (ParseException ex) {
        Logger.getLogger(PersonParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else if (qName.equals("pfif:source_url")) {
      person.setSourceUrl(tmpstring);
    } else if (qName.equals("pfif:first_name")) {
      person.setFirstName(tmpstring);
    } else if (qName.equals("pfif:first_name")) {
      person.setFirstName(tmpstring);
    } else if (qName.equals("pfif:last_name")) {
      person.setLastName(tmpstring);
    } else if (qName.equals("pfif:home_city")) {
      person.setHomeCity(tmpstring);
    } else if (qName.equals("pfif:home_state")) {
      person.setHomeState(tmpstring);
    } else if (qName.equals("pfif:home_neighborhood")) {
      person.setHomeNeighborhood(tmpstring);
    } else if (qName.equals("pfif:home_street")) {
      person.setHomeStreet(tmpstring);
    } else if (qName.equals("pfif:home_zip")) {
      person.setHomeZip(tmpstring);
    } else if (qName.equals("pfif:photo_url")) {
      person.setPhotoUrl(tmpstring);
    } else if (qName.equals("pfif:other")) {
      person.setOther(tmpstring);
    } else if (qName.equals("pfif:sex")) {
      person.setSex(tmpstring);
    } else if (qName.equals("pfif:date_of_birth")) {
      try {
        person.setDateOfBirth(df.parse(tmpstring));
      } catch (ParseException ex) {
        Logger.getLogger(PersonParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else if (qName.equals("pfif:age")) {
      person.setAge(Short.parseShort(tmpstring));
    } else if (qName.equals("pfif:home_country")) {
      person.setHomeCountry(tmpstring);
    }
    tmpstring = null;
  }

  @Override
  public void startDocument() throws SAXException
  {
    session = HibernateUtil.getSessionFactory().openSession();
    df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
  {
    if (qName.equals("pfif:person")) {
      personExist = false;
      person = new Person();
      session.beginTransaction();
    }
  }
}
