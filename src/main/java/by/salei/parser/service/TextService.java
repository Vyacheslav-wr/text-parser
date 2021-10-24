package by.salei.parser.service;

import by.salei.parser.model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class TextService {

    private final Composite composite;
    private final String path;
    private final Pattern pattern1 = Pattern.compile("[.!?;]");
    private final Pattern pattern2 = Pattern.compile("[,:'()-]");
    private final Pattern pattern3 = Pattern.compile("[а-яА-Яa-zA-Z]");
    private final Pattern pattern4 = Pattern.compile("\\n");
    private final Pattern pattern5 = Pattern.compile("\\s");

    public TextService(Composite composite, String filePath) {
        this.composite = composite;
        this.path = filePath;
    }

    public Composite parse(){
        try(FileReader fr = new FileReader(path)){
            int c;
            Symbol symbol = new Symbol();
            Word word = new Word();
            Sentence sentence = new Sentence();
            Listing listing = new Listing();
            char element;
            StringBuffer sb;

            while((c=fr.read())!=-1){
                sb = new StringBuffer();
                element = (char)c;
                sb.append(element);
                if(pattern3.matcher(sb.toString()).matches()){
                    symbol = new Symbol(element);
                    symbol.setPunctuationMark(false);
                    word.add(symbol);
                }
                if(pattern2.matcher(sb.toString()).matches()){
                    sentence.add(word);
                    symbol = new Symbol(element);
                    symbol.setPunctuationMark(true);
                    word = new Word();
                    word.add(symbol);
                    sentence.add(word);
                    word = new Word();
                }
                if(pattern1.matcher(sb.toString()).matches()){
                    symbol = new Symbol(element);
                    symbol.setPunctuationMark(true);
                    word.add(symbol);
                    sentence.add(word);
                    listing.add(sentence);
                    sentence = new Sentence();
                    word = new Word();
                }
                if(pattern5.matcher(sb.toString()).matches()){
                    if(!word.getSymbols().isEmpty()){
                    sentence.add(word);
                    word = new Word();
                    }
                }
                if(pattern4.matcher(sb.toString()).matches()){
                    symbol = new Symbol(element);
                    if(!word.getSymbols().isEmpty()){
                        sentence.add(word);
                        word = new Word();
                    }
                   word.add(symbol);
                    sentence.add(word);
                    word = new Word();
                    symbol = new Symbol();
                }
            }
            composite.add(listing);
        }
        catch (IOException ex){

        }
        return composite;
    }

    public void writeToFile(Composite composite1){
        try(FileWriter fr = new FileWriter("src/main/resources/RestoredText.txt")){
            fr.write(composite.toString());
        }
        catch (IOException ex){

        }
    }

}
