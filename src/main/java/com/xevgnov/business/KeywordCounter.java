package com.xevgnov.business;

import com.xevgnov.data.Statistic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class KeywordCounter {

    private final Statistic statistic;

    public KeywordCounter(Statistic statistic) {
        this.statistic = statistic;
    }

    public void countKeywordStatistics(Path file) throws IOException {
        Files.walkFileTree(file, new FileVisitor(statistic));
    }
}
