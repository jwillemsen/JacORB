package org.jacorb.notification.node;

/**
 * StaticTypeChecker.java
 *
 *
 * Created: Sat Jul 06 18:27:41 2002
 *
 * @author <a href="mailto:bendt@inf.fu-berlin.de">Alphonse Bendt</a>
 * @version
 */
import org.omg.CORBA.TCKind;

public class StaticTypeChecker extends TCLVisitor implements TCLTokenTypes {

    public void check(TCLNode rootNode) throws StaticTypeException {
	try {
	    rootNode.acceptPostOrder(this);
	} catch (VisitorException e) {
	    throw new StaticTypeException(e.getMessage());
	}
    }

    static void debug(String msg) {
	System.err.println("[StaticTypeChecker] " + msg);
    }

    static void checkBinaryNumaryOperatorNode(TCLNode node)
	throws StaticTypeException {

	if (node.isStatic()) {
	    if (node.left().isNumber() && node.right().isNumber()) {
		return;
	    }
	    throw new StaticTypeException("num or float or identifier (or bool) excepted)");
	} else {
	    return;
	}
    }

    static void checkCMPNode(TCLNode node) throws StaticTypeException {



// 	if (_leftKind.equals(TCKind.tk_boolean) &&
// 	    _rightKind.equals(TCKind.tk_boolean)) {
// 	    return;
// 	}

// 	if (_leftKind.equals(TCKind.tk_string) &&
// 	    _rightKind.equals(TCKind.tk_string)) {
// 	    return;
// 	}

// 	if ((_leftKind.equals(TCKind.tk_float) ||
// 	     _leftKind.equals(TCKind.tk_long) ||
// 	     _leftKind.equals(TCKind.tk_boolean))
// 	    &&
// 	    (_rightKind.equals(TCKind.tk_float) ||
// 	     _rightKind.equals(TCKind.tk_long) ||
// 	     _rightKind.equals(TCKind.tk_boolean))) {
// 	    return;
// 	}

// 	throw new StaticTypeException("incompatible operands");
    }

    public void visitGt(GtOperator n) throws VisitorException {
	checkCMPNode(n);
    }

    public void visitPlus(PlusOperator n) throws VisitorException {
	checkBinaryNumaryOperatorNode(n);
    }

    public void visitMinus(MinusOperator node) throws VisitorException {
	checkBinaryNumaryOperatorNode(node);
    }

    public void visitDiv(DivOperator node) throws VisitorException {
	checkBinaryNumaryOperatorNode(node);
    }

    public void visitMult(MultOperator node) throws VisitorException {
	checkBinaryNumaryOperatorNode(node);
    }

    public void visitSubstr(SubstrOperator node) throws VisitorException {

	if (node.isStatic()) {
	    if (node.left().isString() && node.right().isString()) {
		return;
	    }
	    throw new StaticTypeException("~ Operator expects 2 Strings");
	}
    }

    public void visitAnd(AndOperator and) throws VisitorException {
	if (and.isStatic()) {
	    if (and.left().isBoolean() && and.right().isBoolean()) {
		return;
	    }
	    throw new StaticTypeException("bool value expected");
	}
    }

}// StaticTypeChecker
