package com.itremind.wildapp.core.utils;

/**
 * Created by Borisovskiy.V on 04.06.2017.
 */
public class Transliterator {
    private static final char[] abcCyr = {'а','б','в','г','д','е','ё','ж','з','и','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','ы','э','ю','я'};
    private static final String[] abcLat = {"a","b","v","g","d","e", "jo","zh","z","i","k","l","m","n","o","p","r","s","t","u","f","h","ts","сh","sh","i","e","ju","ja"};

    public static String toLatin(String cyr){
        cyr = cyr.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cyr.length(); j++){
            for ( int i = 0; i < abcCyr.length; i++){
                if(cyr.charAt(j) == abcCyr[i]) {
                    sb.append(abcLat[i]);
                }
            }
        }
        return sb.toString();
    }

}
