package input;

import java.util.ArrayList;
import java.util.List;

import commands.DocumentWriter;

public class WriterAtbashDecorator extends WriterDecorator {

	private DocumentWriter componentWriter;
	
	public WriterAtbashDecorator(DocumentWriter componentWriter) {
		super(componentWriter);
		// TODO Auto-generated constructor stub
	}

	public void write(List<String> contents) {
		List<String> encodedContents=new ArrayList<String>();
		
		for(String token:contents) {
	        for (int i = 0; i < token.length(); i++) {
				if(token.charAt(i) >= 'a' && token.charAt(i) <= 'z') {
					encodedContents.add( (char) ('z' - token.charAt(i) + 'a')+"");
				}
			}
		}
		
		componentWriter.write(encodedContents);
	}

	public void setComponentWriter(DocumentWriter writer) {
		this.componentWriter=writer;
	}
}
