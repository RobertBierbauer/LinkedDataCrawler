package crawlerR;
import java.util.LinkedList;
import java.util.List;


public class URIQueue {
	private LinkedList<String> visitedList;
	private LinkedList<String> notVisitedList;
	
	public URIQueue(){
		visitedList = new LinkedList<String>();
		notVisitedList = new LinkedList<String>();
	}
	
	public void newURIs(LinkedList<String> newURIsList){
		for(String uri : newURIsList){
			if(!wasVisited(uri)){
				notVisitedList.add(uri);
			}
		}
		sendToScheduler(notVisitedList);
	}
	
	private boolean wasVisited(String URI){
		if(visitedList.size() == 0){
			return false;
		}
		else{
			int first = 0;
			int last = visitedList.size() -1;
			int center = (int) Math.floor(last/2.0);
			while(first != last){
				if(visitedList.get(center).equals(URI)){
					return true;
				}
				else{
					if(visitedList.get(center).compareTo(URI) < 0){
						first = center +1;
					}
					else{
						last = center - 1;
					}
					int tmp = last - first;
					center = (int) Math.floor(tmp/2.0);
					center += first;
				}
			}
			if(visitedList.get(first).equals(URI)){
				return true;
			}
		}
		return false;
	}
	
	private void sendToScheduler(LinkedList<String> notVisitedList){
		//TODO send to scheduler
		/*
		 * insert all URIs from the not visited list into the visited list by binary search
		 * and remove all URIs from the not visited list
		 * visited list is sorted after this process
		 */
		for(String s : notVisitedList){			
			if(visitedList.size() == 0){
				visitedList.add(s);
			}
			else{
				int first = 0;
				int last = visitedList.size() -1;
				int center = (int) Math.floor(last/2.0);
				while(first != last){
					if(visitedList.get(center).compareTo(s) < 0){
						if(visitedList.get(center +1).compareTo(s) > 0){
							visitedList.add(center+1, s);
							break;
						}
						else{
							first = center + 1;
							int tmp = last - first;
							center = (int) Math.floor(tmp/2.0);
							center += first;
						}
					}
					else{
						if(visitedList.get(center -1).compareTo(s) < 0){
							visitedList.add(center, s);
							break;
						}
						else{
							last = center -1;
							center = (int) Math.floor(last/2.0);
						}
					}
				}
				if(first == last){
					if(visitedList.get(first).compareTo(s) < 0){
						visitedList.add(first+1, s);						
					}
					else{
						visitedList.add(first, s);
					}
				}
			}
		}
		notVisitedList.clear();
	}
}
