package com.onlineshodh.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessDetailsService;

@Component
public class SuggestBusiness{

	@Autowired
	BusinessDetailsService businessService;
	
	StandardAnalyzer analyzer;
	Directory index;
	AnalyzingInfixSuggester suggester;
	
	@PostConstruct
	public void init()
	{
		analyzer = new StandardAnalyzer();
		index = new RAMDirectory();
		List<BusinessDetailsEntity> businesses = businessService.getAllBusinessDetais();
		try {
			suggester = new AnalyzingInfixSuggester(index, analyzer);
			suggester.build(new BusinessIterator(businesses.iterator()));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	private List<String> initLookup(AnalyzingInfixSuggester suggester, String name) {
    	List<String>  lstResults = new ArrayList<String>();
        try {
            List<Lookup.LookupResult> results;
            HashSet<BytesRef> contexts = new HashSet<BytesRef>();
            contexts.add(new BytesRef("FLIGHT".getBytes("UTF8")));
            //contexts.add(new BytesRef(addlParam.getBytes("UTF8")));
            // Do the actual lookup.  We ask for the top 10 results.
            results = suggester.lookup(name, contexts, 10, true, false);
            for (Lookup.LookupResult result : results) {
            	BusinessDetailsEntity business = getBusiness(result);
                if (business != null) {
                    /*lstResults.add(trainEnt.getTitle() + ":" + trainEnt.getDescription() );*/
                	lstResults.add(business.getBusinessName());
                }
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
        return lstResults;
    }
	
	private BusinessDetailsEntity getBusiness(Lookup.LookupResult result)
    {
        try {
            BytesRef payload = result.payload;
            if (payload != null) {
                ByteArrayInputStream bis = new ByteArrayInputStream(payload.bytes);
                ObjectInputStream in = new ObjectInputStream(bis);
                BusinessDetailsEntity p = (BusinessDetailsEntity) in.readObject();
                return p;
            } else {
                return null;
            }
        } catch (IOException|ClassNotFoundException e) {
            throw new Error("Could not decode payload :(");
        }
    }
	
	public List<String> doAutoSuggest(String tagName)
	{
		return initLookup(suggester, tagName);
	}
}
