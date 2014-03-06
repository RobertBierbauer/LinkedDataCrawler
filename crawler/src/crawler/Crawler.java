package crawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.parser.NxParser;
import org.semanticweb.yars.nx.parser.ParseException;
import org.semanticweb.yars2.rdfxml.RDFXMLParser;

public class Crawler {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new URL("http://www.w3.org/People/Berners-Lee/card.rdf")
					.openStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RDFXMLParser nxp = null;
		try {
			nxp = new RDFXMLParser(is,
					"http://www.w3.org/People/Berners-Lee/card.rdf");
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Node[]> nxx = new ArrayList<Node[]>();
		while (nxp.hasNext())
			nxx.add(nxp.next());

		for (int i = 0; i < nxx.size(); i++) {
			System.out.print(nxx.get(i)[0] + " ");
			System.out.print(nxx.get(i)[1] + " ");
			System.out.println(nxx.get(i)[2] + " ");
		}
	}
}
