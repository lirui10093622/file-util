package org.explore.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
            int count;
            while ((count = in.read(bytes)) >= 0) {
                out.write(bytes, 0, count);
            }
            out.flush();
        } catch (Exception e) {
            log.error("写文件异常", e);
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

    public static void write(String content, Charset charset, String filePath) {
        write(new ByteArrayInputStream(content.getBytes(charset)), filePath);
    }

    public static String read(String filePath, Charset charset) {
        File file = new File(filePath);
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] bytes = new byte[100];
            int count;
            while ((count = in.read(bytes)) >= 0) {
                out.write(bytes, 0, count);
            }
            return new String(out.toByteArray(), charset);
        } catch (Exception e) {
            log.error("写文件异常", e);
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    log.error("关闭资源异常", e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    log.error("关闭资源异常", e);
                }
            }
        }
    }
}