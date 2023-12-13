import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
  private static SaveFile uniqueInstance;
  private String fileName = "";

  private SaveFile(String fileName) {
    this.fileName = fileName + ".txt";
    createFile();
  }

  public static SaveFile getInstance(String fileName) {
    if (uniqueInstance == null) {
      uniqueInstance = new SaveFile(fileName);
    }
    return uniqueInstance;
  }

  public void createFile() {
    new File(fileName);
  }

  public void saveInfo(String name, int score) {
    try {
      FileWriter fileWriter = new FileWriter(this.fileName);
      fileWriter.write(name + "," + score);
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("Error with writing to file.");
    }
  }
}