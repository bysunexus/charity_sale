package dns.hijacking;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.util.ArrayList;

/**
 * Created by ben on 2015/9/20.
 */
public class DnsHijackingHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        System.out.println(packet);
        byte[] buffer = new byte[packet.content().readableBytes()];
        packet.content().readBytes(buffer);
        DnsRequest request = new DnsRequest(buffer, buffer.length);
        int txnId = request.getTxnId();
        ArrayList<DnsQuestion> questions = request.getQuestions();
        for (DnsQuestion question : questions) {

            HostRecord record = new HostRecord(question.getDomainName());
            String ip = Utils.APP.getProperty("hijacking.ipaddr");
            String[] ipstrs = ip.split("\\.");
            byte[] ipaddr = new byte[ipstrs.length];
            for (int i = 0; i < ipstrs.length; i++) {
                ipaddr[i] = (byte) Integer.parseInt(ipstrs[i]);
            }
            record.addIpAddress(new IPAddress(ipaddr));
            byte reply[] = DnsResponse.constructPacket(record, txnId);
            ctx.writeAndFlush(new DatagramPacket(Unpooled.wrappedBuffer(reply), packet.sender()));
        }
    }

}
