package Model;

import java.util.ArrayList;

public class buffer_msgs {
ArrayList<String> msgs;
sensor sugarRead;

public buffer_msgs() {
	msgs=new ArrayList<String>();
}
public buffer_msgs(sensor sugarRead) {
	msgs=new ArrayList<String>();
	this.sugarRead=sugarRead;
}
public ArrayList<String> getBufferedMsgs(){
	return msgs;
}
}
