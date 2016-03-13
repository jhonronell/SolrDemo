package com.solr.poc;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;

import com.solr.poc.model.SearchEngine;

public class TestSolr {

	@Test
	public void testConnection() throws IOException, SolrServerException {
		SearchEngine searchEngine = new SearchEngine();
		List filters = new ArrayList();
		searchEngine.search(filters);
	}

}
