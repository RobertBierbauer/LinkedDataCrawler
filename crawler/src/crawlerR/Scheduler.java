package crawlerR;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Scheduler {
	ExecutorService executor;
	private String startURI;
	private Storage storage;
	private URIQueue queue;
	LinkedList<String> URIList;
	int countThreadsRunning = 0;
	int countDepth = 0;
	
	public Scheduler(String _startURI, Storage _storage, URIQueue _queue){
		executor = Executors.newCachedThreadPool();
		startURI = _startURI;
		storage = _storage;
		queue = _queue;
		executor.execute(new DownloaderThread(startURI, storage, queue, this));
		queue.setCounterForThreads(1);
	}
	
	public void setNewURIs(LinkedList<String> _URIList){
		URIList = _URIList;
		executeThreads();
	}
	
	private void executeThreads(){
		countDepth++;
		if(countDepth < 3){
			for(String uri : URIList){
				System.out.println(uri);
				executor.execute(new DownloaderThread(uri, storage, queue, this));
				countThreadsRunning++;
			}
			queue.setCounterForThreads(URIList.size());
		}
	}
	/*
	private String getDomain(String uri){
		uri = uri.substring(8);
		if(uri.indexOf("/") != -1){
			uri = uri.substring(0, uri.indexOf("/"));
		}
		uri = "http://" + uri;
		return uri;
	}*/
}
