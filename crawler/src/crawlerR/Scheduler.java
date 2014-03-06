package crawlerR;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {
	ExecutorService executor;
	private String startURI;
	public Scheduler(String _startURI){
		executor = Executors.newCachedThreadPool();
		startURI = _startURI;
		start();
	}
	
	private void start(){
		try{
			URL URI = new URL(startURI);
			BufferedReader in = new BufferedReader(new InputStreamReader(URI.openStream(), Charset.forName("UTF-8")));

	
	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println(inputLine);
	        in.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void getNewURIs(LinkedList<String> URIList){
		
	}
}
