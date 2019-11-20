package core.encoders;

import java.nio.charset.Charset;

import core.messages.BuyOrSellOrder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class OrderEncoder extends MessageToByteEncoder<BuyOrSellOrder> {

	@Override
	protected void encode(ChannelHandlerContext context, BuyOrSellOrder message, ByteBuf out) throws Exception {
		final Charset charset = Charset.forName("UTF-8");
		out.writeInt(message.getTypeLength());
		out.writeCharSequence(message.getMessageType(), charset);
		out.writeInt(message.getActionLength());
		out.writeCharSequence(message.getMessageAction(), charset);
		out.writeInt(message.getId());
		out.writeInt(message.getInstrumentLength());
		out.writeCharSequence(message.getInstrument(), charset);
		out.writeInt(message.getMarketId());
		out.writeInt(message.getPrice());
		out.writeInt(message.getQuantity());
		out.writeInt(message.getChecksumLength());
		out.writeCharSequence(message.getChecksum(), charset);
	}
}