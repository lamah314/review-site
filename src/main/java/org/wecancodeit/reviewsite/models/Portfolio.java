package org.wecancodeit.reviewsite.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Portfolio {

	@Id
	@GeneratedValue
	private Long id;
	
	private String portfolioName;
	private String url;

//	private long avgEaseOfUseRating;
//	private long avgAestheticsRating;
//	private long avgContentRating;
//	private long avgCreativityRating;
//	
//	private List<Review> Reviews;
	
	public Long getID() {
		return id;
	}
	
	public String getPortfolioName() {
		return portfolioName;
	}
	
	public String getUrl() {
		return url;
	}

//	public long getAvgEaseOfUseRating() {
//		return avgEaseOfUseRating;
//	}
//
//	public long getAvgAestheticsRating() {
//		return avgAestheticsRating;
//	}
//
//	public long getAvgContentRating() {
//		return avgContentRating;
//	}
//
//	public long getAvgCreativityRating() {
//		return avgCreativityRating;
//	}
//
//	public List<Review> getReviews() {
//		return Reviews;
//	}

	public Portfolio() {}

	public Portfolio(String portfolioName, String url) {
		this.portfolioName = portfolioName;
		this.url = url;
	}
	
	public static String URLChecker(String url) {
		String fixedURL;
		if(!url.substring(0, 8).equalsIgnoreCase("https://")) {
			fixedURL = "https://" + url;
		} else {
			fixedURL = url;
		}
		return fixedURL;
	}
	
}
