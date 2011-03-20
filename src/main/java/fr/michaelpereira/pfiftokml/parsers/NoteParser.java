/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.michaelpereira.pfiftokml.parsers;

import fr.michaelpereira.pfiftokml.HibernateUtil;
import fr.michaelpereira.pfiftokml.Note;
import fr.michaelpereira.pfiftokml.Person;
import java.text.DateFormat;
import java.text.ParseException;
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
public class NoteParser extends DefaultHandler
{

  private Session session;
  private String tmpString;
  private Note note;
  private int i = 0;
  private Person personByPersonRecordId = null;
  private Person personByLinkedPersonRecordId = null;
  private DateFormat df;

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException
  {
    tmpString = new String(ch, start, length);
  }

  @Override
  public void endDocument() throws SAXException
  {
    session.close();
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException
  {
    if (qName.equals("pfif:note")) {
      System.out.println("saving note " + ++i);
      if (personByPersonRecordId != null) {
        session.update(personByPersonRecordId);
      }
      if (personByLinkedPersonRecordId != null) {
        session.update(personByLinkedPersonRecordId);
      }
      Note exist = (Note) session.load(Note.class, note.getNoteRecordId());
      if (exist == null) {
        session.save(note);
        session.flush();
        session.getTransaction().commit();
      }
      note = null;
      personByPersonRecordId = null;
      personByLinkedPersonRecordId = null;
    } else if (qName.equals("pfif:note_record_id")) {
      note.setNoteRecordId(tmpString);
    } else if (qName.equals("pfif:person_record_id")) {
      personByPersonRecordId = (Person) session.load(Person.class, tmpString);
      note.setPersonByPersonRecordId(personByPersonRecordId);
      personByPersonRecordId.getNotesForPersonRecordId().add(note);
    } else if (qName.equals("pfif:linked_person_record_id")) {
      personByLinkedPersonRecordId = (Person) session.load(Person.class, tmpString);
      note.setPersonByPersonRecordId(personByLinkedPersonRecordId);
      personByLinkedPersonRecordId.getNotesForPersonRecordId().add(note);
    } else if (qName.equals("pfif:entry_date")) {
      try {
        note.setEntryDate(df.parse(tmpString));
      } catch (ParseException ex) {
        Logger.getLogger(NoteParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else if (qName.equals("pfif:author_name")) {
      note.setAuthorName(tmpString);
    } else if (qName.equals("pfif:author_email")) {
      note.setAuthorEmail(tmpString);
    } else if (qName.equals("pfif:author_phone")) {
      note.setAuthorPhone(tmpString);
    } else if (qName.equals("pfif:source_date")) {
      try {
        note.setSourceDate(df.parse(tmpString));
      } catch (ParseException ex) {
        Logger.getLogger(NoteParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else if (qName.equals("pfif:found")) {
      note.setFound(Boolean.parseBoolean(tmpString));
    } else if (qName.equals("pfif:email_of_found_person")) {
      note.setEmailOfFoundPerson(tmpString);
    } else if (qName.equals("pfif:phone_of_found_person")) {
      note.setPhoneOfFoundPerson(tmpString);
    } else if (qName.equals("pfif:last_known_location")) {
      note.setLastKnownLocation(tmpString);
    } else if (qName.equals("pfif:text")) {
      note.setText(tmpString);
    } else if (qName.equals("pfif:status")) {
      note.setStatus(tmpString);
    }

  }

  @Override
  public void startDocument() throws SAXException
  {
    session = HibernateUtil.getSessionFactory().openSession();
    df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  }

  @Override
  public void startElement(String uri, String localName,
          String qName, Attributes attributes)
          throws SAXException
  {
    if (qName.equals("pfif:note")) {
      note = new Note();
      session.beginTransaction();
    }
  }
}
