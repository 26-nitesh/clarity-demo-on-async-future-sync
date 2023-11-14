package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
public class DEmoServ {


private String getThNAme(){
    return "["+ LocalDateTime.now() +"] "+"["+Thread.currentThread().getName()+"] "+" ";
}
@Async
    public CompletableFuture<Boolean> calling(int id) throws InterruptedException {
        System.out.println(getThNAme()+id);
        System.out.println(getThNAme() + " Starting");
//        Thread.sleep(3000);
        m1(id);
        System.out.println(getThNAme() + " END");
        return CompletableFuture.completedFuture(Boolean.TRUE);
    }

    private void m1(int id) throws InterruptedException {
        System.out.println(getThNAme()+"START M1()");
//          Thread.sleep(2000);
        System.out.println(getThNAme() + "WAITING for id "+id );
          m2(id);
        System.out.println(getThNAme()+"inside m1 after m2 complete");
        m3(id);
        System.out.println(getThNAme()+"END M1()");
    }

    private void m3(int id) throws InterruptedException {
        System.out.println(getThNAme()+"for "+id+ " m3");
        Thread.sleep(6000);
        System.out.println(getThNAme()+"for "+id+ "m3 completes");
    }


    private synchronized void m2(int id) throws InterruptedException {
            System.out.println(getThNAme()+"INSIDE SYNC for id "+id);
            Thread.sleep(2000);
            System.out.println(getThNAme()+"Sync TASK END for id "+id);
    }
}
