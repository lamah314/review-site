package org.wecancodeit.reviewsite.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Portfolio portfolio;

	private Long userId;

	private long easeOfUseRating;
	private long aestheticsRating;
	private long contentRating;
	private long creativityRating;

	private long overallRating;

	@Column(columnDefinition = "LONGTEXT")
	private String overallComment;

	@ManyToMany
	private Collection<ReviewTag> reviewTags;

	public Long getId() {
		return this.id;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public Long getUserId() {
		return userId;
	}

	public long getEaseOfUseRating() {
		return easeOfUseRating;
	}

	public Collection<ReviewTag> getReviewTags() {
		return reviewTags;
	}

	public long getAestheticsRating() {
		return aestheticsRating;
	}

	public long getContentRating() {
		return contentRating;
	}

	public long getCreativityRating() {
		return creativityRating;
	}

	public String getOverallComment() {
		return overallComment;
	}

	public long getOverallRating() {
		return overallRating;
	}

	public Review() {
	}

	public Review(Portfolio portfolio,
//			Long userId, 
			long easeOfUseRating, long aestheticsRating, long contentRating, long creativityRating, long overallRating,
			String easeOfUseComment, String aestheticsComment, String contentComment, String creativityComment,
			String overallComment) {
		this.portfolio = portfolio;
//		this.userId = userId;
		this.easeOfUseRating = easeOfUseRating;
		this.aestheticsRating = aestheticsRating;
		this.contentRating = contentRating;
		this.creativityRating = creativityRating;
		this.overallRating = overallRating;
		this.overallComment = overallComment;

	}

	public Review(Portfolio portfolio,
//			Long userId, 
			long easeOfUseRating, long aestheticsRating, long contentRating, long creativityRating, long overallRating,
			String overallComment, String easeOfUseComment, String aestheticsComment, String contentComment,
			String creativityComment, ReviewTag... reviewTags) {
		this.reviewTags = Arrays.asList(reviewTags);
		this.portfolio = portfolio;
//		this.userId = userId;
		this.easeOfUseRating = easeOfUseRating;
		this.aestheticsRating = aestheticsRating;
		this.contentRating = contentRating;
		this.creativityRating = creativityRating;
		this.overallRating = overallRating;
		this.overallComment = overallComment;

	}

	public void addReviewTagtoReview(ReviewTag reviewTag) {
		reviewTags.add(reviewTag);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + (int) (aestheticsRating ^ (aestheticsRating >>> 32));

		result = prime * result + (int) (contentRating ^ (contentRating >>> 32));

		result = prime * result + (int) (creativityRating ^ (creativityRating >>> 32));

		result = prime * result + (int) (easeOfUseRating ^ (easeOfUseRating >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((overallComment == null) ? 0 : overallComment.hashCode());
		result = prime * result + (int) (overallRating ^ (overallRating >>> 32));
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result + ((reviewTags == null) ? 0 : reviewTags.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Review other = (Review) obj;
		;
		;
		if (aestheticsRating != other.aestheticsRating)
			return false;

		if (contentRating != other.contentRating)
			return false;

		if (creativityRating != other.creativityRating)
			return false;

		if (easeOfUseRating != other.easeOfUseRating)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (overallComment == null) {
			if (other.overallComment != null)
				return false;
		} else if (!overallComment.equals(other.overallComment))
			return false;
		if (overallRating != other.overallRating)
			return false;
		if (portfolio == null) {
			if (other.portfolio != null)
				return false;
		} else if (!portfolio.equals(other.portfolio))
			return false;
		if (reviewTags == null) {
			if (other.reviewTags != null)
				return false;
		} else if (!reviewTags.equals(other.reviewTags))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
