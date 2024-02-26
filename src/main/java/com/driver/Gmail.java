package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity;
    private ArrayList<Address> inbox;
    private ArrayList<Address> trash;//maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();


    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
      if(inbox.size()>= inboxCapacity){
          trash.add(inbox.remove(0));
      }
      inbox.add(new Address(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
//        for(int i=0;i<inbox.size();i++){
//            if(inbox.get(i).equals(message)){
//                inbox.remove(i);
//            }
//        }
        for(int i=0; i<inbox.size();i++){
            Address m = inbox.get(i);

            if(m.message.equals(message)){
                trash.add(m);
                inbox.remove(i);
//                return;
                break;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        int n= inbox.size();
        if(inbox.size() ==0){
            return null;
        }
        return inbox.get(n-1).message;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0){
            return null;
        }
        return inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
//        int count =0;
//        int n= inbox.size();
//
//            for (Mail mail : inbox) {
//                if (mail.getDate().after(start) && mail.getDate().before(end)) {
//                    count++;
//                }
//            }
        int count = 0;

       for(int i=0; i<inbox.size(); i++){
           Address m = inbox.get(i);
           if(m.date.compareTo(start) >=0 && m.date.compareTo(end) <=0){
               count++;
           }
       }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
//        int n= trash.size();
//        for(int i=0;i<n;i++){
//            trash.remove(i);
//        }
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbo
        return inboxCapacity;
    }
    
    private class Address{
        String sender;
        Date date;
        String message;
        Address(Date date, String sender,String message){
            this.date = date;
            this.sender = sender;
            this.message = message;
        }


    }
}
