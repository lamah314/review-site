package org.wecancodeit.reviewsite.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wecancodeit.reviewsite.models.Portfolio;

public class PortfoliosRepository {
	
	private List<Portfolio> portfolios;
	

	public PortfoliosRepository(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
		this.addPortfolio(new Portfolio("Anthony Lam", "https://lamah314.github.io"));
		this.addPortfolio(new Portfolio("Nick Miner", "https://minernj.github.io"));
		this.addPortfolio(new Portfolio("Alicia Jeffers", "https://akjeffers.github.io"));
		
		
	}


	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void addPortfolio(Portfolio portfolio) {
		portfolios.add(portfolio);
	}

	@Override
	public String toString() {
		return "PortfoliosRepository [portfolios=" + portfolios + "]";
	}
	

}
