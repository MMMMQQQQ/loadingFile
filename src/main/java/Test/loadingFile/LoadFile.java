package Test.loadingFile;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.swrlapi.core.SWRLAPIRule;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.factory.SWRLAPIFactory;

/**
 * Hello world!
 *
 */
public class LoadFile
{
	public LoadFile() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("MCBCV6.owl");
//		System.out.println(is.toString());
		OWLOntologyManager ontologyManager=OWLManager.createOWLOntologyManager();		
		try {
			OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(is);
			//Create a SWRL rule engine using the SWRLAPI
			SWRLRuleEngine swrlRuleEngine=SWRLAPIFactory.createSWRLRuleEngine(ontology);
			
			Set<SWRLAPIRule> rule=swrlRuleEngine.getSWRLRules();
			
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
    public static void main( String[] args )
    {
    	LoadFile loadFile=new LoadFile();
    	System.out.println("Good!");
    }
}
