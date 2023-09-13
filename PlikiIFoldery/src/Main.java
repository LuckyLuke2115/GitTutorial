import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        try
        {

            Writer writer = new FileWriter("sampleNotepadFile.txt");
            writer.write("Dupa cycki");
            writer.close();

            File sampleDir = new File("Sample directory");
            sampleDir.mkdir();

            File sampleDirs = new File("Test directory 1" + File.separator + "Test Dir 2" + File.separator + "Test Dir 3");
            sampleDirs.mkdirs();

            File sampleFile2 = new File("Test directory 1" + File.separator + "Test Dir 2" + File.separator + "Test Dir 3", "sampleNotepadFile2.txt");
            if (!sampleFile2.exists())
                sampleFile2.createNewFile();

            System.out.println("_______________________");
            System.out.println("Can You checks for the files and folders");
            System.out.println("_______________________");
            System.out.println();
            System.out.println("Can you write? " + sampleFile2.canWrite());
            System.out.println("Can you read? " + sampleFile2.canRead());
            System.out.println("Can you execute it? " + sampleFile2.canExecute());
            System.out.println("Is file? " + sampleFile2.isFile());
            System.out.println("Is directory? " + sampleDir.isDirectory());
            System.out.println("Last modified: " + new Date(sampleFile2.lastModified()));
            System.out.println("How many characters? " + sampleFile2.length());
            System.out.println("_______________________");
            Main.ReadPath(new File(System.getProperty("user.dir")));

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void ReadPath(File pathName)
    {
        String[] files = pathName.list();
        for (int i = 0; i < files.length; i++)
        {
            File p = new File(pathName.getPath(), files[i]);

            if (p.isDirectory()) // zmieniając na isFile znajdzie wszystkie pliki
            {
                ReadPath(new File(p.getPath()));
            }
            System.out.println(p.getPath());
        } // ^ znajduje wszystkie pliki i foldery, łącznie z podfolderami
    }
}