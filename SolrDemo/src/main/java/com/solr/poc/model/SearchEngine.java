package com.solr.poc.model;


import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;

public class SearchEngine {
	
	String urlString = "http://localhost:8983/solr/demo";
	private SolrClient solrClient = new HttpSolrClient(urlString);
	
	public QueryResponse searchByKeyword(String keyword) throws IOException{
		
		SolrQuery query = new SolrQuery();
		
		
		query.setQuery(keyword);

		QueryResponse result = null;
		try {
			result =  solrClient.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public QueryResponse search(List filters) throws IOException, SolrServerException {
		
		SolrQuery query = new SolrQuery();
		query.setQuery("id:*");
		QueryResponse result = null;
		try {
			result =  solrClient.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void uploadFile(){
		
	}
	
	public void addToIndex(List fieldList){
	
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "tsetstst3r4", 1.0f);
		doc.addField("name", "doc1", 1.0f);
		doc.addField("price", 10);
		
		try {
			solrClient.add(doc);
			solrClient.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
