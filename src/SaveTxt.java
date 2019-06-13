import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTxt {

    public static void main(String[] args){

    }
}

class saveFileTxt{

    String text = "This is file txt.";

    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("plik.txt"));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
