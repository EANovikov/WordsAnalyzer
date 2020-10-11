package com.xevgnov.business;

import com.xevgnov.data.Statistic;
import com.xevgnov.util.PropertyOption;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Logger;

import static com.xevgnov.util.PropertyReader.getInstance;

public class FileVisitor extends SimpleFileVisitor<Path> {

    private final Statistic statistic;
    private final static Logger LOGGER = Logger.getLogger(KeywordCounter.class.getName());
    private final static String FILE_EXTENSION = getInstance().getProperty(PropertyOption.FILE_EXTENSION);
    private final static String KEYWORD_VALUE = getInstance().getProperty(PropertyOption.KEYWORD_VALUE);

    public FileVisitor(Statistic statistic) {
        this.statistic = statistic;
    }

    /**
     * visitFile check only regular files with specific extension. Extension is specified in FILE_EXTENSION
     * visitFile check if a file contains specific keyword. Keyword is specified in KEYWORD_VALUE
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (Files.isRegularFile(file) && file.getFileName().toString().endsWith(FILE_EXTENSION)) {
            String content = new String(Files.readAllBytes(file), Charset.defaultCharset());
            int matchesCount = StringUtils.countMatches(content, KEYWORD_VALUE);
            statistic.addFileStatisticRecord(file.getFileName().toString() + " - " + matchesCount);

            if (matchesCount > 0) {
                statistic.addOneFileCount();
                statistic.addKeywordCount(matchesCount);
            }
        }

        return FileVisitResult.CONTINUE;
    }

    /**
     * visitFileFailed skips directories or files which are not accessible.
     * If user provides non-existing path, it will be skipped as well
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) {
        LOGGER.warning("Skipping the path: impossible to access the path: " + file);
        return FileVisitResult.SKIP_SUBTREE;
    }

}
