package com.xevgnov;

import com.xevgnov.business.KeywordCounter;
import com.xevgnov.business.KeywordPrinter;
import com.xevgnov.business.PathReader;
import com.xevgnov.data.KeywordStatistic;
import com.xevgnov.data.Statistic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class WordInFilesAnalyzerApplication {

    private final static Logger LOGGER = Logger.getLogger(WordInFilesAnalyzerApplication.class.getName());

    public static void main(String[] args) throws IOException {
        LOGGER.info("Ok, collecting the target directory");
        PathReader pathReader = new PathReader();
        Path path = pathReader.readPath(args);
        LOGGER.info("Ok, starting to analyze the directory content");
        Statistic keywordStatistic = new KeywordStatistic();
        KeywordCounter keywordCounter = new KeywordCounter(keywordStatistic);
        keywordCounter.countKeywordStatistics(path);
        LOGGER.info("Ok, printing the results");
        KeywordPrinter keywordPrinter = new KeywordPrinter(keywordStatistic);
        keywordPrinter.printKeywordStatistic();
        LOGGER.info("Ok, analysis has been successfully completed!");
    }
}
