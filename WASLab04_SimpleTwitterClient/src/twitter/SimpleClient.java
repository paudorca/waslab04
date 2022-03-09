package twitter;

import java.util.Date;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.Paging;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		GetTweetStreamForKeywords(); 
	}
	
	private static void GetTweetStreamForKeywords()
	   {
	   TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	   StatusListener statusListener = new StatusAdapter() {
	    @Override
	    public void onStatus(Status status) {
	     
	       System.out.println(status.getUser().getName()  + "(" + status.getUser().getScreenName() + ")" + " : " + status.getText() );

	    }
	       @Override
	       public void onDeletionNotice(StatusDeletionNotice sdn) {
	         throw new UnsupportedOperationException("Not supported yet."); 
	       }
	       @Override
	       public void onTrackLimitationNotice(int i) {
	         throw new UnsupportedOperationException("Not supported yet."); 
	       }
	       @Override
	       public void onScrubGeo(long l, long l1) {
	         throw new UnsupportedOperationException("Not supported yet."); 
	       }
	       @Override
	       public void onStallWarning(StallWarning sw) {
	         throw new UnsupportedOperationException("Not supported yet.");
	       }
	     };


	     FilterQuery fq = new FilterQuery();        
	     String keywords[] = {"#covid19"};
	     fq.track(keywords);

	        
	     twitterStream.addListener(statusListener);
	     twitterStream.filter(fq);          
	  }
}
