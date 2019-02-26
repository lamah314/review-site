package org.wecancodeit.reviewsite.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
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
	@Column(columnDefinition = "LONGTEXT")
	private String easeOfUseComment;
	@Column(columnDefinition = "LONGTEXT")
	private String aestheticsComment;
	@Column(columnDefinition = "LONGTEXT")
	private String contentComment;
	@Column(columnDefinition = "LONGTEXT")
	private String creativityComment;

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

	public String getEaseOfUseComment() {
		return easeOfUseComment;
	}

	public String getAestheticsComment() {
		return aestheticsComment;
	}

	public String getContentComment() {
		return contentComment;
	}

	public String getCreativityComment() {
		return creativityComment;
	}

	public long getOverallRating() {
		return overallRating;
	}

	public Review() {
	}

	public Review(Portfolio portfolio, Long userId, long easeOfUseRating, long aestheticsRating, long contentRating,
			long creativityRating, long overallRating, String easeOfUseComment,
			String aestheticsComment, String contentComment, String creativityComment, String overallComment) {
		super();
		this.portfolio = portfolio;
		this.userId = userId;
		this.easeOfUseRating = easeOfUseRating;
		this.aestheticsRating = aestheticsRating;
		this.contentRating = contentRating;
		this.creativityRating = creativityRating;
		this.overallRating = overallRating;
		this.overallComment = overallComment;
		this.easeOfUseComment = easeOfUseComment;
		this.aestheticsComment = aestheticsComment;
		this.contentComment = contentComment;
		this.creativityComment = creativityComment;

	}

}
