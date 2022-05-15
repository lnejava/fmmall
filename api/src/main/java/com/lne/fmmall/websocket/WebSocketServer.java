package com.lne.fmmall.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FileName: WebSocketServer
 * Author:   fengsulin
 * Date:     2022/5/13 19:44
 * Description: 创建websocket服务器
 */
@Component
@ServerEndpoint("/websocket/{oid}")
public class WebSocketServer {

    private static ConcurrentHashMap<String,Session> sessionMap = new ConcurrentHashMap<>();

    /**
     *前端发送请求建立websocket连接，会执行改添加了该注解的方法
     * @param: [oid, session]连接对象
     * @return: void
     */
    @OnOpen
    public void onOpen(@PathParam("oid") String oid, Session session){
        sessionMap.put("oid",session);
    }

    /**当前端断开连接，会调用添加了该注解的方法*/
    @OnClose
    public void onClose(@PathParam("oid") String oid){
        sessionMap.remove(oid);
    }

    /**自定义一个发送消息的方法*/
    public static void sendMsg(String oid,String msg){
        Session session = sessionMap.get(oid);
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
