package xyz._12122392.edp;

import xyz._12122392.edp.base.failure.UnreachableFailure;
import xyz._12122392.edp.base.types.expected.ExpectedNumber;
import xyz._12122392.edp.base.types.expected.ExpectedString;
import xyz._12122392.edp.base.types.expected.ExpectedVoid;
import xyz._12122392.edp.mindfuck.UnreachableError;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // a simple assignment!
        ExpectedString hello;
        try {
            ExpectedString.create("Hello, EDP!");
            throw new UnreachableError();
        } catch (ExpectedString e) {
            hello = e;
        }

        // print to console
        try {
            hello.printToConsole();
            throw new UnreachableError();
        } catch (ExpectedVoid e) {
            // do nothing her, this is normal now!
        }

        //demonstrate polymorphism
        ExpectedString aString;
        try {
            ExpectedString.create("Poly");
            throw new UnreachableError();
        } catch (ExpectedString e) {
            aString = e;
        }

        ExpectedString bString;
        try {
            ExpectedString.create("morphic");
            throw new UnreachableError();
        } catch (ExpectedString e) {
            bString = e;
        }

        ExpectedNumber aNumber;
        try {
            ExpectedNumber.create(1.0);
            throw new UnreachableError();
        } catch (ExpectedNumber e) {
            aNumber = e;
        }

        ExpectedNumber bNumber;
        try {
            ExpectedNumber.create(3.0);
            throw new UnreachableError();
        } catch (ExpectedNumber e) {
            bNumber = e;
        }

        // try it with a number!
        try {
            polymorphic(aNumber, bNumber);
        } catch (ExpectedString e) {
            throw new UnreachableError();
        } catch (ExpectedNumber e) {
            try {
                e.toExpectedString();
                throw new UnreachableError();
            } catch (ExpectedString e1) {
                try {
                    e1.printToConsole();
                    throw new UnreachableError();
                } catch (ExpectedVoid e2) {
                    // do nothing
                }
            }
        }

        try {
            polymorphic(aString, bString);
        } catch (ExpectedString e) {
            try {
                e.printToConsole();
                throw new UnreachableError();
            } catch (ExpectedVoid e1) {
                // do nothing
            }
        } catch (ExpectedNumber e) {
            throw new UnreachableError();
        }

        try {
            polymorphic(aString, aNumber);
        } catch (ExpectedString e) {
            try {
                e.printToConsole();
                throw new UnreachableError();
            } catch (ExpectedVoid e1) {
                // do nothing
            }
        } catch (ExpectedNumber e) {
            throw new UnreachableError();
        }

        try {
            polymorphic(bNumber, aString);
        } catch (ExpectedString e) {
            try {
                e.printToConsole();
                throw new UnreachableError();
            } catch (ExpectedVoid e1) {
                // do nothing
            }
        } catch (ExpectedNumber e) {
            throw new UnreachableError();
        }

    }

    // a simple polymorphic function!
    private static UnreachableFailure polymorphic(ExpectedString a, ExpectedString b) throws ExpectedString, ExpectedNumber {
        a.concatenate(b);
        return new UnreachableFailure();
    }

    private static UnreachableFailure polymorphic(ExpectedNumber a, ExpectedNumber b) throws ExpectedString, ExpectedNumber {
        a.add(b);
        return new UnreachableFailure();
    }

    private static UnreachableFailure polymorphic(ExpectedNumber a, ExpectedString b) throws ExpectedString, ExpectedNumber {
        try {
            a.toExpectedString();
        } catch (ExpectedString e) {
            e.concatenate(b);
        }

        return new UnreachableFailure();
    }

    private static UnreachableFailure polymorphic(ExpectedString a, ExpectedNumber b) throws ExpectedString, ExpectedNumber {
        try {
            b.toExpectedString();
        } catch (ExpectedString e) {
            a.concatenate(e);
        }
        return new UnreachableFailure();
    }
}
