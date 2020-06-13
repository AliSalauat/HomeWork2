import java.io.*;

public class m {
    public static void main(String[] args) throws IOException {
        File file1 = new File("src/input.txt");
        File file2 = new File("src/outtext.txt");



        ////////////////////////////////////////////////////////////////////////////////////////////////
        FileInputStream fileStream = new FileInputStream(file1);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        String line;

        // Initializing counters
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int paragraphCount = 1;
        int whitespaceCount = 0;


        while((line = reader.readLine()) != null)
        {
            if(line.equals(""))
            {
                paragraphCount++;
            } else {
                characterCount += line.length();

                // \\s+ is the space delimiter in java
                String[] wordList = line.split("\\s+");

                countWord += wordList.length;
                whitespaceCount += countWord -1;

                // [!?.:]+ is the sentence delimiter in java
                String[] sentenceList = line.split("[!?.:]+");

                sentenceCount += sentenceList.length;
            }
        }

        System.out.println("Total word count = " + countWord);
        System.out.println("Total number of sentences = " + sentenceCount);
        System.out.println("Total number of characters = " + characterCount);
        System.out.println("Number of paragraphs = " + paragraphCount);
        System.out.println("Total number of whitespaces = " + whitespaceCount);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        BufferedReader in = (new BufferedReader(new FileReader(file1)));
        PrintWriter out = (new PrintWriter(new FileWriter(file2)));
        int ch;
        while ((ch = in.read()) != -1) {
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);// convert assign variable
            }
            out.write(ch);
        }
        in.close();
        out.close();
    }
}