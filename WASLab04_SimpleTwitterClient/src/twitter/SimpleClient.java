package twitter;

import java.util.Date;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		final Twitter twitter = new TwitterFactory().getInstance();
		
		Date now = new Date();
		String latestStatus = "Hey @fib_was, we've just completed task #4 [timestamp: "+now+"]";
		Status status = twitter.updateStatus(latestStatus);
		System.out.println("Successfully updated the status to: " + status.getText()); 
		Paging paging = new Paging(1, 100);
		List<Status> statuses = twitter.getUserTimeline("fib_was",paging);
		Status status1 = null; 
		Status status2 = null; 
		for (int i = 0; i < statuses.size(); i++) {
			   status1 = statuses.get(i);
			   if (i == 0) status2 = status1; 
		       System.out.printf(status1.getText());
		     }
		twitter.retweetStatus(status2.getId()); 
	}
}
