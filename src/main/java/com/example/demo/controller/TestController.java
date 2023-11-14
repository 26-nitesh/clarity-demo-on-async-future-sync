package com.example.demo.controller;

import com.example.demo.service.DEmoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/demo")
public class TestController {

    private String getThNAme(){
        return Thread.currentThread().getName();
    }
    @Autowired
    DEmoServ dEmoServ;
    @GetMapping("/test")
    public String t() throws InterruptedException {
        System.out.println(getThNAme() + " API STARTTED");
        CompletableFuture<Boolean> calling = dEmoServ.calling(1);
        CompletableFuture<Boolean> calling1 = dEmoServ.calling(2);
        CompletableFuture<Boolean> calling2 = dEmoServ.calling(3);
        CompletableFuture<Boolean> c4 = dEmoServ.calling(4);
        CompletableFuture<Boolean> c5 = dEmoServ.calling(5);
        CompletableFuture<Boolean> c6 = dEmoServ.calling(6);
        CompletableFuture<Boolean> c7 = dEmoServ.calling(7);
        CompletableFuture<Boolean> c8 = dEmoServ.calling(8);
        CompletableFuture<Boolean> callc9ing2 = dEmoServ.calling(9);

        CompletableFuture.allOf(calling,calling1,calling2).join();
        return  "POK00";
    }


}
