package com.lzp.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
    public void index() {
//        renderText("Hello JFinal World.");
        render("index.jsp");

    }
}
