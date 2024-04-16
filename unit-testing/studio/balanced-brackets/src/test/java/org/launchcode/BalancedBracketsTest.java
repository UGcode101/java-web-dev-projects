package org.launchcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {

    @Test
    public void emptyStringReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets(""));
    }

    @Test
    public void onlyBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
    }

    @Test
    public void multipleBalancedBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[Launch][Code]"));
    }

    @Test
    public void nestedBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[Launch[Code]]"));
    }

    @Test
    public void balancedBracketsWithCharactersReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("Launch[Code]"));
    }

    @Test
    public void singleOpeningBracketReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[LaunchCode"));
    }

    @Test
    public void singleClosingBracketReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("Launch]Code"));
    }

    @Test
    public void reverseBracketsReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]LaunchCode["));
    }

    @Test
    public void multipleUnbalancedBracketsReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[Launch]Code["));
    }

    @Test
    public void onlyClosingBracketsReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]]]]"));
    }

    @Test
    public void onlyOpeningBracketsReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[[["));
    }

    @Test
    public void moreOpeningThanClosingReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[[]"));
    }

    @Test
    public void moreClosingThanOpeningReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("][]]"));
    }
}