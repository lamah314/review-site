package org.wecancodeit.reviewsite.repositories;

import java.util.ArrayList;
import java.util.List;

import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;

public class ReviewsRepository {

	private List<Review> reviews;
	


	public ReviewsRepository(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public String toString() {
		return "ReviewsRepository [reviews=" + reviews + "]";
	}

	public List<Review> listPortfolioReviews(String portfolioName) {
		List<Review> reviewList = new ArrayList<Review>();
		for (Review review: reviews) {
			if(review.getPortfolioName().equals(portfolioName)) {
				reviewList.add(review);
			}
		}
		return reviewList;
	}
	
	
}
