package test;

import org.junit.Assert;
import org.junit.Test;

public class TestPiece {

    @Test
    public void test_piece() {
        Assert.assertTrue("expected message", true); //on teste que true == true
        Assert.assertEquals("expected message", true, true); //on teste que true == true
    }

}
