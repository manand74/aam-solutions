import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class First {

	public static void main(String[] args) throws Exception{
		RandomAccessFile aFile = null;
		FileChannel inChannel  = null;
		try{
			aFile 				   = new RandomAccessFile("data/nio-data.dat", "rw");
			inChannel  			   = aFile.getChannel();
			ByteBuffer buff 	   = ByteBuffer.allocate(50); //wrapper object over a memory block
			int bytesRead          = inChannel.read(buff);  // read into buffer or writing data into buffer
			
			while(bytesRead != -1){ //1
				System.out.println("read " + bytesRead);
				buff.flip();   // makes buffer ready for read
				
				while(buff.hasRemaining()){ //2
					System.out.println((char)buff.get());   // read 1 byte at a time
				} //end of while 2
				
				buff.clear();   // make buffer ready for writing.
				bytesRead = inChannel.read(buff);
			} // end of while 1
		
		}
		finally{
			if(inChannel != null){
				inChannel.close();
			}
			if(aFile != null){
				aFile.close();
			}
		}
	}

}
