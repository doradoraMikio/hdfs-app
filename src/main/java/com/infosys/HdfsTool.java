package com.infosys;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;

public class HdfsTool {

    public HdfsTool() {
        super();
    }

    public static void debug(Object data) {
        System.out.println(data.toString());
    }

    /**
     * HDFSのｻﾝﾌﾟﾙｱﾌﾟﾘを実行
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String target = "/user/java/test_dir";

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://hadoop.example.com:9000");

        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(target);

        boolean isCreated = FileSystem.mkdirs(fs, path, new FsPermission(FsAction.ALL, FsAction.ALL, FsAction.ALL));
        System.out.println(isCreated);

    }

}
