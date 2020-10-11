package com.xevgnov.business;

import com.xevgnov.data.Statistic;

public class KeywordPrinter {

    private final Statistic statistic;

    public KeywordPrinter(Statistic statistic) {
        this.statistic = statistic;
    }

    public void printKeywordStatistic() {
        printTotalKeywordOccurrenceNumber();
        printNumberOfFilesContainingKeyword();
        printFullTargetFileStatistic();
    }

    private void printTotalKeywordOccurrenceNumber() {
        System.out.println("Total number of the keyword: " + statistic.getKeywordCount());
    }

    private void printNumberOfFilesContainingKeyword() {
        System.out.println("Number of files which contain the keyword: " + statistic.getFilesWithKeywordCount());
    }

    private void printFullTargetFileStatistic() {
        System.out.println("The complete list of files with the keyword occurrences:");
        statistic.getKeywordsInFiles().forEach(System.out::println);
    }
}
