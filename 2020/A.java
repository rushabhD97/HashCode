import java.util.*;
import java.io.*;

class A {
    static int max=0;
    static List<Integer> maxPath=new ArrayList<>();
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(
                        new FileReader(new File("D:\\Competitive Programming\\HashCode\\a_example.txt")));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Book {
        private int score;
        private int id;

        Book(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public String toString() {
            return this.id + "=>" + this.score + " ";
        }
    }

    static class Library {
        private PriorityQueue<Book> setOfBooks;
        private int signUpTime, shipBookPerDay;
        private int numberOfBooks;

        private int numberOfDaysReqd;
        private List<List<Book>> list;
        private List<Integer> preSumScore;
        Library(int numberOfBooks, int signUpTime, int shipBookPerDay) {
            this.numberOfBooks = numberOfBooks;
            this.signUpTime = signUpTime;
            this.shipBookPerDay = shipBookPerDay;
            this.numberOfDaysReqd = (int) Math.ceil(numberOfBooks * 1.0d / shipBookPerDay);
            setOfBooks = new PriorityQueue<>(new Comparator<Book>() {

                @Override
                public int compare(Book o1, Book o2) {
                    return o2.score - o1.score;
                }

            });
        }
        void addBooks(Book bi) {
            this.setOfBooks.add(bi);
        }
        void combine(){
            list=new ArrayList<>();
            preSumScore=new ArrayList<>();
            int sum=0;
            while(!setOfBooks.isEmpty()){
                int i=0;
                List<Book> l1=new ArrayList<>();
                while(i<shipBookPerDay&&!setOfBooks.isEmpty()){
                    Book p=setOfBooks.poll();
                    l1.add(p);i++;
                    sum+=p.score;
                }
                preSumScore.add(sum);
                list.add(l1);
            }
        }
        public String toString() {
            return list.toString();
        }
    }

    public static void main(String args[])throws Exception {
        FastReader sc = new FastReader();
        PrintStream o = new PrintStream(new File("D:\\Competitive Programming\\HashCode\\a_example_out.txt")); 
        System.setOut(o);
        int b = sc.nextInt();
        int l = sc.nextInt();
        int d = sc.nextInt();

        Book[] bi = new Book[b];
        for (int i = 0; i < b; i++)
            bi[i] = new Book(i, sc.nextInt());

        Library[] li = new Library[l];
        for (int i = 0; i < l; i++) {
            li[i] = new Library(sc.nextInt(), sc.nextInt(), sc.nextInt());
            for (int a = 0; a < li[i].numberOfBooks; a++) {
                li[i].addBooks(bi[sc.nextInt()]);
            }
            li[i].combine();
            // System.out.println(li[i]);
        }
        boolean visited[]=new boolean[l];
        List<Integer> path=new ArrayList<>();
        for(int i=0;i<l;i++){
            int remDays=d-li[i].signUpTime;
            int remscore=li[i].preSumScore.get(Math.min(remDays-1,li[i].preSumScore.size()-1));
            visited[i]=true;
            path.add(i);
            dfs(i,l,li,visited,path,remscore,li[i].signUpTime,d);
            path.remove(path.size()-1);
            visited[i]=false;
        }

        System.out.println(maxPath.size());
        int time=0;
        for(int i=0;i<maxPath.size();i++){
            int x=maxPath.get(i);
            time+=li[x].signUpTime;
            int remDays=d-time;
            int booksScanned=0;
            for(int r=0;r<remDays;r++){
                for(Book p:li[x].list.get(r))
                    booksScanned++;
            }
            System.out.println(x+" "+booksScanned);

            for(int r=0;r<remDays;r++){
                for(Book p:li[x].list.get(r))
                    System.out.print(p.id+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int i,int l, Library[] li, boolean[] visited,List<Integer> currentPath,int score, int totalTime, int d) {
        if(max<score){
            max=score;
            maxPath=new ArrayList<>(currentPath);
        }
        if(totalTime>=d){
            return;
        }
        for(int x=0;x<l;x++){
            if(!visited[x]){
                int remDays=d-totalTime-li[x].signUpTime;
                if(remDays<=0)
                    continue;
                int remscore=li[x].preSumScore.get(Math.min(remDays-1,li[x].preSumScore.size()-1));
                currentPath.add(x);
                
                visited[x]=true;
                dfs(x,l,li,visited,currentPath,score+remscore,totalTime+li[x].signUpTime,d);
                visited[x]=false;

                currentPath.remove(currentPath.size()-1);
            }
        }
    }

}