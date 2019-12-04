package org.elasticsearch.plugin.analysis.jieba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.JieBaAnalyzerProvider;
import org.elasticsearch.index.analysis.JieBaTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class JieBaPlugin extends Plugin implements AnalysisPlugin {

    public static String PLUGIN_NAME = "analysis-jieba";

    private final static Logger LOGGER = LogManager.getLogger(JieBaPlugin.class);

    public JieBaPlugin() {
        super();
        LOGGER.info("{} installed into elasticsearch", PLUGIN_NAME);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return Collections.singletonMap("cut_all", JieBaTokenizerFactory::new);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("cut_all", JieBaAnalyzerProvider::new);
    }
}
