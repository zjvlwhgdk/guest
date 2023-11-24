/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.hms.hotel;

import static cse.oop2.hms.hotel.GuestInfo.makeInfo;
import java.util.Scanner;

public class Guest {

    Scanner sc = new Scanner(System.in);

    public void GuestStart() {
        boolean x = true;
        GuestList gi = new GuestList();
        Payment p = new Payment();
        while (x) {
            System.out.println("1. 출력, 2. 예약, 3. 정보 수정, 4.체크인 5. 체크아웃 6. 결제 유형 기록 7.결제 정보 보기  10.종료");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    gi.ShowInfo();
                    break;
                case 2:
                    gi.Book(makeInfo());
                    break;
                case 3:
                    System.out.println("수정할 정보의 예약번호를 입력해 주세요.");
                    int bookNum = sc.nextInt();
                    gi.UpdateInfo(makeInfo(), bookNum);
                    break;
                case 4:
                    gi.CheckIn();
                case 5:
                    gi.CheckOut();
                case 6:
                    p.recordPayment();
                case 7:
                    p.ShowPayments();
                case 10:
                    x = false;
            }
        }
    }
}
