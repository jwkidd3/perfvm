package com.kiddcorp.mem;

import java.util.HashMap;
import java.util.Map;

class KeylessEntry {

	static class Key extends Object {
		Integer id;
		Byte[] b;

		Key(Integer id) {
			this.id = id;
			b = new Byte[100];
		}

		@Override
		public boolean equals(Object obj) {
			boolean ret = false;
			if (obj == this)
				ret =true;
			if (((Key) obj).id == this.id)
				ret = true;

			return ret;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}

	public static void main(String[] args) {
		Map m = new HashMap();
		while (true) {
			int i = 0;
			for (; i < 10000; i++) {
				if (!m.containsKey(new Key(i)))
					m.put(new Key(i), "Number:" + i);
			}
			System.out.println("Running: " + i);
			System.out.println("Total Size: " + m.size());
			System.gc();
		}
	}
}