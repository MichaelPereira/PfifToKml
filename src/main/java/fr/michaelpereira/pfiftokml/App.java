/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.michaelpereira.pfiftokml;

import fr.michaelpereira.pfiftokml.parsers.NoteParser;
import fr.michaelpereira.pfiftokml.parsers.PersonParser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Michael
 */
public class App
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    try {
      if (args.length != 2) {
        System.out.println("person.xml note.xml");
        //return;
      }
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      DefaultHandler personHandler = new PersonParser();
      DefaultHandler noteHandler = new NoteParser();
      saxParser.parse("C:\\Users\\Michael\\Documents\\person.xml", personHandler);
      saxParser.parse("C:\\Users\\Michael\\Documents\\notes.xml", noteHandler);
      //saxParser.parse(args[0], personHandler);
      //saxParser.parse(args[1], noteHandler);
    } catch (IOException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParserConfigurationException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SAXException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
