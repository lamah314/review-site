package org.wecancodeit.reviewsite.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy = "portfolio")
	private Collection<Review> Reviews;

	public Long getId() {
		return id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public String getUrl() {
		return url;
	}

	public Collection<Review> getReviews() {
		return Reviews;
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

	public Portfolio() {
	}

	public Portfolio(String portfolioName, String url) {
		this.portfolioName = portfolioName;
		this.url = url;
	}

	public void addReview(Review review) {
		Reviews.add(review);
	}

	public static String URLChecker(String url) {
		String fixedURL;
		if (!url.substring(0, 8).equalsIgnoreCase("https://")) {
			fixedURL = "https://" + url;
		} else {
			fixedURL = url;
		}
		return fixedURL;
	}

}
