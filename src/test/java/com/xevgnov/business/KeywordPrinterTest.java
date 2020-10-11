package com.xevgnov.business;

import com.xevgnov.data.KeywordStatistic;
import com.xevgnov.data.Statistic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class KeywordPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private KeywordPrinter keywordPrinter;
    private Statistic statistic;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printKeywordStatisticEmptyDataTest() {
        statistic = new KeywordStatistic();
        keywordPrinter = new KeywordPrinter(statistic);

        keywordPrinter.printKeywordStatistic();
        assertThat(outContent.toString()).as("Statistics print issue")
                .contains("Total number of the keyword: 0")
                .contains("Number of files which contain the keyword: 0")
                .contains("The complete list of files with the keyword occurrences:");
    }

    @Test
    public void printKeywordStatisticValidDataTest() {
        statistic = Mockito.mock(KeywordStatistic.class);
        List<String> records = Arrays.asList("test1.txt - 1", "test2.txt - 0");
        when(statistic.getKeywordsInFiles()).thenReturn(records);
        when(statistic.getFilesWithKeywordCount()).thenReturn(1);
        when(statistic.getKeywordCount()).thenReturn(1);
        keywordPrinter = new KeywordPrinter(statistic);
        keywordPrinter.printKeywordStatistic();

        assertThat(outContent.toString()).as("Statistics print issue")
                .contains("Total number of the keyword: 1")
                .contains("Number of files which contain the keyword: 1")
                .contains("The complete list of files with the keyword occurrences:")
                .contains("test1.txt - 1")
                .contains("test2.txt - 0");
    }

}