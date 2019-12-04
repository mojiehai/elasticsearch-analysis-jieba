package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.jieba.analyzer.lucene.JieBaAnalyzer;

public class JieBaAnalyzerProvider extends AbstractIndexAnalyzerProvider {

    private final JieBaAnalyzer jieBaAnalyzer;

    public JieBaAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        this.jieBaAnalyzer = new JieBaAnalyzer();
    }

    @Override
    public Analyzer get() {
        return jieBaAnalyzer;
    }

}
