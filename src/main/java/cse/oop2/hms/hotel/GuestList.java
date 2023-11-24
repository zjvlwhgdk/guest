/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.hms.hotel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestList {

    Scanner sc = new Scanner(System.in);
    List<Integer> checkRoom = new ArrayList<Integer>(); //체크인/체크아웃 했는지 확인
    List<Integer> roomNum = new ArrayList<Integer>(); //방번호
    List<GuestInfo> InfoList = new ArrayList<GuestInfo>(); //고객의 정보를 저장한 배열
    private int bookNum = 0; //예약 번호,고유 번호
    double roomCharge = 5.0; // 객실 1박 요금
    double restaurantBill = 0.00; // 레스토랑 이용 금액 초기화
    boolean restaurantUsage = false; // 레스토랑 이용 여부 초기화

    GuestInfo te = new GuestInfo();

    public void Book(GuestInfo guestInfo) {

        System.out.print("방 번호 : ");
        int roomnum = sc.nextInt();
        if (roomNum.contains(roomnum)) { // 방번호 배열에 이미 있는 값을 입력하면 while문
            while (true) {
                System.out.println("다른 고객님이 사용중인 방입니다\n다른 방을 선택해주세요 : ");
                int roomnum1 = sc.nextInt();
                if (!roomNum.contains(roomnum1)) {
                    System.out.println("예약 ok");
                    System.out.println("고객님의 예약번호는 " + bookNum + "입니다");
                    roomNum.add(bookNum, roomnum1);
                    sc.nextLine();
                    break;
                }
            }
        } else {
            System.out.println("예약 ok");
            System.out.println("고객님의 예약번호는 " + bookNum + "입니다");
            roomNum.add(bookNum, roomnum);

        }
        guestInfo.setBookNum(bookNum); // 방 번호 저장

        File memoFile = new File("C:\\Users\\yeong\\d.txt");
        try {

            FileWriter w = new FileWriter(memoFile, true);
            w.write(String.valueOf(roomnum));
            w.write("\r\n");
            w.flush();
            w.close();

        } catch (IOException e) {
        }
        bookNum++;
    }

    public void UpdateInfo(GuestInfo personInfo, int bookNum) { //고유번호의 고객정보를 수정
        roomNum.remove(bookNum);
        System.out.print("방 번호 : ");
        int roomnum = sc.nextInt();
        if (roomNum.contains(roomnum)) {
            while (true) {
                System.out.print("다른 고객님이 사용중인 방입니다\n다른 방을 선택해주세요 : ");
                int roomnum1 = sc.nextInt();
                if (!roomNum.contains(roomnum1)) {
                    roomNum.add(bookNum, roomnum1);

                    break;
                }
            }
        }
        for (int i = 0; i < InfoList.size(); i++) {
            GuestInfo GuestInfo2 = InfoList.get(i);

            if (bookNum == GuestInfo2.getBookNum()) {
                personInfo.setBookNum(bookNum);

                InfoList.remove(i);
                InfoList.add(i, personInfo);

                break;
            }

        }
    }

    public void ShowInfo() {
        for (int i = 0; i < InfoList.size(); i++) {
            System.out.println("-------------------------------------------------");
            System.out.println("고유번호 : " + InfoList.get(i).getBookNum()
                    + "\n예약 날짜 : " + InfoList.get(i).getDate()
                    + "\n성 : " + InfoList.get(i).getFirstName()
                    + "\n이름 : " + InfoList.get(i).getLastName()
                    + "\n전화번호 : " + InfoList.get(i).getPhoneNum()
                    + "\n방번호 : " + roomNum.get(i));
            System.out.println("-------------------------------------------------");
        }
    }

    public void CheckIn() {
        System.out.println();
        System.out.print("방 번호 입력: ");
        int checkroom = sc.nextInt();
        if (roomNum.contains(checkroom)) {
            if (checkRoom.contains(checkroom)) {
                while (true) {
                    System.out.println("이미 체크인이 완료된 방입니다.");
                    System.out.println("다른 방 번호룰 입력해주세요");
                    int checkroom2 = sc.nextInt();
                    if (!checkRoom.contains(checkroom2)) {
                        checkRoom.add(checkroom2);
                        break;
                    }
                }
            } else {
                //TODO 정보 확인하고 체크인
                checkRoom.add(checkroom);
                System.out.println("체크인이 완료되었습니다. ");
            }
        } else {
            System.out.println("예약이 되어있지 않은 방입니다. ");
        }
    }

    public void CheckOut() {

        System.out.println("체크아웃 시간이 되었습니다. 레스토랑을 이용하셨습니까? (예/아니오)");
        String restaurantInput = sc.nextLine();

        if (restaurantInput.equalsIgnoreCase("예")) {
            System.out.println("레스토랑 이용 금액을 입력해주세요: ");
            restaurantBill = sc.nextDouble();
            sc.nextLine(); // 버퍼 비우기
            restaurantUsage = true;
        }

        System.out.println("추가 숙박비 여부를 확인합니다. 현재 시간을 입력해주세요: "); // 24, 예 : 13
        int currentTime = sc.nextInt();

        if (currentTime > 11) {
            double additionalCharge = 1.0; // 추가 숙박비
            roomCharge += additionalCharge;
            System.out.println("추가 숙박비가 발생했습니다. 추가 금액: $" + additionalCharge);
        }

        double totalBill = roomCharge + restaurantBill;
        System.out.println("숙박비: $" + roomCharge);

        if (restaurantUsage) {
            System.out.println("레스토랑 이용 금액: $" + restaurantBill);
        }

        System.out.println("총 합계: $" + totalBill);
        System.out.println("체크아웃 하시겠습니까?");
        System.out.println();
        System.out.print("방 번호 입력: ");
        int checkroom = sc.nextInt();
        if (checkRoom.contains(checkroom)) {
            //TODO 결제

            System.out.println("체크아웃 되었습니다. 감사합니다.");
            checkRoom.remove(checkroom);
        } else {
            System.out.println(roomNum + "호는 빈 방 입니다.");

        }
    }

}
