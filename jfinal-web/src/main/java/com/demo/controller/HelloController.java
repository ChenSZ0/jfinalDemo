package com.demo.controller;

import com.jfinal.core.Controller;

/**
 * @author  chenshuzhuo
 * hello World!
 */
public class HelloController extends Controller {

    public void index(){
        renderText("hello World!");
    }

}
