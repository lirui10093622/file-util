package org.explore.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-01-07 18:17:11
 */
public class FileUtilTest {

    @Test
    public void write() {
        FileUtil.write(new ByteArrayInputStream("文件内容".getBytes()), "/tmp/a.txt");
    }
}