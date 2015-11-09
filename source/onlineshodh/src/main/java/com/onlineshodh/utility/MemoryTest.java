package com.onlineshodh.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MemoryTest {
    static Map<Integer, NewObject> map = new HashMap<Integer, NewObject>();
    public static void main(String[] args){
        
    	
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	System.out.println(encoder.matches("chetan777", "$2a$10$gW7zqWNxCfGfD4CIciVos.zsThJRyI7JHhtwiE8qFQSH.Q5r9mm9q"));
    	
    	
    	
    	/*System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        fillMemory(25);
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);*/
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
