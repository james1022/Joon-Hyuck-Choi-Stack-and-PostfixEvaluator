//MalformedPostfixExpressionException

/**
 * CS226 Homework 1
 * @author Joon Hyuck Choi
 * Date: Feb 11, 2015
 * Last edited: 16:38 02/11/15
 * email: jchoi100@jhu.edu
 */
public class MalformedPostfixExpressionException extends RuntimeException {

	public MalformedPostfixExpressionException() {
		super("***MalformedPostfixExpressionException***");
	} //end constructor1

	public MalformedPostfixExpressionException(String message) {
		super(message);  //calls RuntimeException's constructor
	} //end constructor2
	
} //end MalformedPostfixExpressionException
