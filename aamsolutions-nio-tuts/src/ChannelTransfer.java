import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransfer {

	public static void main(String[] args) throws Exception{
		RandomAccessFile fromFile = null;
		RandomAccessFile toFile   = null;
		FileChannel      fromChannel = null;
		FileChannel      toChannel   = null;
		try{
			fromFile = new RandomAccessFile("data/from-data.dat", "r");
			toFile   = new RandomAccessFile("data/to-data.dat", "rw");
		
			fromChannel = fromFile.getChannel();
			toChannel   = toFile.getChannel();
			
			long position = 0;
			long count = fromChannel.size();
			
			//fromChannel.transferTo(position, count, toChannel);
			toChannel.transferFrom(fromChannel, position, count);
		}
		finally{
			if(fromChannel != null){
				fromChannel.close();
			}
			
			if(fromFile != null){
				fromFile.close();
			}
			
			if(toChannel != null){
				toChannel.close();
			}
			
			if(toFile != null){
				toFile.close();
			}
		}

	}

}
