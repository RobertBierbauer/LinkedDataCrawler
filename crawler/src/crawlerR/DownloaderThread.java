package crawlerR;
import java.util.Hashtable;


public class DownloaderThread extends Thread{
	private String domain;
	private Scheduler tm;
	
	public DownloaderThread(String _domain, Scheduler _tm){
		domain = _domain;
		tm = _tm;
		lookUp(domain);
	}
	
	private void lookUp(String domain){
		
	}
	
}
