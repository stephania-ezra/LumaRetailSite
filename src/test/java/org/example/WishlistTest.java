package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WishlistTest extends LumaLoginTest {

    @AfterTest
    void tearDown() {
        BaseTestUtils.tearDown(driver);
    }

    @Test
    public void wishList() {

        // TODO
    }
}
