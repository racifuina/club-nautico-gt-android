package com.panatlanticdev.clubnauticogt;

import com.parse.ParseUser;

import java.util.Date;

/**
 * The Class Conversation is a Java Bean class that represents a single chat
 * conversation message.
 */
public class Conversation {

	/** The Constant STATUS_SENDING. */
	public static final int STATUS_SENDING = 0;

	/** The Constant STATUS_SENT. */
	public static final int STATUS_SENT = 1;

	/** The Constant STATUS_FAILED. */
	public static final int STATUS_FAILED = 2;
	/** The msg. */
	private String msg;

	/** The status. */
	private int status = STATUS_SENT;

	/** The date. */
	private Date date;

	/** The sender. */
	private String sender;

	private String senderDisplay;

	/**
	 * Instantiates a new conversation.
	 * 
	 * @param msg
	 *            the msg
	 * @param date
	 *            the date
	 * @param sender
	 *            the sender
	 */
	public Conversation(String msg, Date date, String sender, String senderDisplay)
	{
		this.msg = msg;
		this.date = date;
		this.sender = sender;
		this.senderDisplay = senderDisplay;
	}

	/**
	 * Instantiates a new conversation.
	 */
	public Conversation()
	{
	}

	/**
	 * Gets the msg.
	 * 
	 * @return the msg
	 */
	public String getMsg()
	{
		return msg;
	}

	public String getSenderDisplay()
	{
		return senderDisplay;
	}

	/**
	 * Sets the msg.
	 * 
	 * @param msg
	 *            the new msg
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public void setSenderDisplay(String senderDisplay)
	{
		this.senderDisplay = senderDisplay;
	}

	/**
	 * Checks if is sent.
	 * 
	 * @return true, if is sent
	 */
	public boolean isSent()
	{
		return ParseUser.getCurrentUser().getObjectId().equals(sender);
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * Gets the sender.
	 * 
	 * @return the sender
	 */
	public String getSender()
	{
		return sender;
	}

	/**
	 * Sets the sender.
	 * 
	 * @param sender
	 *            the new sender
	 */
	public void setSender(String sender)
	{
		this.sender = sender;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

}
