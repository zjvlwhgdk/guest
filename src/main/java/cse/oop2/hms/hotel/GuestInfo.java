/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.hms.hotel;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author yeong
 */
public class GuestInfo {

    public static Scanner scan = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String phoneNum;
    private int guestNum;
    private int bookNum;
    private String date;

    public static GuestInfo makeInfo() { //고객 정보 설정
        GuestInfo guest = new GuestInfo();

        System.out.print("예약 날짜 : ");
        guest.setDate(scan.next());

        System.out.print("성 : ");
        guest.setFirstName(scan.next());

        System.out.print("이름 : ");
        guest.setLastName(scan.next());

        System.out.print("전화번호 : ");
        guest.setPhoneNum(scan.next());

        System.out.print("투숙객 수  : ");
        while(true){
            int guestnum = scan.nextInt();
            if(guestnum>5){
                System.out.println("최대 인원은 5명 입니다");
                System.out.print("투숙객 수 : ");
                continue;
            }
            else{
                guest.setGuestNum(guestnum);
                break;
            }
        }

        File memoFile = new File("C:\\Users\\yeong\\d.txt");
        try {

            FileWriter fw = new FileWriter(memoFile, true);
            // fw.write("예약번호" + "\t" + "성" + "\t" + "이름" + "\t" + "전화번호"+ "\t" + "호실" + "\r\n");
            fw.write(String.valueOf(guest.getBookNum()) + " ");
            fw.write(guest.getDate() + " ");
            fw.write(guest.getFirstName() + " ");
            fw.write(guest.getLastName() + " ");
            fw.write(guest.getPhoneNum() + " ");

            fw.flush();
            fw.close();

        } catch (IOException e) {
        }
        return guest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

}
