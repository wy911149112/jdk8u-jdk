/*
 * Copyright 1997-2007 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/*
 * utility class
 */

public class TestUtility {

    private static final String digits = "0123456789abcdef";

    public TestUtility() {

    }

    public static String hexDump(byte[] bytes) {

        StringBuffer buf = new StringBuffer (bytes.length * 2);
        int  i;

        buf.append ("    ");                    // four spaces
        for (i = 0; i < bytes.length; i++) {
            buf.append (digits.charAt ((bytes[i] >> 4) & 0x0f));
            buf.append (digits.charAt (bytes[i] & 0x0f));
            if (((i + 1) % 32) == 0) {
                if ((i +  1) != bytes.length)
                    buf.append ("\n    ");      // line after four words
            } else if (((i + 1) % 4) == 0)
                buf.append (' ');               // space between words
        }
        return buf.toString ();
    }


    public static boolean equalsBlock(byte[] b1, byte[] b2) {

        if (b1.length != b2.length)
            return false;

        for (int i=0; i<b1.length; i++) {
            if (b1[i] != b2[i])
                return false;
        }

        return true;
    }

    public static boolean equalsBlock(byte[] b1, byte[] b2, int len) {

        for (int i=0; i<len; i++) {
            if (b1[i] != b2[i])
                return false;
        }

        return true;
    }

}
