package crawlerR;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.parser.NxParser;
import org.semanticweb.yars.nx.parser.ParseException;
import org.semanticweb.yars2.rdfxml.RDFXMLParser;


public class Scheduler {
	ExecutorService executor;
	private String startURI;
	private Storage storage;
	private URIQueue queue;
	public Scheduler(String _startURI, Storage _storage, URIQueue _queue){
		executor = Executors.newCachedThreadPool();
		startURI = _startURI;
		storage = _storage;
		queue = _queue;
		executor.execute(new DownloaderThread(startURI, storage, queue, this));
	}
	
	public void setNewURIs(LinkedList<String> URIList){
		
	}
}
