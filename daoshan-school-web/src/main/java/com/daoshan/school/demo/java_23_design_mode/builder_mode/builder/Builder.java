package com.daoshan.school.demo.java_23_design_mode.builder_mode.builder;

import com.daoshan.school.demo.java_23_design_mode.builder_mode.Product.Product;

public interface Builder {

    public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}
