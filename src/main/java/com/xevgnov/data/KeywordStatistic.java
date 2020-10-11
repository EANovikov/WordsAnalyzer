package com.xevgnov.data;

import java.util.ArrayList;
import java.util.List;

public class KeywordStatistic implements Statistic {

    private int keywordCount;
    private int filesWithKeywordCount;
    private final List<String> keywordsInFiles = new ArrayList<>();

    public int getKeywordCount() {
        return keywordCount;
    }

    public int getFilesWithKeywordCount() {
        return filesWithKeywordCount;
    }

    public List<String> getKeywordsInFiles() {
        return keywordsInFiles;
    }

    public void addFileStatisticRecord(String record) {
        keywordsInFiles.add(record);
    }

    public void addKeywordCount(int count) {
        keywordCount += count;
    }

    public void addOneFileCount() {
        filesWithKeywordCount++;
    }
}
