package com.varxyz.jv250.banking;

public class CheckingAccount2 extends Account {
	private double overdraftAmount;
	
	public CheckingAccount2() {
		super();
	}
	
	public void withdraw(double amount) { // 마이너스 통장
		if(balance < amount) {
			//잔고 부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			if(overdraftAmount + balance >= amount) {
				System.out.println("출금 전 금액:" + balance+"원");
				overdraftAmount += balance;
				overdraftAmount -= amount;
				System.out.println("CheckingAccount에 "+amount+"원 출금 후 남은 한도: " + overdraftAmount+"원\n");
			}else {
				// 예외발생
				System.err.println("현재 남은 한도: " + overdraftAmount);
				throw new InsufficientException("한도 부족");
			}
		}else {
			System.out.println("출금 전 금액:" + balance+"원");
			balance = balance - amount;
			System.out.println("CheckingAccount에 "+amount+"원 출금 후 금액: " + balance+"원\n");
		}
	}
	
	public void setOverdraftAmount(double setoverdraftAmount) {
		this.overdraftAmount = setoverdraftAmount;
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
}