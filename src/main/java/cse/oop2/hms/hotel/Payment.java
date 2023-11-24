/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.hms.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yeong
 */
public class Payment {

    List<PaymentInfo> payments = new ArrayList<PaymentInfo>();

    public void recordPayment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("결제 유형을 입력하세요: ");
        String paymentType = sc.nextLine();

        System.out.println("결제 금액을 입력하세요: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // 개행 문자 처리

        System.out.println("결제 내용을 입력하세요: ");
        String description = sc.nextLine();

        PaymentInfo newPayment = new PaymentInfo(paymentType, amount, description);
        payments.add(newPayment);

        System.out.println("결제가 기록되었습니다.");

    }

    public void ShowPayments() {
        if (payments.isEmpty()) {
            System.out.println("기록된 결제 정보가 없습니다.");
        } else {
            System.out.println("기록된 결제 정보: ");
            for (PaymentInfo paymentInfo : payments) {
                System.out.println("결제 유형: " + paymentInfo.getPaymentType() + ",금액: " + paymentInfo.getAmount() + ",내용: " + paymentInfo.getDescription());
            }
        }

    }
}
