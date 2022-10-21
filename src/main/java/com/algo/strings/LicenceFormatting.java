package com.algo.strings;

public class LicenceFormatting {
    public static void main(String[] args) {
        System.out.println(LicenceFormatting.ReFormatString("-yD-tuI-wm-9sCUp5", 4));
    }

    static String ReFormatString(String str, int K){
        // code here
        int charCounter = 0;
        StringBuilder sb = new StringBuilder();


        for( int i=str.length() -1; i >= 0; i--) {
            if(str.charAt(i) != '-') {
                charCounter++;
            }
            if(charCounter == K) {
                sb.insert(0, str.substring(i).replaceAll("-", ""));
                str = str.substring(0, i);
                charCounter=0;
                if( i != 0) sb.insert(0,"-");
            }
        }

        if(str.length() == 1 && str.charAt(0) == '-') return sb.substring(1, sb.length()).toUpperCase().toString();
        sb.append(str.replaceAll("-", ""));

        return sb.toString().toUpperCase();
    }
}
