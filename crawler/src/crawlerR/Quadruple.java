package crawlerR;
/**
 * Quadruple of information with subject, predicate and object and the source where this information comes from.
 * In addition it contains some meta data if available.
 * @author Robert Bierbauer
 *
 */
public class Quadruple {
	private String subject;
	private String predicate;
	private String object;
	private String source;
	private String meta;
	
	public Quadruple(String _subject, String _predicate, String _object, String _source, String _meta){
		subject = _subject;
		predicate = _predicate;
		object = _object;
		source = _source;
		meta = _meta;
	}
	
	public String print(){
		String all = "";
		all += "<" + subject + "> ";
		all += "<" + predicate + "> ";
		all += "<" + object + ">\n";
		return all;
	}
	
	public String printAll(){
		String all = "";
		all += "<" + subject + "> ";
		all += "<" + predicate + "> ";
		all += "<" + object + ">\nsource: ";
		all += "<" + source + ">, meta: ";
		all += meta + "\n";
		return all;
	}
	
	//getters and setters
	public String getSubject() {
		return subject;
	}

	public String getPredicate() {
		return predicate;
	}

	public String getObject() {
		return object;
	}

	public String getSource() {
		return source;
	}

	public String getMeta() {
		return meta;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}
	
}
