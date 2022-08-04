package com.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/4 13:21
 * @since 1.0
 */
public class File extends FileSystemNode{
  public File(String path){
    super(path);
  }

  @Override
  public int countNumOfFiles() {
    return 1;
  }

  @Override
  public long countSizeOfFiles() {
    java.io.File file = new java.io.File(path);
    if(!file.exists()){
      return 0;
    }
    return file.length();
  }
}
