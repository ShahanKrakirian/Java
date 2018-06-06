package com.shahan.calculator;

public class Calculator implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //What is this? STS suggested I add it...
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double answer;
	
	public Calculator() {}

	//Getters/Setters
	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	};
	
	public double getAnswer() {
		return answer;
	}

	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
	public double getResults() {
		return answer;
	}

	public void performOperation() {
		double operand1 = this.getOperandOne();
		double operand2 = this.getOperandTwo();
		String operation = this.getOperation();
		if (operation == "+") {
			setAnswer(operand1 + operand2);
		}
		else if (operation == "-") {
			setAnswer(operand1 - operand2);
		}
		else {
			System.out.println("Well this is awkward... enter a correct operation.");
		}
		
	}
}
