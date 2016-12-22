package com.capgemini.service;

import java.util.StringJoiner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		// TODO Auto-generated constructor stub
		this.accountRepository = accountRepository;
	}
	
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		// TODO Auto-generated method stub
		if(amount < 500){
			throw new InsufficientInitialBalanceException("Balance Not Sufficient");
		}
		
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		if(accountRepository.save(account)){
			return account;
		}
		
		return null;
	}

	@Override
	public int showBalance(int accountNumber) {
		// TODO Auto-generated method stub

		
		if(accountRepository.searchAccount(accountNumber).getAccountNumber() == accountNumber){
			return accountRepository.searchAccount(accountNumber).getAmount();
		}
		
		return 0;
	}

	@Override
	public int withDrawAmount(int accountNumber, int withdrawAmount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		if(accountRepository.searchAccount(accountNumber).getAccountNumber() == accountNumber){
			if(accountRepository.searchAccount(accountNumber).getAmount() < withdrawAmount){
				throw new InsufficientBalanceException("Larger Withdraw Amount");
			}
			
			else{
				return accountRepository.searchAccount(accountNumber).getAmount() - withdrawAmount;
			}
		}
		
		return 0;
	}
	

	@Override
	public int depositAmount(int accountNumber, int depositAmount) throws InvalidAccountNumberException,InsufficientBalanceException{
		// TODO Auto-generated method stub
		if(accountRepository.searchAccount(accountNumber) != null && (accountRepository.searchAccount(accountNumber).getAccountNumber() == accountNumber)){
			if(depositAmount > 0)
				return accountRepository.searchAccount(accountNumber).getAmount() + depositAmount;
			else
				throw new InsufficientBalanceException("Balance not sufficient to deposit");
		}else{
			throw new InvalidAccountNumberException("Account Number is not valid");
		}
	}

	@Override
	public StringJoiner fundTransfer(int sourceAccountNumber, int destinationAccountNumber, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
