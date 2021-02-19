package main;

import entities.Contract;
import entities.Installment;
import entities.services.ContractService;
import entities.services.PayPalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data: ");

        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Date: ");
        Date date = sdf.parse(sc.next());

        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        System.out.print("Number of installments: ");
        int installmentsNumber = sc.nextInt();

        Contract contract = new Contract(number,date,contractValue);
        ContractService cs = new ContractService(new PayPalService());
        cs.processContract(contract, installmentsNumber);

        System.out.println("Installments:");
        for (Installment it : contract.getInstallments()) {
            System.out.println(it);
        }

    }
}
