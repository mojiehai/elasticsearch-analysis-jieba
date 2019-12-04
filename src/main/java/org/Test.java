package org;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.jieba.analyzer.lucene.JieBaAnalyzer;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            JieBaAnalyzer analyzer = new JieBaAnalyzer();
            TokenStream ts = analyzer.tokenStream("text", "我爱北京天安门");
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            ts.reset();
            while (ts.incrementToken()) {
                System.out.println(term.toString());
            }
            ts.end();
            ts.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
