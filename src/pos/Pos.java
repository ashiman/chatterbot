/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.process.ListProcessor;
import edu.stanford.nlp.tagger.common.Tagger;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author astha
 */
public class Pos extends Tagger
implements ListProcessor<List<? extends HasWord>,List<TaggedWord>>, Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaxentTagger tagger = new MaxentTagger("C:\\Users\\astha\\Documents\\NetBeansProjects\\pos\\taggers/english-left3words-distsim.tagger");
        // The sample string
        String sample = "What common extra facilities in banasthali?";
 
        // The tagged string
        String tagged = tagger.tagString(sample);

        // Output the result
        System.out.println(tagged);
        int index=tagged.indexOf("_NN");
        System.out.println(index);
        int temp,i;
        StringBuffer noun_word=new StringBuffer();
        for(i=index;tagged.charAt(i)!=' ';i--)
     {     
             
       }
        temp= i; // a temporary variable to store the changed values of i;
        
        for(i=temp;i<index;i++)
        {   
             noun_word.append(tagged.charAt(i));
        }
        System.out.println(noun_word);
    }

    @Override
    public List<TaggedWord> apply(List<? extends HasWord> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<TaggedWord>> process(List<? extends List<? extends HasWord>> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
