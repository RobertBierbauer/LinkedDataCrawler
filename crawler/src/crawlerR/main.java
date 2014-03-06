package crawlerR;


public class main {
	public static void main(String[] args){
		Storage storage = new Storage();
		URIQueue queue = new URIQueue();
		Scheduler s = new Scheduler("http://www.w3.org/People/Berners-Lee/card.rdf", storage, queue);
	}
	
	
}
