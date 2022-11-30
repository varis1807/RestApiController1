package com.example.RestApiController;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController  // controller use kr rhe hai isliye iska use kr rhe hai kyuki hme btana pdega ki hm ae use kr rhe hai
public class MyController {
    // hm database use nhi kr rhe hai isliye ae use kr rhe, hai hm khud ka db bnane ki kosis kr rhe hai
    Map<Integer, User> users = new HashMap<>();

}
