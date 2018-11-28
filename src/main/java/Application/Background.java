public class Background extends Attribute {
	
	String title;	// variable title denotes which background this object contains
	
	public Background () {
		setType("Background");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
}