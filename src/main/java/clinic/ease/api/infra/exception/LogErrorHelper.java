package clinic.ease.api.infra.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LogErrorHelper {

    @Autowired
    LogErrorRepository logErrorRepository;
    @Transactional
    private void log(String method, String message, String stackTrace) {
        try {
            LogError logError = new LogError();
            logError.setMethod(method);
            logError.setMessage(message);
            logError.setStackTrace(stackTrace);
            logErrorRepository.save(logError);
        } catch (Exception e) {
            e.printStackTrace();
            //this.error("LogErrorHelper.log", e.getMessage(), parseStackTraceToString(e.getStackTrace()[0]));
        }
    }

    public void error(String method, String message, String stackTrace) {
        try {
            this.log(method, message, stackTrace);
        } catch (Exception e){
            this.error("LogErrorHelper.error", e.getMessage(), parseStackTraceToString(e.getStackTrace()[0]));
        }
    }

    public String parseStackTraceToString(StackTraceElement stackTraceElement) {
        return stackTraceElement.toString().substring(0, Math.min(stackTraceElement.toString().length(), 255));
    }

}
