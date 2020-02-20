package ywh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author ywh
 * @date 2019/11/18 10:00
 * @description
 */
public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    //三次握手连接成功
    //建立一个Listen在port上的TCP监听Socket
    public void run(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            //一次循环执行一个
            //通过accept方法调用，返回一个代表建立好的TCP Socket
            try (Socket socket = serverSocket.accept()) {
                logger.info("{ } 已连接", socket.getInetAddress().getHostName());
                //拿到输入输出流
                InputStream is = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Command command = null;
                while (true) {
                    try {
                        command = Protocol.readCommand(is);
                        command.runMethod(out);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        }

    }

    public static void main(String[] args) throws IOException {
         new Server().run(6379);
    }
}
