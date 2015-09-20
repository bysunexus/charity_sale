package dns.hijacking;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * dns劫持
 */
public class DnsHijacking {
    private static DnsHijacking ourInstance = new DnsHijacking();

    private DnsHijacking() {

        EventLoopGroup group = new NioEventLoopGroup();

        new Thread(() -> {
            try {
                Bootstrap b = new Bootstrap();
                b.group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(new DnsHijackingHandler());

                b.bind(53).sync().channel().closeFuture().await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
        }).start();
    }

    public static DnsHijacking getInstance() {
        return ourInstance;
    }
}
