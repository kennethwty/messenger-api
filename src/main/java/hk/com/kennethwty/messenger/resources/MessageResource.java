package hk.com.kennethwty.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hk.com.kennethwty.messenger.model.Message;
import hk.com.kennethwty.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message msg) {
		return messageService.addMessage(msg);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message msg) {
		msg.setId(id);
		return messageService.updateMessage(msg);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long msgId) {
		return messageService.getMessage(msgId);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void updateMessage(@PathParam("messageId") long id) {
		messageService.deleteMessage(id);
	}
}
