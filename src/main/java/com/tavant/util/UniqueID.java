package com.tavant.util;

public class UniqueID {
	
	static long current= System.currentTimeMillis();
    static public long get(){
        return current++;
    }

}
