package trivera.core.employee;

public interface Mailable {
	public Note createNote();
	public Note createNote(String to);
	public Note createNote(String to, String cc);
	public Note createNote(String to, String cc, String body);
	public void sendNote(Note note);
	
}
