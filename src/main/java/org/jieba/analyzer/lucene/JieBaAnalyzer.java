package org.jieba.analyzer.lucene;

import org.apache.lucene.analysis.Analyzer;

public class JieBaAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String s) {
        return new TokenStreamComponents(new JieBaTokenizer());
    }

}
