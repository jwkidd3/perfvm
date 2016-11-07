package com.kiddcorp.mem;

/**
 * A class to demonstrate core dumping.
 */
public class CoreDumper {

	// load the library
	static {
		String path = System.getProperty("java.library.path");
		path = "/Users/jkidd/Documents/workspaces/jpt/Leaky/native:" + path;
		System.setProperty("java.library.path", path);
		System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("nativelib");
	}

	// native method declaration
	public native void core();

	public static void main(String[] args) {
		new CoreDumper().core();
	}
}