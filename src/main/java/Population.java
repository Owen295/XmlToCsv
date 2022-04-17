import com.opencsv.CSVWriter;
import model.Activity;
import model.Leg;
import model.Person;
import model.Plan;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Population {

    private List<Person> persons;


    public Population(List<Person> persons) {
        this.persons = persons;
    }

    public Population() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static void main(String[] args) {

        String filepath = "E:\\Masters_Transport\\Prof_Work_Files\\Obi JOSM Network\\CapeTown\\plansWithoutCars.xml";
        Population population = new Population();
        try {

            File file = new File(filepath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("person");
            List<Person> personList = new ArrayList<>();
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Person person = new Person();
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Plan plan = new Plan();
                    List<Activity> activityList = new ArrayList<>();
                    List<Leg> legList = new ArrayList<>();
                    Element eElement = (Element) node;
                    person.setId(eElement.getAttribute("id"));
                    Element element1 = (Element)eElement.getElementsByTagName("plan").item(0);
                    plan.setSelected(element1.getAttribute("selected"));
                    NodeList activityNodeList = element1.getElementsByTagName("activity");
                    NodeList legNodeList = element1.getElementsByTagName("leg");

                    for(int j=0 ; j<activityNodeList.getLength(); j++){
                        Activity activity = new Activity();
                        Node act = activityNodeList.item(j);
                        Element element = (Element) act;
                        activity.setType(element.getAttribute("type"));
                        activity.setX(element.getAttribute("x"));
                        activity.setY(element.getAttribute("y"));
                        activity.setEnd_time(element.getAttribute("end_time"));
                        activityList.add(activity);
                    }

                    for(int k=0 ; k<legNodeList.getLength(); k++){
                        Leg leg = new Leg();
                        Node l = legNodeList.item(k);
                        Element element = (Element) l;
                        leg.setMode(element.getAttribute("mode"));
                        legList.add(leg);
                    }
                    plan.setActivityList(activityList);
                    plan.setLegList(legList);
                    person.setPlan(plan);
                }
                personList.add(person);

            }
            population.setPersons(personList);
            List<String[]> data = new ArrayList<String[]>();
            for(Person person: personList){
                String[] output = (person.toString().replaceAll("[\\[\\]]","")).split(",");
                data.add(output);
            }
            File file1 = new File("data/output.csv");
            try {
                // create FileWriter object with file as parameter
                FileWriter outputfile = new FileWriter(file1);
                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputfile);
                writer.writeAll(data);
                // closing writer connection
                writer.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
