package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void EveryBranchMethod() {
        RuntimeException ex;

        //branch 2 tests:
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Walkorion", "abvg123", null), new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Walkorion", null, "finki.ukim@mail.com"), new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //pw less than 8 characters and test if mail contains "." and "@"
        assertFalse(SILab2.function(new User("Walkorion", "abbr", "finki.ukim@mail.com"), new LinkedList<User>()));

        //pw test with special characters
        assertFalse(SILab2.function(new User("Walkorion", "abvg123!", "finkiukim"), new LinkedList<User>()));

        //test if mail contains "." and "@"
        //assertFalse(SILab2.function(new User("Walkorion", "abvg123", "finki.ukim@mail.com"), new LinkedList<User>()));

        //test if username==null
        assertFalse(SILab2.function(new User(null, "abvh11", "finki.ukim.@mail.com"),new LinkedList<User>()));

        //test for code to end in line 27
        assertFalse(SILab2.function(new User("Walkorion", "12334av", "finki.ukim@mail.mk"), List.of(new User("Walkorion", "12334av", "finki.ukim@mail.mk"), new User("unknown", "12gg", "finkiukim"))));
    }

    @Test
    public void MultipleConditionMethod(){
        //test for condition 2:
        // if (user==null || user.getPassword()==null || user.getEmail()==null){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Walkorion", "abvg123", null), new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Walkorion", null, "finki.ukim@"), new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Walkorion", null, null), new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new LinkedList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
}