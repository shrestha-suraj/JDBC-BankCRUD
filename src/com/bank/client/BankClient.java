package com.bank.client;

import com.bank.services.BankRepository;
import com.bank.domain.*;

public class BankClient {
    public static void main (String[] args){
        BankRepository bankRepository=new BankRepository();
        Transaction transaction=bankRepository.findTransaction(2);
        System.out.println(transaction);
    }
}
