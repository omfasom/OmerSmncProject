package Common;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Logger {

    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Logger.class);

    public Logger() {
    }

    @Step("INFO: {0}")
    public static void logInfo(String message) {
      if (null != message) {
        Reporter.log("INFO: " + message);
        log.info(message);
      }
    }

    @Step("WARN: {0}")
    public static void logWarn(String message) {
      if (null != message) {
        Reporter.log("WARN: " + message);
        log.warn(message);
      }
    }

    @Step("ERROR: {0}")
    public static void logError(String message) {
      if (null != message) {
        Reporter.log("ERROR: " + message);
        log.error(message);
      }
    }

    @Step("TRACE: {0}")
    public static void logTrace(StackTraceElement trace) {
      if (null != trace) {
        Reporter.log("TRACE:\n" + trace);
        log.trace(trace);
      }
    }

    @Attachment("request body :")
    public static String logRequest(String message) {
      return null == message ? "null request" : message;
    }


}
