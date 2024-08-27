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

public class MixingMilk {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("mixmilk");
		int[] volume = new int[6];
		int shift;
		int counter = 1;
		
		for(int i = 0; i < 6; i++){
			volume[i] = io.nextInt();
		}
		
		for (int i = 0; i < 100; i++) {
			if (counter == 5) {
				shift = (volume[counter] + volume[1]) - volume[0];
			} else {
				shift = (volume[counter] + volume[counter + 2]) - volume[counter + 1];
			}
			if (shift <= 0) {
				shift = 0;
				if(counter == 5 && volume[1] != volume[0]){
					volume[1] += volume[counter];
					volume[counter] = 0;
					
				} else if(volume[counter + 2] != volume[counter + 1]){
					volume[counter + 2] += volume[counter];
					volume[counter] = 0;
				}
			} else if (shift > 0) {
				if(counter == 5) {
					volume[5] = shift;
					volume[1] = volume[0];
					
				} else {
					volume[counter] = shift;
					volume[counter + 2] = volume[counter + 1];
				}
			}
			if (counter == 5) {
				counter = 1;
			} else{				
				counter += 2;
			}
			
		}

		io.println(volume[1]);
		io.println(volume[3]);
		io.println(volume[5]);

		io.close();
	}
}



