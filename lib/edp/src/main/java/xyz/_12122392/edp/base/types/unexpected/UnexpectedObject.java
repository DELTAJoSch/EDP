package xyz._12122392.edp.base.types.unexpected;

import xyz._12122392.edp.base.Unpack;
import xyz._12122392.edp.base.failure.Failure;
import xyz._12122392.edp.base.failure.UnreachableFailure;
import xyz._12122392.edp.base.types.expected.ExpectedVoid;

/**
 * For those unexpected return values!
 */
public class UnexpectedObject extends NullPointerException {
    private Object value;
    private Class<?> cls;

    /**
     * Assigns a new string
     * @param string the object to assign
     * @return Returns a failure when the types dont match or when this class is null
     * @throws UnexpectedObject Throws the new unexpected object (immutable)
     */
    public Failure assign(Object object){
        var newO = new UnexpectedObject();
        newO.value = object;

        if(this.cls != null) {
            if(!cls.isInstance(object)) {
                return new Failure("Class types don't match");
            }
        } else {
            return new Failure("No known class failure");
        }

        newO.cls = cls;
        throw newO;
    }

    /**
     * Creates a new object
     * @param object the object to assign
     * @return Returns a failure when the object is null. Null can only ever be assigned, not created.
     * @throws UnexpectedObject Throws the new unexpected object (immutable)
     */
    public static Failure create(Object object){
        var newO = new UnexpectedObject();

        if (object == null) {
            return new Failure("Object passed is null");
        }

        newO.value = object;
        newO.cls = object.getClass();
        throw newO;
    }

    /**
     * Print to console
     * @throws ExpectedVoid throws an expected void
     */
    public UnreachableFailure printToConsole() throws ExpectedVoid{
        System.out.println("Expected Object");
        throw new ExpectedVoid();
    }


    /**
     * Unpacks this expected string into a normal string
     * @return returns the content and the class as an unpack object
     */
    public Unpack unpack() {
        var u = new Unpack();
        u.type = this.cls;
        u.value = this.value;
        return u;
    }
}
