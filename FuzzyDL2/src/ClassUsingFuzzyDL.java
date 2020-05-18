import java.io.*;
import java.util.*;

import fuzzydl.*;
import fuzzydl.exception.*;
import fuzzydl.milp.*;
import fuzzydl.parser.*;



public class ClassUsingFuzzyDL {

    public static void main(String[] args) throws FuzzyOntologyException,
            InconsistentOntologyException,
            IOException, ParseException {


        Parser parser = new Parser(new FileInputStream("data_modelling.txt"));
        parser.Start();
        KnowledgeBase kb = parser.getKB();

        kb.defineConcept("ControlVariable", new Concept("(and Variable (some percent Control))"));
        kb.defineConcept("BetweenControlIndependent", new Concept("(between Control)"));
        kb.defineConcept("BetweenDependentControl", new Concept("(between Dependent)"));


        ArrayList <Query> queries = parser.getQueries();


        queries.add(new MinSubsumesQuery(new Concept("ControlVariable"), new Concept("IndependentVariable"), MinSubsumesQuery.ZADEH));
        queries.add(new MinSubsumesQuery(new Concept("ControlVariable"), new Concept("DependentVariable"), MinSubsumesQuery.ZADEH));
        queries.add(new MinSubsumesQuery(new Concept("ControlVariable"), new Concept("BetweenControlIndependent"), MinSubsumesQuery.ZADEH));
        queries.add(new MinSubsumesQuery(new Concept("Independent"), new Concept("BetweenControlDependent"), MinSubsumesQuery.GODEL));


        kb.solveKB();


        for (Query Query:  queries){
            Solution result = Query.solve(kb);
            System.out.println(result.toString());
        }

        kb.saveToFile("outputFile.txt");


    }
}
