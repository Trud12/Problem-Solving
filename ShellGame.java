// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayList;
class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName + ".out");
		r = new BufferedReader(new FileReader(problemName + ".in"));
	}
	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) {}
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
	public void reset() throws IOException{r.reset();}
	public void mark(int readAheadLimit) throws IOException {r.mark(readAheadLimit);}
}

public class ShellGame {
	public static void main(String[] args) throws IOException {
		
		Kattio io = new Kattio("shell");

		int max = 0;
		int n = io.nextInt();
		io.mark(100000000);
		for(int i = 1; i <= 3; i++){
			int count = 0;
			int pos = i;
			io.reset();
			for(int j = 0; j < n; j++){
				int a = io.nextInt();
				int b = io.nextInt();
				int g = io.nextInt();
				if(a == pos){
					pos = b;
				} else if(b == pos){
					pos = a;
				} if(pos == g){
					count++;
				}
			}
			max = Math.max(count, max); 
		}	
		
		io.println(max);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		io.close();
	}
}
