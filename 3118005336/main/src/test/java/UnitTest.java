import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class UnitTest {

    /**
     * 测试给出的示例原本
     */
    @Test
    public void simTest() throws IOException {
        File folder = new File("src/main/resources/test");
        File[] files = folder.listFiles();
        for(File file:files){
            if(file == files[0]){
                continue;
            }
            System.out.println("文本" + files[0].getName()+" 和文本 " + file.getName() + "的相似度：");
            Unit.ans(files[0].getPath(),file.getPath());
            System.out.println("-----------------------------");
        }
    }

    /**
     * 使用余弦相似度算法
     */
    @Test
    public void CosTest() throws IOException {
        File folder = new File("src/main/resources/test");
        File[] files = folder.listFiles();
        for(File file:files){
            if(file == files[0]){
                continue;
            }
            System.out.println("文本" + files[0].getName()+" 和该文本 " + file.getName() + "的相似度：");
            Unit.ans(files[0].getPath(),file.getPath());
            System.out.println("-----------------------------");
        }
    }

    /**
     * 空文本比较
     */
    @Test
    public void esTest1() throws IOException {
        Unit.ans("src/main/resources/test/orig.txt","src/main/resources/blank.txt");
    }

}
