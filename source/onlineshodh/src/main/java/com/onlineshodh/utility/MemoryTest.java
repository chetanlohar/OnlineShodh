package com.onlineshodh.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryTest {
    static Map<Integer, NewObject> map = new HashMap<Integer, NewObject>();
    public static void main(String[] args){
        
    	
    	/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	System.out.println(encoder.matches("chetan777", "$2a$10$gW7zqWNxCfGfD4CIciVos.zsThJRyI7JHhtwiE8qFQSH.Q5r9mm9q"));*/
    	
    	/*System.out.println("Chetan.Lohar.jpeg".substring("Chetan.Lohar.jpeg".lastIndexOf(".")));*/
    	
    	
    	/*System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        fillMemory(25);
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);*/
    	
    	/*List<Integer> nums = new ArrayList<Integer>();
    	nums.add(1);
    	nums.add(2);
    	nums.add(1);
    	nums.add(3);
    	nums.add(3);
    	
    	Set<Integer> numset = new HashSet<Integer>(nums);
    	for(Integer i:numset)
    		System.out.println(i);*/
    	
    	/*List<String> iconList = new ArrayList<String>();
		File iconDir = new File("http://onlineshodh.com/resources/images/icons/");
		System.out.println("iconDir: "+iconDir);
		
		for (File imageFile : iconDir.listFiles()) {
			iconList.add(imageFile.getName());
		}*/
    	
    }
    static int j=0;
    public static void fillMemory(int i){
        for(int k=0; k< 5000; k++)
            map.put(j++, new NewObject());
    }
    public static class NewObject{
        long i = 0L;
        long j = 0L;
        long k = 0L;
    }
}
