package org.jieba.analyzer.lucene;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;
import java.util.LinkedList;

public class JieBaTokenizer extends Tokenizer {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private boolean isCat = false;
    private LinkedList<SegToken> words = new LinkedList<>();

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();

        JiebaSegmenter segmenter = new JiebaSegmenter();
        int ci;

        if (!isCat) {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                ci = input.read();
                if (ci == -1) {
                    break;
                } else {
                    stringBuilder.append((char) ci);
                }
            }
            words = new LinkedList<>(segmenter.process(stringBuilder.toString(), JiebaSegmenter.SegMode.INDEX));
            isCat = true;
        }

        if (!words.isEmpty()) {
            SegToken segToken = words.pop();
            termAtt.append(segToken.word);
            offsetAtt.setOffset(segToken.startOffset, segToken.endOffset);
            return true;
        } else {
            return false;
        }

    }

}
