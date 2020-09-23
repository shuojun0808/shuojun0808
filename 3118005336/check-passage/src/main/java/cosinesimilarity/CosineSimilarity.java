//余弦相似度算法
package cosinesimilarity;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class CosineSimilarity {
    private static String news;

    static public double getSimilarity(String t1, String t2) throws IOException {
        //分词出现位置
        Map<String, Vector<Integer>> Offset1=new TreeMap<String, Vector<Integer>>();
        //按键值排序
        Map<String, Vector<Integer>> Offset2=new TreeMap<String, Vector<Integer>>();
        int pos=0;
        StringReader sr1=new StringReader(t1);
        IKSegmenter ik1 = new IKSegmenter(sr1, true);
        Lexeme lex=null;
        while ((lex = ik1.next()) != null){
            Component(lex);
            if(Offset1.get(news)==null){
                Vector<Integer> off=new Vector<Integer>(100);
                off.add(pos);
                Offset1.put(news,off);
            }
            Offset1.get(news).add(pos);
            pos++;
        }

        StringReader sr2=new StringReader(t2);
        IKSegmenter ik2 = new IKSegmenter(sr2, true);
        pos = 0;
        while ((lex = ik2.next()) != null){
            Component(lex);
            if(Offset2.get(news)==null){
                Vector<Integer> off=new Vector<Integer>(100);
                off.add(pos);
                Offset2.put(news,off);
            }
            Offset2.get(news).add(pos);
            pos++;
        }

        int cnt=0;
        double up = 0, down1 = 0, down2 = 0,sum=0;
        for(String key:Offset1.keySet()){
            Vector<Integer> off1=Offset1.get(key);
            Vector<Integer> off2=Offset2.get(key);
            if(off2!=null){
                up=down1=down2=0;
                for(int i=0;i<off1.size()&&i<off2.size();i++){
                    up+= off1.elementAt(i)*off2.elementAt(i);
                    down1+= off1.elementAt(i)*off1.elementAt(i);
                    down2+=off2.elementAt(i)*off2.elementAt(i);
                }
                down1 = Math.sqrt(down1);
                down2 = Math.sqrt(down2);
                double down = down1 * down2;
                if(down!=0){
                    sum+=up/down;
                }
            }
            cnt++;
        }
        return sum/cnt;
    }

    private static void Component(Lexeme lex) {
        String s = lex.getLexemeText();
        news = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                news += c;
            }
        }
    }
}
