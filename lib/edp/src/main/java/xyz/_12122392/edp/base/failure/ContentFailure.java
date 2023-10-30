package xyz._12122392.edp.base.failure;

public class ContentFailure<T> extends Failure {
    T content;

    public ContentFailure() {
        super();
    }

    /**
     * A generic failure
     * @param reason The reason or message of the failure
     * @param content The content of this failure
     */
    public ContentFailure(String reason) {
        super(reason);
    }

    public ContentFailure(T content) {
        super();
        this.content = content;
    }

    /**
     * A generic failure
     * @param reason The reason or message of the failure
     * @param content The content of this failure
     */
    public ContentFailure(String reason, T content) {
        super(reason);
        this.content = content;
    }

    /**
     * A generic failure
     * @param reason the reason or message of the failure
     * @param cause Another failure that caused this failure
     */
    public ContentFailure(String reason, Failure cause) {
        super(reason, cause);
    }

    /**
     * A generic failure
     * @param reason the reason or message of the failure
     * @param cause Another failure that caused this failure
     * @param content The content of this failure
     */
    public ContentFailure(String reason, Failure cause, T content) {
        super(reason, cause);
        this.content = content;
    }

    
    public Failure getContent() {
        return null;
    }
}
