package xyz._12122392.edp.base.types.expected;

import xyz._12122392.edp.base.failure.UnreachableFailure;

public class ExpectedString extends ExpectedObject{
    private String string;

    /**
     * Assigns a new string
     * @param string the string literal to assing
     * @throws ExpectedString Throws the new expected string (immutable)
     */
    public UnreachableFailure assign(String string) throws ExpectedString{
        var newS = new ExpectedString();
        newS.string = string;
        throw newS;
    }

    /**
     * Creates a new string
     * @param string the string literal to assing
     * @throws ExpectedString Throws the new expected string (immutable)
     */
    public static UnreachableFailure create(String string) throws ExpectedString{
        var newS = new ExpectedString();
        newS.string = string;
        throw newS;
    }

    /**
     * Concatenate two strings
     * @param string the string to concatenate
     * @throws ExpectedString throws the concatenated string
     */
    public UnreachableFailure concatenate(ExpectedString string) throws ExpectedString{
        var newS = new ExpectedString();
        newS.string = this.string;

        if(string != null) {
            newS.string += string.string;
        }

        throw newS;
    }

    /**
     * Returns true, if two strings are equal
     * @param string The string to compare
     * @throws ExpectedObject the expected boolean result
     */
    public UnreachableFailure isEqual(ExpectedString string) throws ExpectedObject{
        if(this.string.equals(string.string)) {

        }
        throw new ExpectedObject();
    }

    @Override
    public UnreachableFailure printToConsole() throws ExpectedVoid {
        System.out.println(this.string);
        throw new ExpectedVoid();
    }

    /**
     * Read a new expected string from the console
     * @throws ExpectedString the read string is thrown
     */
    public UnreachableFailure readFromConsole() throws ExpectedString {
        System.out.println(this.string);
        var newS = new ExpectedString();
        newS.string = System.console().readLine();
        throw newS;
    }

    /**
     * Unpacks this expected string into a normal string
     * @return returns the content
     */
    public String unpackString() {
        return this.string;
    }
}
