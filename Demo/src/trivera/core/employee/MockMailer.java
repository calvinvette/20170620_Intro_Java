package trivera.core.employee;

public class MockMailer implements Mailable {

	@Override
	public Note createNote() {
		return createNote(null, null, null);
	}

	@Override
	public Note createNote(String to) {
		return createNote(to, null, null);
	}

	@Override
	public Note createNote(String to, String cc) {
		return createNote(to, cc, null);
	}

	@Override
	public Note createNote(String to, String cc, String body) {
		Note n = new Note();
		n.setTo(to);
		n.setCc(cc);
		n.setBody(body);
		return n;
	}

	@Override
	public void sendNote(Note note) {
		System.out.println("Sending Note!");
		System.out.println("To: " + note.getTo());
		System.out.println("CC: " + note.getCc());
		System.out.println("Message: " + note.getBody());

	}

}
