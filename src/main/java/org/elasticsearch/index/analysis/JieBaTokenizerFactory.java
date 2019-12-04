package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.jieba.analyzer.lucene.JieBaTokenizer;

public class JieBaTokenizerFactory extends AbstractTokenizerFactory {

    public JieBaTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, settings,name);
    }

    @Override
    public Tokenizer create() {
        return new JieBaTokenizer();
    }

}
