package by.salei.parser.service;

import by.salei.parser.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class CompositeService {

    private final Composite composite;
    private final String path;
    private final Pattern pattern1 = Pattern.compile("[.!?;]");
    private final Pattern pattern2 = Pattern.compile("[,:'()-]");
    private final Pattern pattern3 = Pattern.compile("[а-яА-Яa-zA-Z]");
    private final Pattern pattern4 = Pattern.compile("\\n");
    private final Pattern pattern5 = Pattern.compile("\\s");
    Logger LOGGER = LoggerFactory.getLogger(CompositeService.class);

    public CompositeService(Composite composite, String filePath) {
        this.composite = composite;
        this.path = filePath;
    }

    public Composite parse(){
        LOGGER.info("SERVICE: parsing text: {}", path);
        try(FileReader fr = new FileReader(path)){
            int c;
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
                    word.add(element);
                }
                if(pattern2.matcher(sb.toString()).matches()){
                    if(!word.getSymbols().isEmpty()){
                        sentence.add(word);
                    }
                    word = new Word();
                    word.add(element);
                    sentence.add(word);
                    word = new Word();
                }
                if(pattern1.matcher(sb.toString()).matches()){
                    word.add(element);
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
                    if(!word.getSymbols().isEmpty()){
                        sentence.add(word);
                        word = new Word();
                    }
                   word.add(element);
                    sentence.add(word);
                    word = new Word();
                }
            }
            composite.add(listing);
        }
        catch (IOException ex){
            LOGGER.warn("SERVICE: Cannot open file to read: {}",path);
        }
        return composite;
    }

    public void writeToFile(Composite composite1){
        LOGGER.info("SERVICE: open file to read: {}", path);
        try(FileWriter fr = new FileWriter("src/main/resources/RestoredText.txt")){
            fr.write(composite1.toString());
        }
        catch (IOException ex){
            LOGGER.warn("SERVICE: Cannot open file to write: {}",path);
        }
    }

}
