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
		if (!url.substring(0, 4).equalsIgnoreCase("http")) {
			fixedURL = "https://" + url;
		} else {
			fixedURL = url;
		}
		return fixedURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reviews == null) ? 0 : Reviews.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portfolioName == null) ? 0 : portfolioName.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		if (Reviews == null) {
			if (other.Reviews != null)
				return false;
		} else if (!Reviews.equals(other.Reviews))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (portfolioName == null) {
			if (other.portfolioName != null)
				return false;
		} else if (!portfolioName.equals(other.portfolioName))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	

}
