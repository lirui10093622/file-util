package org.explore.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-01-07 18:12:42
 */
@Slf4j
public class FileUtil {

    public static void write(InputStream in, String filePath) {
        File file = new File(filePath);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte[] bytes = new byte[100];
            while (in.read(bytes) != -1) {
                out.write(bytes);
            }
            out.flush();
        } catch (Exception e) {
            log.error("写文章异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭资源异常", e);
                }
            }
        }
    }
}