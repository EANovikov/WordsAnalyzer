package com.xevgnov.data;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KeywordStatisticTest {

    private Statistic keywordStatistic;

    @Before
    public void init() {
        keywordStatistic = new KeywordStatistic();
    }

    @Test
    public void addFileStatisticRecordShouldAddOneRecord() {
        keywordStatistic.addFileStatisticRecord("test 1");
        List<String> records = keywordStatistic.getKeywordsInFiles();
        assertThat(records).as("Wrong number of records").containsExactly("test 1");
    }

    @Test
    public void addKeywordCountShouldIncreaseKeywordCount() {
        int countBefore = keywordStatistic.getKeywordCount();
        keywordStatistic.addKeywordCount(1);
        int countAfter = keywordStatistic.getKeywordCount();
        assertThat(countAfter).as("Wrong keyword counter").isEqualTo(countBefore + 1);
    }

    @Test
    public void addOneFileCount() {
        int countBefore = keywordStatistic.getFilesWithKeywordCount();
        keywordStatistic.addOneFileCount();
        int countAfter = keywordStatistic.getFilesWithKeywordCount();
        assertThat(countAfter).as("Wrong keyword counter").isEqualTo(countBefore + 1);
    }
}