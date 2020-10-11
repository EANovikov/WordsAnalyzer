package com.xevgnov.util;

import org.junit.Test;

import static com.xevgnov.util.PropertyReader.getTestInstance;
import static org.assertj.core.api.Assertions.assertThat;

public class PropertyReaderTest {

    @Test
    public void getPropertyReturnsNonNullValueApplicationPropertyTest() {
        String propertyValue = getTestInstance().getProperty(PropertyOption.FILE_EXTENSION);
        assertThat(propertyValue).as("Property cannot be null").isNotNull();
    }

    @Test
    public void getPropertyReturnsNonNullValueTestPropertyTest() {
        String propertyValue = getTestInstance().getProperty(PropertyOption.KEYWORD_VALUE);
        assertThat(propertyValue).as("Property cannot be null").isNotNull();
    }


}