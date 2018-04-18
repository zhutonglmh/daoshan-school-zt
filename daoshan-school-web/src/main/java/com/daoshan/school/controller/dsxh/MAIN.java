package com.daoshan.school.controller.dsxh;

import com.daoshan.school.utils.uuid.UUIDUtils;

public class MAIN {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUIDUtils.getUUID());
        }
    }
}
