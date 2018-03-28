package com.daoshan.school.demo.java8.demo;

import java.io.File;
import java.io.FileFilter;

public class Demo {


    //java8  之前
    File[] hiddenFile = new File(".").listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isHidden();
        }
    });
}
