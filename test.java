import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @ParameterizedTest
    @CsvSource({
            "3600, 1:00:00",
            "3661, 1:01:01",
            "0, 0:00:00",
            "-1, -1",
            "32000, -1",
            "7200, 2:00:00",
            "120, 0:02:00",
            "3665, 1:01:05",
            "18000, 5:00:00"
    })
    void testSecToTime(int seconds, String expectedTime) {
        assertEquals(expectedTime, TimeUtils.secToTime(seconds));
    }

    @Test
    void testSecToTimeEdgeCase() {
        assertEquals("-1", TimeUtils.secToTime(-100));
        assertEquals("-1", TimeUtils.secToTime(32001));
    }
}
