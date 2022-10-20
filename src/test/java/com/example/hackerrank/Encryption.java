package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encryption {

    @Test
    public void test1() {
        assertEquals("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau",
                encryption("if man was meant to stay on the ground god would have given us roots"));

    }

    @Test
    public void test2() {
        assertEquals("hae and via ecy",
                encryption("haveaniceday"));

    }

    @Test
    public void test3() {
        assertEquals("wmgjpnull cyjqlejgi lyhhdzbui wctlsqsbm fxeoxmsvv ovxjeirfm zadysxbhn nxkkbffpn bawobphfy",
                encryption("wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny"));

    }


    public static String encryption(String s) {
        String newString = s.replaceAll(" ", "");
        int length = newString.length();
        double roots = Math.sqrt(length);
        int rowCondition = (int) roots;
        int col;
        if (roots% 1 == 0) {
            col = rowCondition;
        } else {
            col = ++rowCondition;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rowCondition; i++) {
            for (int j = i; j < length; j+=col) {
                sb.append(newString.charAt(j));
            }
            sb.append(" ");
        }

        return sb.toString().trim();

    }
}
