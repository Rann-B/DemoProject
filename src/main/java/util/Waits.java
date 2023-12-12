package util;

import lombok.extern.slf4j.Slf4j;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

@Slf4j
public final class Waits {

    private Waits() {
    }

    public static void waitForPageLoading(final long timeoutSeconds) {
        try {
            sleep(timeoutSeconds * 1000);
        } catch (InterruptedException e) {
            log.warn("Wait for system loading was interrupted by: {}", e.getMessage());
            if (e.getCause() != null) {
                log.warn(format("The cause of interruptions is: %s", e.getCause().getMessage()));
            }
            currentThread().interrupt();
        }
    }
}
