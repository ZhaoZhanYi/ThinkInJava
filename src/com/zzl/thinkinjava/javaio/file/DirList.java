package com.zzl.thinkinjava.javaio.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {



    public static void main(final String[] args) {
        DirList dirList = new DirList("./src/com/zzl/thinkinjava/javaio/file/test");
//        System.out.println(dirList.);
        dirList.fileFilter("[a-zA-Z0-9]*.c");
    }


    private String filePath;

    public DirList(String filePath) {
        this.filePath = filePath;
    }


    public void fileFilter(String filterRegex) {
        File path = new File(filePath);
        System.out.println("absolutely path:" + path.getAbsolutePath());
        String[] list;
        if (filterRegex != null && !filterRegex.equals("")) {
            list = path.list(new DirNameFilter(filterRegex));
        } else {
            list = path.list();
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
