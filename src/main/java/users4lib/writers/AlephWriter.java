package users4lib.writers;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import users4lib.model.AlephUser;

/**
 * Created by alejandrorodriguez on 7/8/16.
 */
public class AlephWriter
{

   private void exportAlephUsers(List<AlephUser> users, String filePath) throws Exception
   {
       // TODO Auto-generated method stub
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();

       // root elements
       Document doc = builder.newDocument();
       Element rootElement = doc.createElement("p-file-20");
       for (AlephUser u:users) {
           u.saveXML(doc,rootElement);
       }

       doc.appendChild(rootElement);

       // write the content into xml file
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource source = new DOMSource(doc);
       StreamResult result = new StreamResult(new File(filePath));

       transformer.transform(source, result);

       System.out.println("File saved!");



   }



}
