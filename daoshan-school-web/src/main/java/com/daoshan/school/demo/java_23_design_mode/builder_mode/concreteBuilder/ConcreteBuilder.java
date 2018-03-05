package com.daoshan.school.demo.java_23_design_mode.builder_mode.concreteBuilder;

import com.daoshan.school.demo.java_23_design_mode.builder_mode.Product.Product;
import com.daoshan.school.demo.java_23_design_mode.builder_mode.builder.Builder;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();
    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
