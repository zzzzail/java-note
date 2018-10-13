package com.fsocity.security.controller;

import com.fsocity.security.DTO.FileInfo;
import com.fsocity.security.util.ProjectUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author zail
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/file")
public class FileController {
  
  private String folder = ProjectUtil.getProjectAbsolutePath() + "/upload/";
  
  @PostMapping
  public FileInfo upload(MultipartFile file) throws IOException {
    System.out.println(file.getName());
    System.out.println(file.getOriginalFilename());
    System.out.println(file.getSize());
    System.out.println(file.getContentType());
    
    File localFile = new File(folder, new Date().getTime() + ".txt");
    file.transferTo(localFile);
    
    return new FileInfo(localFile.getAbsolutePath());
  }
  
  @GetMapping("/{id}")
  public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
    try (
      /**
       * 测试的时候获取项目路径是 imooc-security-demo
       * 运行时项目路径是 java-note
       */
      InputStream file = new FileInputStream(new File("/Users/zail/Workspace/Java/java-note/imooc-security-demo/upload/" + id + ".txt"));
      OutputStream out = response.getOutputStream();
    ) {
      response.setContentType("application/x-download");
      response.addHeader("Content-Disposition", "attachment;filename=test.txt");
      
      IOUtils.copy(file, out);
      out.flush();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
