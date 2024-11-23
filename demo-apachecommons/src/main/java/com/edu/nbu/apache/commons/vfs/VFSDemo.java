package com.edu.nbu.apache.commons.vfs;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/19-5:05 PM
 * @since 1.0
 */
public class VFSDemo {

    public static void main(String[] args) {

        try {
            FileSystemManager fileSystemManager = VFS.getManager();
            FileObject jarObject = fileSystemManager.resolveFile("jar:/Users/fanwenhao/tools/apache-maven-3.3.9/resp/org/springframework/spring-aop/4.3.25.RELEASE/spring-aop-4.3.25.RELEASE.jar");
            FileObject[]  children = jarObject.getChildren();
            System.out.println("children of " + jarObject.getName().getURI());
            for(FileObject fo : children){
                System.out.println(fo.getName().getBaseName());
            }
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }

    }


}
