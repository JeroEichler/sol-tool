package serendipity.web.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import sol_tool_1_5.Interface.SOLToolInterface;
import sol_tool_1_5.QueryResult.QueryResult;
import sol_tool_1_5.QueryResult.QueryResultView;

@ManagedBean
@ViewScoped
public class SearchBean {
	
	private String queryString = "";
	private Integer limitSelected = 5;
	private Integer searchStep = 0;
	
	private List<String> alternativeQuery = new ArrayList<String>();
	private List<QueryResultView> results = new ArrayList<QueryResultView>();
	
	private SOLToolInterface system = new SOLToolInterface();
	
	public String searchCommand() {		
		Map<List<String>, QueryResult> dicResults = system.processOnDatasets(queryString, system.availableDatasetAddresses(), limitSelected, 0);
		
		results = new ArrayList<QueryResultView>();
		
		for(QueryResult result : dicResults.values()) {
			results.add(result.exportView());
		}
		
		return "listar";
	}
	
	public String moreCommand() {
		
		searchStep++;		
		Map<List<String>, QueryResult> dicResults = system.processOnDatasets(queryString, system.availableDatasetAddresses(), limitSelected, searchStep);
		
		for(QueryResult result : dicResults.values()) {
			results.add(result.exportView());
		}
		
		return "listar";
	}
	
	public String queryGeneration() {	
		List<String> k = system.createQueries(queryString, system.availableDatasetAddresses());
		if(k != null && k.size() != 0)
			setAlternativeQuery(k);
		else {
			List<String> nothing = new ArrayList<String>();
			nothing.add("No alternative queries were found.");
			setAlternativeQuery(nothing);
		}
			
		
		
		return "gone";
	}
	
	public String getQueryString() {
		return queryString;
	}
	
	public void setQueryString(String query) {
		this.queryString = query;
	}

	public Integer getLimitSelected() {
		return limitSelected;
	}

	public void setLimitSelected(Integer limit) {
		this.limitSelected = limit;
	}

	public Integer getSearchStep() {
		return searchStep;
	}

	public void setSearchStep(Integer i) {
		this.searchStep = i;
	}

	public List<String> getAlternativeQuery() {
		return alternativeQuery;
	}

	public void setAlternativeQuery(List<String> alternativeQuery) {
		this.alternativeQuery = alternativeQuery;
	}

	public List<QueryResultView> getResults() {
		return results;
	}

	public void setResults(List<QueryResultView> alternativeQuery) {
		this.results = alternativeQuery;
	}

}
