import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {

	public static void main(String[] args) throws Exception{
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
		
		System.out.println("opened socket: " + socketChannel);
	}

}
