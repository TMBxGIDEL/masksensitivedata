package com.tmbxgidel.masksensitivedata;

import com.tmbxgidel.masksensitivedata.utils.MaskSensitiveDataUtils;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MaskSensitiveDataTest {
    private MaskSensitiveDataUtils maskSensitiveDataUtils;

    @BeforeEach
    void setUp() {
        maskSensitiveDataUtils = MaskSensitiveDataUtils.newInstance(null);
    }


    @Test
    void testFormat() {
        String result = mockAndFormat("SSN: 123-45-6789, Card: 4111-1111-1111-1111, email: test@example.com, Phone: 123-456-7890");
        String expected = "SSN: ***-**-6789, Card: ****-****-****-1111, email: t*****@example.com, Phone: ***-***-7890";
        assertEquals(expected, result);
    }

    @Test
    void testFormatNoSensitiveData() {
        String result = mockAndFormat("No sensitive data here");
        String expected = "No sensitive data here";
        assertEquals(expected, result);
    }

    @Test
    void testFormatPartialSensitiveData() {
        String result = mockAndFormat("SSN: 123-45-6789, No card number, email: test@example.com");
        String expected = "SSN: ***-**-6789, No card number, email: t*****@example.com";
        assertEquals(expected, result);
    }

    private String mockAndFormat(String logMessage) {
        var mockEvent = mock(LogEvent.class);
        var message = Mockito.mock(Message.class);

        when(mockEvent.getMessage()).thenReturn(message);
        when(message.getFormattedMessage()).thenReturn(logMessage);

        StringBuilder output = new StringBuilder();
        maskSensitiveDataUtils.format(mockEvent, output);
        return output.toString();
    }
}
