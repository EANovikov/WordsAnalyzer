package com.xevgnov.business;

import com.xevgnov.data.KeywordStatistic;
import com.xevgnov.data.Statistic;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.xevgnov.util.PropertyReader.getTestInstance;
import static org.assertj.core.api.Assertions.assertThat;

public class KeywordCounterTest {

    private KeywordCounter keywordCounter;
    private Statistic statistic;
    private final Path path = Paths.get("src/test/resources");

    @Before
    public void init() {
        getTestInstance();
        statistic = new KeywordStatistic();
        keywordCounter = new KeywordCounter(statistic);
    }

    @Test
    public void countKeywordStatisticsKeywordCountTest() throws IOException {
        keywordCounter.countKeywordStatistics(path);
        assertThat(statistic.getKeywordCount()).as("Incorrect number of keyword occurrences")
                .isEqualTo(1);
    }

    @Test
    public void countKeywordStatisticsFilesWithKeywordCountTest() throws IOException {
        keywordCounter.countKeywordStatistics(path);
        assertThat(statistic.getFilesWithKeywordCount()).as("Incorrect number of files with a keyword")
                .isEqualTo(1);
    }

    @Test
    public void countKeywordStatisticsKeywordsInFilesTest() throws IOException {
        keywordCounter.countKeywordStatistics(path);
        assertThat(statistic.getKeywordsInFiles()).as("Incorrect records")
                .containsExactlyInAnyOrder("test1.txt - 0", "test2.txt - 1");
    }
}