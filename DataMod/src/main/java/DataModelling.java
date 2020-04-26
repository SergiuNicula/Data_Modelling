
import com.racersystems.jracer.*;
import entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DataModelling {

    public static void main(String[] argv) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Concept[]> response1 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/concept/",
                        Concept[].class);
        Concept[] concepts = response1.getBody();

        ResponseEntity<DataSet[]> response2 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/dataSet/",
                        DataSet[].class);
        DataSet[] dataSets = response2.getBody();

        ResponseEntity<DataSetStructure[]> response3 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/dataSetStructure/",
                        DataSetStructure[].class);
        DataSetStructure[] dataSetStructures = response3.getBody();

        ResponseEntity<DataSource[]> response4 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/dataSource/",
                        DataSource[].class);
        DataSource[] dataSources = response4.getBody();

        ResponseEntity<LinkedVariables[]> response5 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/linkedVariable/",
                        LinkedVariables[].class);
        LinkedVariables[] linkedVariables = response5.getBody();

        ResponseEntity<LinkType[]> response6 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/linkType/",
                        LinkType[].class);
        LinkType[] linkTypes = response6.getBody();

        ResponseEntity<Measure[]> response7 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/measure/",
                        Measure[].class);
        Measure[] measures = response7.getBody();

        ResponseEntity<ModelType[]> response8 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/modelType/",
                        ModelType[].class);
        ModelType[] modelTypes = response8.getBody();

        ResponseEntity<Model[]> response9 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/model/",
                        Model[].class);
        Model[] models = response9.getBody();

        ResponseEntity<Variable[]> response10 =
                restTemplate.getForEntity(
                        "http://localhost:8090/api/variable/",
                        Variable[].class);
        Variable[] variables = response10.getBody();

        String ip = "127.0.0.1";
        int port = 8088;

        String filename="\"D:/groza/data_modeling.owl\"";

        RacerClient racer = new RacerClient(ip,port);
        try {
            racer.openConnection();

            System.out.println(racer.sendRaw("(owl-read-file " + filename + ")"));

            for(Concept concept : concepts)
            {
                racer.sendRaw("(instance " + concept.getName() +" concept)");
            }

            for(DataSet dataSet : dataSets)
            {
                racer.sendRaw("(instance " + dataSet.getName() +" dataSet)");
            }

            for(DataSetStructure dataSetStructure : dataSetStructures)
            {
                racer.sendRaw("(instance " + dataSetStructure.getName() +" dataSetStructure)");
            }

            for(DataSource dataSource : dataSources)
            {
                racer.sendRaw("(instance " + dataSource.getName() +" dataSource)");
            }

            for(LinkedVariables linkedVariable : linkedVariables)
            {
                racer.sendRaw("(instance " + linkedVariable.getName() +" linkedVariable)");
            }

            for(LinkType linkType : linkTypes)
            {
                racer.sendRaw("(instance " + linkType.getName() +" linkType)");
            }

            for(Measure measure : measures)
            {
                racer.sendRaw("(instance " + measure.getName() +" measure)");
            }

            for(Model model : models)
            {
                racer.sendRaw("(instance " + model.getName() +" model)");
            }

            for(ModelType modelType : modelTypes)
            {
                racer.sendRaw("(instance " + modelType.getName() +" modelType)");
            }

            for(Variable variable : variables)
            {
                racer.sendRaw("(instance " + variable.getName() +" variable)");
            }

            System.out.println(racer.sendRaw("(all-individuals)"));

            racer.sendRaw("(save-kb \"dataMod.racer\" :syntax :racer)");
            racer.sendRaw("(save-kb \"dataMod.owl\" :syntax :owl)");
            racer.closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}