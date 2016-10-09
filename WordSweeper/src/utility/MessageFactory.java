/**
 * 
 */
package Utility;

import external.xml.Message;

/**
 * @author quangvu
 *
 */
public class MessageFactory {
	
	/** 
	 * @return the new ConnectRequest XML message
	 */
	public static Message connectRequest() {
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		
		return new Message(xmlString);
	}
	
	/**
	 * @param name The name of the player
	 * @return the new CreateGame XML message
	 */
	public static Message createGameRequest(String name) {
		String xmlString = Message.requestHeader() + "<createGameRequest name='"+ name +"'/></request>";
		
		return new Message (xmlString);
	}

}
