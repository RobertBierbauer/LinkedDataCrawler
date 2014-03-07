package crawlerR;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars2.rdfxml.RDFXMLParser;


public class DownloaderThread implements Runnable{
	private String uri;
	private Scheduler tm;
	private Storage storage;
	private URIQueue queue;
	
	public DownloaderThread(String _uri, Storage _storage, URIQueue _queue, Scheduler _tm){
		uri = _uri;
		tm = _tm;
		storage = _storage;
		queue = _queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		RDFXMLParser nxp = null; 
		try{
			InputStream is = new URL(uri).openStream();
			nxp = new RDFXMLParser(is, uri);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		ArrayList<Node[]> nxx = new ArrayList<Node[]>();
		while (nxp.hasNext())
			nxx.add(nxp.next());

		LinkedList<String> seeAlsoList = new LinkedList<String>();
		for (int i = 0; i < nxx.size(); i++) {
			storage.addQuad(nxx.get(i)[0].toN3(), nxx.get(i)[1].toN3(), nxx.get(i)[2].toN3(), "<" + uri + ">", "");
			if(nxx.get(i)[1].toN3().indexOf("seeAlso") != -1){
				String seeAlsoURI = nxx.get(i)[2].toN3().substring(1, nxx.get(i)[2].toN3().indexOf(">"));
				seeAlsoList.add(seeAlsoURI);
			}
		}
		//storage.printAllQuads();
		if(!seeAlsoList.isEmpty()){
			queue.newURIs(seeAlsoList);
		}
	}
	
}
