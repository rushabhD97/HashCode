package Y2021.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader(String filename) {
        try {
            br = new BufferedReader(
                    new FileReader(new File("D:\\Competitive Programming\\HashCode\\Y2021\\input\\"+filename+".txt")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

