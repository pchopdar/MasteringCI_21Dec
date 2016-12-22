package com.capgemini.service;

import java.util.StringJoiner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {
	
	Account createAccount(int accountNumber, int amount)throws InsufficientInitialBalanceException;
	int showBalance(int accountNumber);
	int withDrawAmount(int accountNumber,int withdrawAmount) throws InsufficientBalanceException;
	int depositAmount(int accountNumber,int depositAmount) throws InvalidAccountNumberException, InsufficientBalanceException;
	StringJoiner fundTransfer(int sourceAccountNumber,int destinationAccountNumber, int amount);
	
}
