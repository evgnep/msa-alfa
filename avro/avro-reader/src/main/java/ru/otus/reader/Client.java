package ru.otus.reader;

import org.apache.avro.ipc.netty.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import ru.otus.getuser.GetUser;
import java.net.InetSocketAddress;

public class Client {
  public static void main(String[] args) throws Exception {
    NettyTransceiver t = new NettyTransceiver(new InetSocketAddress("localhost", 8000));
    GetUser client = SpecificRequestor.getClient(GetUser.class, t);
    var user = client.getUsers();
    System.out.println("\n\n" + user);
    t.close();
  }
}
