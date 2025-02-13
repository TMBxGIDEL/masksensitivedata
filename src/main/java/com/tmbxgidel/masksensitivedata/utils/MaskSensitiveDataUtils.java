package com.tmbxgidel.masksensitivedata.utils;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.util.regex.Pattern;

@Plugin(name = "MaskSensitiveDataUtils", category = PatternConverter.CATEGORY)  // Log4j2 plugin annotation
@ConverterKeys({"spi"})
public class MaskSensitiveDataUtils extends LogEventPatternConverter {
    private static final String Name = "spi";

    private final String CARD_NUMBER_MASK = "****-****-****$2";
    private final String SSN_MASK = "***-**$2";
    private final String EMAIL_MASK = "$1*****$3";
    private final String PHONE_NUMBER_MASK = "***-***$2";

    // Regex patterns for automatic masking
    private static final Pattern CARD_NUMBER_PATTERN = Pattern.compile("\\b((?<![:\\.])\\d{4}[ -]?\\d{4}[ -]?\\d{4})([ -]?\\d{4}(?!-))\\b");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\b((?<![:\\.])\\d{3}-\\d{3})(-?\\d{4}(?!-))\\b");
    private static final Pattern SSN_PATTERN = Pattern.compile("\\b((?<![:\\.])\\d{3}-\\d{2})(-?\\d{4}(?!-))\\b");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b((?<![:\\.])[A-Za-z0-9._%+-])([A-Za-z0-9._%+-]*)(@[A-Za-z0-9.-]+\\.[A-Z]{2,6})\\b", Pattern.CASE_INSENSITIVE);

    private static final boolean MASKING_ENABLED = PropertiesUtil.getProperties().getBooleanProperty("logging.maskSensitiveData", true);

    protected MaskSensitiveDataUtils(String name, String  threadName) {
        super(name, threadName);
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        String message = event.getMessage().getFormattedMessage();
        if (MASKING_ENABLED) {
            message = SSN_PATTERN.matcher(message).replaceAll(SSN_MASK);
            message = CARD_NUMBER_PATTERN.matcher(message).replaceAll(CARD_NUMBER_MASK);
            message = EMAIL_PATTERN.matcher(message).replaceAll(EMAIL_MASK);
            message = PHONE_NUMBER_PATTERN.matcher(message).replaceAll(PHONE_NUMBER_MASK);
        }
        toAppendTo.append(message);
    }

    public static MaskSensitiveDataUtils newInstance(final String[] options) {
        return new MaskSensitiveDataUtils(Name, Thread.currentThread().getName());
    }
}
