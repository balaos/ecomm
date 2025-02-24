package com.sample.ecomm.others;

class Bank {
    double getInterestRate() {
        return 0;  // Default implementation
    }
}

class SBI extends Bank {
    double getInterestRate() {
        return 5.5; // SBI specific interest rate
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 6.0; // HDFC specific interest rate
    }
}

public class PolyMorphismSample {
    public static void main(String[] args) {
        Bank myBank;

        myBank = new SBI();
        System.out.println("SBI Interest Rate: " + myBank.getInterestRate());

        myBank = new HDFC();
        System.out.println("HDFC Interest Rate: " + myBank.getInterestRate());
    }
}
