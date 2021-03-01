package com.araz.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordHashTest {

    @Test
    public void hash() {
        assertNotNull(PasswordHash.getInstance().hash("test"));
    }
}