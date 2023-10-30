package xyz._12122392.edp.base.failure;

/**
 * A generic failure
 */
public class Failure {
    private Failure cause;
    private String reason;
    private StackTraceElement[] stacktrace;
    
    public Failure() {
        Thread thread = Thread.currentThread();
        this.stacktrace = thread.getStackTrace();
    }

    /**
     * A generic failure
     * @param reason The reason or message of the failure
     */
    public Failure(String reason) {
        this.reason = reason;

        Thread thread = Thread.currentThread();
        this.stacktrace = thread.getStackTrace();
    }

    /**
     * A generic failure
     * @param reason the reason or message of the failure
     * @param cause Another failure that caused this failure
     */
    public Failure(String reason, Failure cause) {
        this.reason = reason;
        this.cause = cause;

        Thread thread = Thread.currentThread();
        this.stacktrace = thread.getStackTrace();
    }

    /**
     * Get the stacktrace
     * @return Returns an array of stacktraceelements
     */
    public StackTraceElement[] getStackTrace() {
        return this.stacktrace;
    }

    @Override
    public boolean equals(Object object) {
        if(object.getClass() != this.getClass()) {
            return false;
        }

        var cast = (Failure) object;
        boolean isEqual = true;

        if(cast.cause != null) {
            isEqual = isEqual && cast.cause.equals(this.cause);
        } else if(this.cause != null){
            return false;
        }

        if(cast.reason != null){
            isEqual = isEqual && cast.reason.equals(this.reason);
        } else if(this.reason != null){
            return false;
        }

        if(cast.stacktrace != null){
            isEqual = isEqual && cast.stacktrace.equals(this.stacktrace);
        } else if(this.stacktrace != null){
            return false;
        }

        return isEqual;
    }

    /**
     * Get the failure reason or message
     * @return Returns the failure message
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Get the cause of the failure
     * @return Returns the failure that caused this failure.
     */
    public Failure getCause() {
        return this.cause;
    }

    @Override
    public String toString() {
        String print = "";

        if(this.reason != null) {
            print += this.reason;
        }else {
            print += "Unknown Failure: ";
        }

        if(this.stacktrace != null) {
            for (int i = 0; i < stacktrace.length; i++) {
                print += "\n" + stacktrace[i].toString();
            }
        }

        return print;
    }
}
