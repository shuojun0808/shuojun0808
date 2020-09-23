/*
主函数
等待传参进入
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double ans = Unit.ans(args[0], args[1]);
        String anstxt=args[2];
        File f=new File(anstxt);
        try{
            if(!f.exists()){
                f.createNewFile();
            }
            FileWriter fw=new FileWriter(f);
            fw.write("");
            fw.flush();
            fw.write(String.valueOf(ans));
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
