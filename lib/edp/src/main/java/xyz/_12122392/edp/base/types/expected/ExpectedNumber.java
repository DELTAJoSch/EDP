package xyz._12122392.edp.base.types.expected;

import xyz._12122392.edp.base.failure.Failure;
import xyz._12122392.edp.base.failure.UnreachableFailure;

/**
 * An expected number. Double precision.
 */
public class ExpectedNumber extends ExpectedObject{
    private Double value;

    @Override
    public UnreachableFailure printToConsole() throws ExpectedVoid {
        System.out.println(this.value);
        throw new ExpectedVoid();
    }

    /**
     * Parse an expectedString to an ExpectedDouble
     * @param string the ExpectedString to parse
     * @return Returns a failure if the ExpectedString is not a parseable ExpectedDouble
     * @throws ExpectedNumber The thrown ExpectedNumber
     */
    public Failure fromString(ExpectedString string) throws ExpectedNumber {
        var newN = new ExpectedNumber();

        var content = string.unpackString();
        if(content != null) {
            try {
                var value = Double.parseDouble(content);
                newN.value = value;
            } catch (NumberFormatException e) {
                return new Failure("Could not parse ExpectedString to ExpectedDouble");
            }
        }

        throw newN;
    }

    /**
     * Parse to an expectedString from an ExpectedDouble
     * @throws ExpectedNumber The thrown ExpectedString
     */
    public UnreachableFailure toExpectedString() throws ExpectedString {
        if(this.value != null){
            try {
                ExpectedString.create(this.value.toString());
            } catch (ExpectedString e) {
                throw e;
            }
        }else {
            try {
                ExpectedString.create("null");
            } catch (ExpectedString e) {
                throw e;
            }
        }

        return new UnreachableFailure();
    }

    public static UnreachableFailure create(Double d) throws ExpectedNumber {
        var newN = new ExpectedNumber();
        newN.value = d;
        throw newN;
    }

    public UnreachableFailure assign(Double d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = d;
        throw newN;
    }

    public UnreachableFailure add(ExpectedNumber d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = this.value + d.value;
        throw newN;
    }

    public UnreachableFailure sub(ExpectedNumber d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = this.value - d.value;
        throw newN;
    }

    public UnreachableFailure mul(ExpectedNumber d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = this.value * d.value;
        throw newN;
    }

    public UnreachableFailure div(ExpectedNumber d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = this.value / d.value;
        throw newN;
    }

    public UnreachableFailure pow(ExpectedNumber d) throws ExpectedNumber{
        var newN = new ExpectedNumber();
        newN.value = Math.pow(this.value, d.value);
        throw newN;
    }
}
