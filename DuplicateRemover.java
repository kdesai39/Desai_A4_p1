import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException {
       String word;
       uniqueWords = new HashSet<String>();
        Scanner sc = new Scanner(new File(dataFile));
        while(sc.hasNext()){
            word = sc.next();
            uniqueWords.add(word);
        }
        sc.close();
    }

    public void Write(String outputFile) throws IOException{
        File f;
        FileWriter fW;
        f = new File(outputFile);
        if(f.exists()){
            fW = new FileWriter(f, true);
            Iterator itr = uniqueWords.iterator();
            while(itr.hasNext()){
                String str = (String)itr.next();
                fW.write(str+"\n");
            }
            fW.close();
            System.out.println("Data Written to File");
        }
        else{
            f.createNewFile();
            fW = new FileWriter(f);
            Iterator itr = uniqueWords.iterator();
            while(itr.hasNext()){
                String str = (String)itr.next();
                fW.write(str+"\n");
            }
            fW.close();
            System.out.println("Data Written to File");
        }
    }
}
