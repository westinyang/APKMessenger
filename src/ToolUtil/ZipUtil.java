package ToolUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    public static List readZipFile(String file, String soDir, String soDir2) throws Exception {

        List<String> Sofilelist = new ArrayList<>();//加固文件列表
        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
                continue;
            }
            String str = ze.getName();
            if (str.startsWith(soDir) || str.startsWith(soDir2)) {
                Sofilelist.add(str);
            }
        }
        zin.closeEntry();
    return Sofilelist;
    }

}
