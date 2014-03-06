package crawlerR;
import java.util.LinkedList;
import java.util.List;


public class Storage {
	private List<Quadruple> quadsList;
	public Storage() {
		quadsList = new LinkedList<Quadruple>();
	}
	
	public void addQuad(String subject, String predicate, String object, String source, String meta){
		Quadruple quad = new Quadruple(subject, predicate, object, source, meta);
		quadsList.add(quad);
	}
	
	public void printAllQuads(){
		String all = "";
		for(Quadruple q : quadsList){
			all += q.print();
		}
		System.out.println(all);
	}
}
