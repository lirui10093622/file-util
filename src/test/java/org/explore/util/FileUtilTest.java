package org.explore.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-01-07 18:17:11
 */
@Slf4j
public class FileUtilTest {

    @Test
    public void write() {
        FileUtil.write(new ByteArrayInputStream("文件内容".getBytes()), "/tmp/a.txt");
        FileUtil.write("文件内容", Charset.forName("UTF-8"), "/tmp/b.txt");
    }

    @Test
    public void read() {
        String content = FileUtil.read("/Users/neil/Desktop/14_1553336983694_dOf3eb4a.txt", Charset.forName("UTF-8"));
        log.info("文章内容: {}", content);
    }
}