package TheArtOfJavaConcurrencyProgramming.Section444;

import TheArtOfJavaConcurrencyProgramming.Section443.DefaultThreadPool;
import TheArtOfJavaConcurrencyProgramming.Section443.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zail
 * @since 2018-09-13
 */
public class SimpleHttpServer {
  
  // 处理 http request 的线程池
  public static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();
  
  // SimpleHttpServer 的根路径
  public static String basePath;
  
  public static ServerSocket serverSocket;
  
  // 服务监听端口
  public static int port = 9090;
  
  public static void setPort(int port) {
    if (port > 0) {
      SimpleHttpServer.port = port;
    }
  }
  
  public static void setBasePath(String basePath) {
    if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
      SimpleHttpServer.basePath = basePath;
    }
  }
  
  public static void start() throws IOException {
    serverSocket = new ServerSocket(port);
    Socket socket = null;
    while ((socket = serverSocket.accept()) != null) {
      // 接受一个客户端 socket, 生成一个 HttpRequestHandler, 放入线程池执行.
      threadPool.execute(new HttpRequestHandler(socket));
    }
    
    serverSocket.close();
  }
  
  static class HttpRequestHandler implements Runnable {
    
    private Socket socket;
    
    public HttpRequestHandler(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      String line = null;
      BufferedReader br = null;
      BufferedReader reader = null;
      PrintWriter out = null;
      InputStream in = null;
      
      try {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String header = reader.readLine();
        // 由相对路径计算出绝对路径
        String filePath = basePath + header.split(" ")[1];
        
        out = new PrintWriter(socket.getOutputStream());
        
        // 如果请求资源后缀是 jpg 或者 ico, 读取资源并输出
        if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
          in = new FileInputStream(filePath);
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          int i = 0;
          while ((i = in.read()) != -1) {
            baos.write(i);
          }
          byte[] array = baos.toByteArray();
          out.print("HTTP/1.1 200 OK");
          out.print("Server:Molly");
          out.print("Content-Type: image/jpeg");
          out.print("Content-Length: " + array.length);
          out.print("");
          socket.getOutputStream().write(array, 0, array.length);
        }
        else {
          br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
          out = new PrintWriter(socket.getOutputStream());
          out.println("HTTP/1.1 200 OK");
          out.println("Server: Molly");
          out.println("Content-Type: text/html; charset=UTF-8");
          out.println("");
          while ((line = br.readLine()) != null) {
            out.println(line);
          }
        }
        
        out.flush();
      }
      catch (IOException e) {
        e.printStackTrace();
        out.println("HTTP/1.1 500");
        out.println("");
        out.flush();
      }
      finally {
        System.out.println(Thread.currentThread().getName() + " 处理完成.");
        close();
      }
    }
    
    public static void close(Closeable... closeables) {
      if (closeables != null) {
        for (Closeable closeable : closeables) {
          try {
            closeable.close();
          }
          catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
