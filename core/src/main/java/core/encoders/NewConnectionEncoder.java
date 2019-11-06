package core.encoders;

import java.nio.charset.Charset;

import core.messages.MessageAcceptConnection;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NewConnectionEncoder extends MessageToByteEncoder<MessageAcceptConnection> {

	@Override
	protected void encode(ChannelHandlerContext ctx, MessageAcceptConnection message, ByteBuf out) throws Exception {
		out.writeInt(message.getTypeLength());
		Charset charset = Charset.forName("UTF-8");
		out.writeCharSequence(message.getMessageType(), charset);
		if (message.getMessageType().equals("MESSAGE_ACCEPT_CONNECTION")) {
			out.writeInt(message.getId());
			out.writeInt(message.getChecksumLength());
			out.writeCharSequence(message.getChecksum(), charset)
		}
	}
}
