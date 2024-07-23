package LLD.DesignQuestions;

import java.util.Scanner;

class User {
    private int id;
    private String name;
    private Card card;

    public User(int id, String name, Card card) {
        this.id = id;
        this.name = name;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void updateBalance(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}

enum CardType{
    CREDIT_CARD,
    DEBIT_CARD
}
class Card {
    private String cardHolderName;
    private int pin;
    private CardType cardType;
    private BankAccount bankAccount;

    public Card(String cardHolderName, int pin, CardType cardType, BankAccount bankAccount) {
        this.cardHolderName = cardHolderName;
        this.pin = pin;
        this.cardType = cardType;
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getPin() {
        return pin;
    }
}

//State

abstract class ATMState {
    public void enterPin(Card card, int pin) {
        System.out.println("Invalid Operation !!");
    }
    public void withdraw(Card card, int amount) {
        System.out.println("Invalid Operation !!");
    }
    public void enterCard(Card card) {
        System.out.println("Invalid Operation !!");
    }
}

class IdleState extends ATMState {

    private final ATM atm;
    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void enterCard(Card card) {
        atm.setCard(card);
        atm.setAtmState(atm.getCardInsertedState());
        System.out.println("Please enter pin");
    }
}

class CardInsertedState extends ATMState {

    private final ATM atm;
    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void enterPin(Card card, int pin) {
        if (pin == card.getPin()) {
            atm.setAtmState(atm.getAuthenticatedState());
            System.out.println("Enter Amount");
        } else {
            System.out.printf("Incorrect Pin : %d Enter Again", pin);
            System.out.println();
            atm.setAtmState(atm.getCardInsertedState());
        }
    }
}


class AuthenticatedState extends ATMState {

    private ATM atm;
    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void withdraw(Card card, int amount) {
        if (card == null) {
            System.out.println("Enter card again");
            return;
        }
        BankAccount bankAccount = card.getBankAccount();
        int balance = bankAccount.getBalance();
        if (amount <= balance && amount % 100 == 0) {
            WithdrawalProcessor withdrawalProcessor = new FiveHundredNoteProcessor(new TwoHundredNoteProcessor(new OneHundredNoteProcessor(null)));
            withdrawalProcessor.withdraw(atm, amount);
            bankAccount.updateBalance(balance - amount);
            atm.deductAmount(amount);
            System.out.println("Balance Amount : " + bankAccount.getBalance());
        } else {
            System.out.println(amount % 100 == 0 ? "Insufficient balance" : "Enter valid amount");
        }
        atm.setAtmState(atm.getIdleState());
    }
}

interface WithdrawalProcessor {
    void withdraw(ATM atm, int amount);
}

class OneHundredNoteProcessor implements WithdrawalProcessor {
    private final WithdrawalProcessor nextWithdrawalProcessor;

    public OneHundredNoteProcessor(WithdrawalProcessor nextWithdrawalProcessor){
        this.nextWithdrawalProcessor = nextWithdrawalProcessor;
    }


    @Override
    public void withdraw(ATM atm, int amount) {
        if(amount >= 100) {
            int remaining = amount % 100;
            atm.deductOneHundredNotes(amount-remaining);
            if(remaining != 0 || nextWithdrawalProcessor == null){
                System.out.println("Unable to complete transaction");
            }
        } else {
            System.out.println("Enter Valid Amount");
        }
        atm.setAtmState(atm.getIdleState());
    }

}

class TwoHundredNoteProcessor implements WithdrawalProcessor {
    private final WithdrawalProcessor nextWithdrawalProcessor;

    public TwoHundredNoteProcessor(WithdrawalProcessor nextWithdrawalProcessor){
        this.nextWithdrawalProcessor = nextWithdrawalProcessor;
    }


    @Override
    public void withdraw(ATM atm, int amount) {
        if(amount >= 200) {
            int remaining = amount % 200;
            atm.deductTwoHundredNotes(amount-remaining);

            if(remaining != 0){
                nextWithdrawalProcessor.withdraw(atm, remaining);
            }
        } else {
            nextWithdrawalProcessor.withdraw(atm, amount);
        }
    }
}

class FiveHundredNoteProcessor implements WithdrawalProcessor {
    private final WithdrawalProcessor nextWithdrawalProcessor;

    public FiveHundredNoteProcessor(WithdrawalProcessor nextWithdrawalProcessor){
        this.nextWithdrawalProcessor = nextWithdrawalProcessor;
    }


    @Override
    public void withdraw(ATM atm, int amount) {
        if(amount >= 500) {
            int remaining = amount % 500;
            atm.deductFiveHundredNotes(amount-remaining);

            if(remaining != 0){
                nextWithdrawalProcessor.withdraw(atm, remaining);
            }
        } else {
            nextWithdrawalProcessor.withdraw(atm, amount);
        }
    }
}


class ATM {
    private int id;
    private String location;
    private int balance;
    private int oneHundreds;
    private int twoHundreds;
    private int fiveHundreds;
    private Card card;
    private ATMState atmState;
    private final ATMState idleState;
    private final ATMState cardInsertedState;
    private final ATMState authenticatedState;


    public ATM(){
        System.out.println("Please Enter Card");
        this.idleState = new IdleState(this);
        this.cardInsertedState = new CardInsertedState(this);
        this.authenticatedState = new AuthenticatedState(this);
        this.atmState = this.idleState;
    }

    public void deductOneHundredNotes(int amount) {
        this.oneHundreds = this.oneHundreds - amount % 100;
    }

    public void deductTwoHundredNotes(int amount) {
        this.twoHundreds = this.twoHundreds - amount % 200;
    }

    public void deductFiveHundredNotes(int amount) {
        this.twoHundreds = this.fiveHundreds - amount % 500;
    }

    public void deductAmount(int amount) {
        this.balance =  balance - amount;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public ATMState getAuthenticatedState() {
        return authenticatedState;
    }

    public ATMState getCardInsertedState() {
        return cardInsertedState;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public int getBalance() {
        return balance;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void withdraw(int amount) {
        this.atmState.withdraw(this.card, amount);
    }

    public void insertCard(Card card) {
        this.atmState.enterCard(card);
    }

    public void enterPin(int pin) {
        this.atmState.enterPin(this.card, pin);
    }
}

public class AtmRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(50000);
        Card card = new Card("Harsh", 123, CardType.CREDIT_CARD, bankAccount);
        User user = new User(123, "Harsh", card);
        ATM atm = new ATM();// include all the details of ATM
        atm.insertCard(user.getCard());
        atm.enterPin(1234);
        atm.enterPin(12342);
        atm.enterPin(123);
        atm.withdraw(sc.nextInt());
    }
}
