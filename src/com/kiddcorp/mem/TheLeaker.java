package com.kiddcorp.mem;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class TheLeaker {

	public static void main(String[] args) {
		String key="name";
		String val="John";
		
		//key+val;
		
		StringBuilder b=new StringBuilder();
		b.append(key);
		b.append(val);
		
		ReferenceQueue referenceQueue = new ReferenceQueue();
		HashMap map = new HashMap();
		Reference reference = new PhantomReference(key, referenceQueue);
		
		map.put(reference, val);
		
		System.out.println(reference.get());
		System.out.println(map.get(reference));
		System.out.println(reference.isEnqueued());
	}

}
