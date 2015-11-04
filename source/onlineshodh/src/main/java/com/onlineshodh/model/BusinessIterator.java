package com.onlineshodh.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.lucene.search.suggest.InputIterator;
import org.apache.lucene.util.BytesRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineshodh.entity.BusinessDetailsEntity;
import com.onlineshodh.service.BusinessAddressService;

@Component
public class BusinessIterator implements InputIterator {

	private Iterator<BusinessDetailsEntity> businessIterator;
	private BusinessDetailsEntity currBusiness;
	
	@Autowired
	BusinessAddressService businessAddressService;
	
	public BusinessIterator() {
	}

	public BusinessIterator(Iterator<BusinessDetailsEntity> businessIterator) {
		this.businessIterator = businessIterator;
	}

	@Override
	public BytesRef next(){
		if(businessIterator.hasNext()){
			currBusiness = businessIterator.next();
			try{
				return new BytesRef(currBusiness.getBusinessName().getBytes("UTF8"));
			}catch(UnsupportedEncodingException ex){
				throw new Error("Not able to convert to UTF8");
			}
		}else{
			return null;
		}
	}

	@Override
	public Set<BytesRef> contexts() {
		try {
            Set<BytesRef> addlParams = new HashSet<BytesRef>();
            String city = currBusiness.getAddress().getTown().getCity().getCityName();
            String town = currBusiness.getAddress().getTown().getTownName();
            String cityTown = city.toUpperCase()+" ("+town.toUpperCase()+")";
            addlParams.add(new BytesRef(cityTown.getBytes("UTF8")));
            return addlParams;
        } catch (UnsupportedEncodingException e) {
            throw new Error("Couldn't convert to UTF-8");
        }
	}

	@Override
	public boolean hasContexts() {
		return true;
	}

	@Override
	public boolean hasPayloads() {
		return true;
	}

	@Override
	public BytesRef payload() {
		try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(currBusiness);
            out.close();
         //   System.out.println("inflated object:"+bos);
            return new BytesRef(bos.toByteArray());
        } catch (IOException e) {
        	e.printStackTrace();
            throw new Error("Well that's unfortunate.");
            
        }
	}

	@Override
	public long weight() {
		return currBusiness.getRank();
	}

}
