package com.zzl.thinkinjava.javaio.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

    public static void main(final String[] args) {

    }

    public static void DirList1(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirNameFilter(""));
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem :
                list) {
            System.out.println(dirItem);
        }

    }

    public static class DirNameFilter implements FilenameFilter {

        private Pattern pattern;

        public DirNameFilter(String regex) {
            pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }

}
