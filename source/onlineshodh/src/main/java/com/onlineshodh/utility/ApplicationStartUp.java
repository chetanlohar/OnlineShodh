package com.onlineshodh.utility;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.onlineshodh.service.BusinessDetailsService;

public class ApplicationStartUp implements ServletContextListener {

	WebApplicationContext springContext;
	
	@Autowired
	BusinessDetailsService businessService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(sce
				.getServletContext());
		String basePath = sce.getServletContext().getInitParameter(
				"LuceneIndexFilePath");
		SearchUtility.basePath = basePath;
		System.out.println("basePath: " + basePath);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/*public void indexBusiness(ServletContextEvent sce) throws IOException {
		// 0. Specify the analyzer for tokenizing text.
		// The same analyzer should be used for indexing and searching
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);

		// 1. create the index
		Directory index = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40,analyzer);
		IndexWriter w = new IndexWriter(index, config);
		List<BusinessDetailsEntity> l = businessService.getAllBusinessDetais();
		for(BusinessDetailsEntity b:l)
		{
			Document businessDoc = createDocument(b);
			w.addDocument(businessDoc);
		}
		w.close();
	}
	
	public Document createDocument(BusinessDetailsEntity business)
	{
		Document doc = new Document();
		TextField businessName = new TextField("businessName", business.getBusinessName(), Field.Store.YES);
		doc.add(businessName);
		TextField subCategory = new TextField("subCategory", business.getSubCategory().getSubCategoryName(), Field.Store.YES);
		doc.add(subCategory);
		return doc;
	}*/

}
