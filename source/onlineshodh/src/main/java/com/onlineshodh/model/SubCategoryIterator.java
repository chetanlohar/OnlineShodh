package com.onlineshodh.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

import org.apache.lucene.search.suggest.InputIterator;
import org.apache.lucene.util.BytesRef;

import com.onlineshodh.entity.SubCategoryEntity;

public class SubCategoryIterator implements InputIterator {

	private Iterator<SubCategoryEntity> SubCategoryIterator;
	private SubCategoryEntity currSubCategory;
	
	public SubCategoryIterator(){
	}
	
	public SubCategoryIterator(Iterator<SubCategoryEntity> subCategoryIterator) {
		SubCategoryIterator = subCategoryIterator;
	}


	@Override
	public BytesRef next() throws IOException {
		if(SubCategoryIterator.hasNext()){
			currSubCategory = SubCategoryIterator.next();
			try{
				return new BytesRef(currSubCategory.getSubCategoryName().getBytes("UTF8"));
			}catch(UnsupportedEncodingException ex){
				throw new Error("Not able to convert to UTF8");
			}
		}else{
			return null;
		}
	}

	@Override
	public long weight() {
		return 0;
	}

	@Override
	public BytesRef payload() {
		try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(currSubCategory);
            out.close();
         //   System.out.println("inflated object:"+bos);
            return new BytesRef(bos.toByteArray());
        } catch (IOException e) {
        	e.printStackTrace();
            throw new Error("Well that's unfortunate.");
            
        }
	}

	@Override
	public boolean hasPayloads() {
		return true;
	}

	@Override
	public Set<BytesRef> contexts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasContexts() {
		return false;
	}

}
