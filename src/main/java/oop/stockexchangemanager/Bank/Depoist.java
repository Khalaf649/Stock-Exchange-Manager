package oop.stockexchangemanager.Bank;

public class Depoist implements BankOperation{
    @Override
    public void DoOperation(BankAccount account,float amount) {
        account.balance+=amount;

    }
}