//PostfixEvaluator.java
import java.util.Scanner;

/**
 * CS226 Homework 1 Task 2
 * @author Joon Hyuck Choi
 * Date: Feb 12, 2015
 * Last edited: 21:22 02/12/15
 * email: jchoi100@jhu.edu
 */
public class PostfixEvaluator {

	/**
	 * This is the driver main method for the PostfixEvaluator class.
	 * @param args the argument that main takes in.
	 */
	public static void main(String[] args) {
		
		/**
		 * Takes in input from the keyboard.
		 */
		Scanner kb = new Scanner(System.in);
		
		String answer = ""; //set as an empty String for now. Sentinel for the do-while loop;
		
		//General instructions;
		System.out.println("This program evaluates postfix expressions which consist");
		System.out.println("of integers and the operators +, -, *, or ./");
		
		do { //keep looping unless the user inputs "n" or "N";
			
			System.out.println("Please enter an expression with spaces between each token: ");
			
			//Take user input
			String expression = kb.nextLine();
			
			//Declare and initialize Integer result to null;
			Integer result = null;
			
			try { //catch any exceptions that evaluate() may throw
				result = evaluate(expression);
				System.out.println("That expression equals " + result + ".");
				System.out.println();
				System.out.print("Evaluate another expression [Y/N]? ");
			} catch(MalformedPostfixExpressionException e) {
				System.out.println("Uh oh. That expression contained a problem.");
				System.out.println(e);
				System.out.println();
				System.out.print("Evaluate another expression [Y/N]? ");
			} //end try-catch()
			
			//Take another input
			answer = kb.nextLine();
			
		} while(!answer.equalsIgnoreCase("N"));
		
		//End program
		System.out.println("Goodbye!");	
		kb.close();
		
	} //end main
	
	/**
	 * Takes in the user input expression and evaluate it.
	 * @param expression the postfix expression that the user input.
	 * @return the resulting value of the postfix expression.
	 */
	public static Integer evaluate(String expression) {
		
		Scanner eqn = new Scanner(expression); //read from the String expression;
		
		//Create a new StackOfIntegersLinkedList instance;
		//StackOfIntegersLinkedList equation = new StackOfIntegersLinkedList();
		StackOfIntegers equation = new StackOfIntegersLinkedList();
		
		while(eqn.hasNext()) { //keep looping while the expression has next inputs to be read;
			
			//Take in the next token from the String;
			String token = eqn.next();
			
			//Declare and initialize the result to 0;
			int result = 0;
			
			//First check if the token is an operator, if not an operand, if not throw exception;
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				
				//To do an operation, there must be at least 2 elements in the list to pop;
				if(equation.size() < 2) {
					throw new MalformedPostfixExpressionException("Operator without sufficient operands.");
				} //end if
				
				//pop() two Integers and save each in a variable;
				Integer pop1 = equation.pop();
				Integer pop2 = equation.pop();
				
				//Perform evaluate according to which operator that was taken in;
				switch(token) {
				case "+": result = pop2 + pop1;
					break;
				case "-": result = pop2 - pop1;
					break;
				case "*": result = pop2 * pop1;
					break;
				case "/": 
					try { //check if the denominator was 0;
						result = pop2 / pop1;
					} catch(ArithmeticException ae) {
						throw new MalformedPostfixExpressionException("Can't divide by 0.");
					} //end try-catch
					break;
				} //end switch
				
				equation.push(result); //push the middle result back to the list;
				
			} else { //not + - * /, then see if the token is a number;				
				try {
					int token1 = Integer.parseInt(token); //try to parse;
					equation.push(token1); //if parsed, push it to the list;
				} catch(NumberFormatException nfe) { //if it's not even a number, then invalid input;
					throw new MalformedPostfixExpressionException("Invalid symbols.");
				} //end try-catch()
				
			} //end if-else (operator? if not number? if not throw exception)

		} //end while
		
		if(equation.size() > 1) { //check if there were enough operators;
			throw new MalformedPostfixExpressionException("Operands without sufficient operators.");
		} //end if
		
		if(equation.size() < 1) { //check if the expression was empty;
			throw new MalformedPostfixExpressionException("Empty expression.");		
		} //end if
		
		return equation.pop(); //return the last element in the list, which is the result;
		
	} //end evaluate()
	
} //end class