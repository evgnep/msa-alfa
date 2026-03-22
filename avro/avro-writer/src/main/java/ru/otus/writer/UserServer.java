package ru.otus.writer;

import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.netty.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;
import ru.otus.getuser.GetUsers;
import ru.otus.getuser.User;
import java.net.InetSocketAddress;

public class UserServer implements GetUsers {
  @Override
  public User getUsers() {
    return User.newBuilder()
        .setName("Stepa")
        /*1*/ .setEmail("b@c.ru")
        .setFavoriteColor("black")
        .setFavoriteNumber(64)
        .build();
  }

  public static void main(String[] args) throws Exception {
    Server server = new NettyServer(
        new SpecificResponder(GetUsers.class, new UserServer()),
        new InetSocketAddress("localhost",  8000));
    server.start();
    server.join();
  }
}
