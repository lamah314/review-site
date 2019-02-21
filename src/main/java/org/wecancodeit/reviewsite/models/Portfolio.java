package org.wecancodeit.reviewsite.models;

import java.util.List;

public class Portfolio {

	private String portfolioName;
	private String url;

	private long avgEaseOfUseRating;
	private long avgAestheticsRating;
	private long avgContentRating;
	private long avgCreativityRating;
	
	private List<Review> Reviews;

	public String getPortfolioName() {
		return portfolioName;
	}
	
	public String getUrl() {
		return url;
	}

	public long getAvgEaseOfUseRating() {
		return avgEaseOfUseRating;
	}

	public long getAvgAestheticsRating() {
		return avgAestheticsRating;
	}

	public long getAvgContentRating() {
		return avgContentRating;
	}

	public long getAvgCreativityRating() {
		return avgCreativityRating;
	}

	public List<Review> getReviews() {
		return Reviews;
	}

	public Portfolio(String portfolioName, String url) {
		this.portfolioName = portfolioName;
		this.url = url;
	}
	
	
	
}
