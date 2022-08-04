package com.refactor;

/**
 * 组合模式重构
 *
 * 将一组对象（文件和目录）组织成 树形结构，以表示一种‘部分 - 整体’的层次结构（目录与子目录的嵌套结构）。
 * 组合模式让客户端可以统一单个对象（文件）和组合对象（目录）的处理逻辑（递归遍历）。
 *
 * @author ImOkkkk
 * @date 2022/8/4 13:02
 * @since 1.0
 */
abstract class FileSystemNode {

  protected String path;

  public FileSystemNode(String path) {
    this.path = path;
  }

  public abstract int countNumOfFiles();

  public abstract long countSizeOfFiles();

  public String getPath() {
    return path;
  }
}
