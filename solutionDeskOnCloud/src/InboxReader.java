import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class InboxReader {

	public static void main(String args[]) {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
			try {
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore("imaps");
				System.out.println("teds");
				store.connect("imap.gmail.com", "jamil2049", "erere");
				System.out.println(store);
				System.out.println("ted2");
				Folder inbox = store.getFolder("Inbox");
				inbox.open(Folder.READ_ONLY);
				Message messages[] = inbox.getMessages();
				for(Message message:messages) {
				System.out.println(message);
				System.out.println("get content: "+message.getContent());
				System.out.println("get deposition: "+message.getDescription());
				System.out.println("get getDisposition: "+message.getDisposition());
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(2);
		}

	}

}