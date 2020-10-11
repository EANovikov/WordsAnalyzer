package com.xevgnov.data;

import java.util.List;

public interface Statistic {

    int getKeywordCount();

    int getFilesWithKeywordCount();

    List<String> getKeywordsInFiles();

    void addFileStatisticRecord(String record);

    void addKeywordCount(int count);

    void addOneFileCount();

}
