import java.util.*;

public class wordLadder {
    public static void main(String[] args) {
        String beginword = "hit";
        String endword = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};

        int res = sub(beginword,endword,wordList);
        System.out.println(res);
    }

    public static int sub(String b,String e,String[] w)
    {
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{b,1});
        Set<String> st = new HashSet<>();

        for(int i=0;i<w.length;i++)
        {
            st.add(w[i]);
        }

        while(!q.isEmpty())
        {
            Object[] node =q.poll();
            String s = (String) node[0];
            int steps = (int) node[1];

            if(s.equals(e) == true) return steps;

            for(int i=0;i<s.length();i++)
            {
                for(char ch ='a';ch<='z';ch++)
                {
                    char[] changedarray = s.toCharArray();
                    changedarray[i]=ch;
                    String replaceword = new String(changedarray);
                    if(st.contains(replaceword)== true)
                    {
                        st.remove(replaceword);
                        q.offer(new Object[]{replaceword,steps+1}); 
                    }
                }
            }

        }
        return 0;
    }
}

