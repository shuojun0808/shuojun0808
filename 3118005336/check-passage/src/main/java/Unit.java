import cosinesimilarity.CosineSimilarity;
import simhash.SimHash;
import simhash.formula;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit {
    static double ans(String path1, String path2) throws IOException {
        //路径指定
        String filePath = path1;
        String comparePath = path2;

        //被比较文本与比较文本
        String txt1 = new String();
        String txt2 = new String();

        //文本输入
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(comparePath), "UTF8"));
        String str;
        while ((str = in1.readLine()) != null) {
            txt1 += str;
        }
        while ((str = in2.readLine()) != null) {
            txt2 += str;
        }
        in1.close();
        in2.close();

        if(txt1.length() == 0 || txt2.length() == 0){
            throw new Exception("文本为空");
        }

        double ans;

        //当文章长度大于3000时候使用simhash算法
        if(txt1.length() > 3000){
            SimHash hash1 = new SimHash(txt1,64);
            SimHash hash2 = new SimHash(txt2,64);
            int d = hash1.hammingDistance(hash2);
             ans = formula.getSimliar(d);
        }
        else {
             ans = CosineSimilarity.getSimilarity(txt1, txt2);
        }
        System.out.println(ans);
        return ans;

    }
}
